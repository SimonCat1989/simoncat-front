package com.simoncat.front.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.simoncat.front.dao.EssayDao;
import com.simoncat.front.vo.EssayVo;
import com.simoncat.front.vo.SinglePageEssayListVo;
import com.simoncat.front.vo.SinglePageEssayVo;

public class EssayServiceImpl implements EssayService {

	@Autowired
	private EssayDao essayDao;

	@Override
	public SinglePageEssayListVo loadAll(EssayListOrderType type) {
		switch (type) {
		case BY_CREATION:
			return SinglePageEssayListVo.of(essayDao.getTotalCount(), 1,
					essayDao.loadAllByCreation().stream().map(SinglePageEssayVo::new).collect(Collectors.toList()));
		case BY_HEART:
			return SinglePageEssayListVo.of(essayDao.getTotalCount(), 1,
					essayDao.loadAllByCreation().stream().map(SinglePageEssayVo::new).collect(Collectors.toList()));
		default:
			return SinglePageEssayListVo.of(essayDao.getTotalCount(), 1,
					essayDao.loadAllByHostest().stream().map(SinglePageEssayVo::new).collect(Collectors.toList()));
		}
	}

	@Override
	public SinglePageEssayListVo loadAll(EssayListOrderType type, int page) {
		switch (type) {
		case BY_CREATION:
			return SinglePageEssayListVo.of(essayDao.getTotalCount(), page,
					essayDao.loadAllByCreation(page).stream().map(SinglePageEssayVo::new).collect(Collectors.toList()));
		case BY_HEART:
			return SinglePageEssayListVo.of(essayDao.getTotalCount(), page,
					essayDao.loadAllByCreation(page).stream().map(SinglePageEssayVo::new).collect(Collectors.toList()));
		default:
			return SinglePageEssayListVo.of(essayDao.getTotalCount(), page,
					essayDao.loadAllByHostest(page).stream().map(SinglePageEssayVo::new).collect(Collectors.toList()));
		}
	}

	@Override
	public Optional<EssayVo> loadEssay(long essayId) {
		return essayDao.loadEssay(essayId).map(EssayVo::new);
	}
}
