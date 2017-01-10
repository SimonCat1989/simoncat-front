package com.simoncat.front.cableaccess.dao;

import java.util.Collection;

import com.simoncat.front.cableaccess.dto.WorkSheetDto;
import com.simoncat.front.cableaccess.status.WorkSheetStatus;

public interface WorkSheetDao {

	Collection<WorkSheetDto> getSheets(WorkSheetStatus status);
}
