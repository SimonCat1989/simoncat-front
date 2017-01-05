package com.simoncat.front.cableacess.worksheet;

import java.util.List;

import com.simoncat.front.cableaccess.dto.WorkSheetDto;

public interface WorkSheetManager {

	List<WorkSheetDto> fetchPendingSheets();

	List<WorkSheetDto> fetchWorkingSheets();

	List<WorkSheetDto> fetchSubmittingSheets();

	List<WorkSheetDto> fetchSubmittedSheets();
}
