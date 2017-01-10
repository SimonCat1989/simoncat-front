package com.simoncat.front.cableaccess.worksheet;

import java.util.Collection;

import com.simoncat.front.cableaccess.dto.WorkSheetDto;

public interface WorkSheetManager {

	Collection<WorkSheetDto> fetchPendingSheets();

	Collection<WorkSheetDto> fetchWorkingSheets();

	Collection<WorkSheetDto> fetchSubmittingSheets();

	Collection<WorkSheetDto> fetchSubmittedSheets();
}
