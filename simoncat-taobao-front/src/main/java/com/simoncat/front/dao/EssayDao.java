package com.simoncat.front.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;

import com.simoncat.front.dto.EssayDto;

public interface EssayDao {

	List<EssayDto> loadAllByCreation(Session session);

	List<EssayDto> loadAllByCreation(Session session, int page);
	
	List<EssayDto> loadAllByHostest(Session session);
	
	List<EssayDto> loadAllByHostest(Session session, int page);
	
	int getTotalCount(Session session);
	
	Optional<EssayDto> loadEssay(Session session, long id);
}
