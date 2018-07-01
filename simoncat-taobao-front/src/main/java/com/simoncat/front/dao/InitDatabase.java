package com.simoncat.front.dao;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.simoncat.front.dto.BookDto;
import com.simoncat.front.dto.BookTypeDto;
import com.simoncat.front.dto.EssayCommentDto;
import com.simoncat.front.dto.EssayDto;

public class InitDatabase {

	private static final JSONParser parser = new JSONParser();

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException, ParseException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Map<Long, BookTypeDto> bookTypeList = (Map<Long, BookTypeDto>) ((JSONArray) parser.parse(new FileReader(
				Paths.get(InitDatabase.class.getResource("/").getPath(), "assets", "book_type.json").toFile()))).stream()
						.collect(Collectors.toMap(bookTypeJson -> (long) ((JSONObject) bookTypeJson).get("id"),
								bookTypeJson -> {
									JSONObject json = (JSONObject) bookTypeJson;
									return BookTypeDto.of((String) json.get("type"));
								}));

		Map<String, BookDto> bookList = (Map<String, BookDto>) ((JSONArray) parser.parse(
				new FileReader(Paths.get(InitDatabase.class.getResource("/").getPath(), "assets", "book.json").toFile())))
						.stream().map(bookJson -> {
							JSONObject json = (JSONObject) bookJson;
							return BookDto.of((String) json.get("name"), (String) json.get("author"),
									bookTypeList.get(json.get("type")), (String) json.get("cover"),
									(String) json.get("description"));
						}).collect(Collectors.toMap(BookDto::getName, dto -> dto));

		Set<EssayDto> EssayList = (Set<EssayDto>) ((JSONArray) parser.parse(new FileReader(
				Paths.get(InitDatabase.class.getResource("/").getPath(), "assets", "recommend.json").toFile()))).stream()
						.map(recommendJson -> {
							JSONObject json = (JSONObject) recommendJson;
							DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

							try {
								EssayDto essay = EssayDto.of((String) json.get("title"), (String) json.get("author"),
										(String) json.get("authorAvatar"),
										formatter.parse((String) json.get("createAt")),
										((Long) json.get("comment")).intValue(), ((Long) json.get("heart")).intValue(),
										((Long) json.get("twitter")).intValue(),
										((Long) json.get("facebook")).intValue(), (String) json.get("keyword"),
										(String) json.get("description"));
								Set<EssayCommentDto> essayComments = (Set<EssayCommentDto>) ((JSONArray) json
										.get("books")).stream().map(commentJson -> {
											JSONObject json1 = (JSONObject) commentJson;
											EssayCommentDto dto = EssayCommentDto.of((String) json1.get("content"));
											dto.setBook(bookList.get((String) json1.get("name")));
											dto.setEssay(essay);
											return dto;
										}).collect(Collectors.toSet());

								essay.setEssayComments(essayComments);

								return essay;
							} catch (java.text.ParseException e) {
								e.printStackTrace();
							}
							return null;
						}).filter(Objects::nonNull).collect(Collectors.toSet());

		bookTypeList.values().stream().forEach(dto -> {
			session.saveOrUpdate(dto);
		});
		bookList.values().stream().forEach(dto -> {
			session.saveOrUpdate(dto);
		});
		EssayList.stream().forEach(dto -> {
			session.saveOrUpdate(dto);
		});
		session.getTransaction().commit();

		BookTypeDto dto = session.load(BookTypeDto.class, 1L);
		System.out.println(dto.getType());
		BookTypeDto dto2 = session.load(BookTypeDto.class, 2L);
		System.out.println(dto2.getType());
	}
}
