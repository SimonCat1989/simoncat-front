package com.simoncat.front;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.simoncat.front.dao.HibernateUtil;
import com.simoncat.front.dto.BookDto;
import com.simoncat.front.dto.BookTypeDto;
import com.simoncat.front.dto.EssayCommentDto;
import com.simoncat.front.dto.EssayDto;

public class InitDatabase {

    private static final JSONParser parser = new JSONParser();

    @SuppressWarnings("unchecked")
    @Test
    public void init() throws JsonParseException, JsonMappingException, IOException, ParseException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Map<Long, BookTypeDto> bookTypeList = (Map<Long, BookTypeDto>) ((JSONArray) parser.parse(new FileReader(Paths
                .get(this.getClass().getResource("/").getPath(), "assets", "book_type.json").toFile()))).stream()
                .collect(
                        Collectors.toMap(bookTypeJson -> (long) ((JSONObject) bookTypeJson).get("id"),
                                bookTypeJson -> {
                                    JSONObject json = (JSONObject) bookTypeJson;
                                    return BookTypeDto.of((String) json.get("type"));
                                }));

        Map<String, BookDto> bookList = (Map<String, BookDto>) ((JSONArray) parser.parse(new FileReader(Paths.get(
                this.getClass().getResource("/").getPath(), "assets", "book.json").toFile())))
                .stream()
                .map(bookJson -> {
                    JSONObject json = (JSONObject) bookJson;
                    return BookDto.of((String) json.get("name"), (String) json.get("author"),
                            bookTypeList.get(json.get("type")), (String) json.get("cover"),
                            (String) json.get("description"));
                }).collect(Collectors.toMap(BookDto::getName, dto -> dto));

        Set<EssayDto> EssayList = (Set<EssayDto>) ((JSONArray) parser.parse(new FileReader(Paths.get(
                this.getClass().getResource("/").getPath(), "assets", "recommend.json").toFile())))
                .stream()
                .map(recommendJson -> {
                    JSONObject json = (JSONObject) recommendJson;

                    EssayDto essay = EssayDto.of((String) json.get("title"), (String) json.get("author"),
                            (String) json.get("authorAvatar"), (String) json.get("createMonth"),
                            (String) json.get("createMonthSuffix"), (String) json.get("createDay"),
                            (String) json.get("createYear"), (Integer) json.get("comment"),
                            (Integer) json.get("heart"), (Integer) json.get("twitter"), (Integer) json.get("facebook"),
                            (String) json.get("keyword"), (String) json.get("description"));

                    Set<EssayCommentDto> essayComments = (Set<EssayCommentDto>) ((JSONArray) json.get("books"))
                            .stream()
                            .map(commentJson -> {
                                JSONObject json1 = (JSONObject) commentJson;
                                return EssayCommentDto.of((String) json1.get("content"), essay,
                                        bookList.get((String) json1.get("name")));
                            }).collect(Collectors.toSet());

                    essay.setEssayComments(essayComments);

                    return essay;
                }).collect(Collectors.toSet());

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

        // BookDto dto = session.load(BookDto.class, 1);
        // System.out.println(dto.getType().getType());

        // RecommendationDto dto1 = session.load(RecommendationDto.class, 1);
        // System.out.println(dto1.getDescription());
    }
}
