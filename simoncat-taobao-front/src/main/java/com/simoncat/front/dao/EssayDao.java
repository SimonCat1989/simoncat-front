package com.simoncat.front.dao;

import java.util.List;
import java.util.Optional;

import com.simoncat.front.dto.EssayDto;

public interface EssayDao {

	List<EssayDto> loadAll();

	List<EssayDto> loadAll(int page);
	
	int getTotalCount();
	
	Optional<EssayDto> loadEssay(long id);
}
