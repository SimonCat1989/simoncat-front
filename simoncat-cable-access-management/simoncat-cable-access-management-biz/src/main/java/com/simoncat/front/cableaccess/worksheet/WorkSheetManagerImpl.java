package com.simoncat.front.cableaccess.worksheet;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.simoncat.front.cableaccess.dao.WorkSheetDao;
import com.simoncat.front.cableaccess.dto.WorkSheetDto;
import com.simoncat.front.cableaccess.status.WorkSheetStatus;

class WorkSheetManagerImpl implements WorkSheetManager {

	@Autowired
	private WorkSheetDao workSheetDao;

	@Override
	public Collection<WorkSheetDto> fetchPendingSheets() {
		return workSheetDao.getSheets(WorkSheetStatus.PENDDING);
	}

	@Override
	public Collection<WorkSheetDto> fetchWorkingSheets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<WorkSheetDto> fetchSubmittingSheets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<WorkSheetDto> fetchSubmittedSheets() {
		// TODO Auto-generated method stub
		return null;
	}

}
