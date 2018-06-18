package com.simoncat.front.dao;

import java.util.List;

import com.simoncat.front.dto.EssayDto;

public interface EssayDao {

	List<EssayDto> loadAll();

	List<EssayDto> loadAll(int page);
	
	int getTotalCount();
}
