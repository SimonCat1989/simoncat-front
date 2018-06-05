package com.simoncat.front.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import lombok.extern.slf4j.Slf4j;

import org.hibernate.Session;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simoncat.front.dao.HibernateUtil;
import com.simoncat.front.dto.BookDto;
import com.simoncat.front.vo.RecommendationVo;

@Slf4j
public class RecommendationServiceImpl implements RecommendationService {

	private static final ObjectMapper LOCAL_MAPPER = new ObjectMapper();
	
	@Override
	public RecommendationVo loadAll() {
		File contentFile = Paths.get(this.getClass().getResource("/").getPath(), "assets", "recommend.json").toFile();
		try {
			return LOCAL_MAPPER.readValue(contentFile, RecommendationVo.class);
		} catch (IOException e) {
			log.error("Can not read data from file {}", contentFile, e);
		}
		return RecommendationVo.EMPTY;
	}

	
	public static void main(String[] args) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
//	    session.beginTransaction();
//	    BookDto book = new BookDto(1, "打保健", "小虾米", "ser/cs/s/dse/sds.png", "打保健打保健打保健打保健打保健打保健打保健打保健打保健打保健");
//        session.save(book);
//        session.getTransaction().commit();
        
        BookDto dto = session.load(BookDto.class, 1);
        System.out.println(dto.getContent());
	}
}
