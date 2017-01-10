package com.simoncat.front.cableaccess.worksheet;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;
import com.simoncat.front.cableaccess.dto.ConnectionDto;
import com.simoncat.front.cableaccess.dto.StationDto;
import com.simoncat.front.cableaccess.dto.WorkSheetDto;

class WorkSheetManagerImpl implements WorkSheetManager {

	@Override
	public Collection<WorkSheetDto> fetchPendingSheets() {
		List<WorkSheetDto> pendingSheets = Lists.newArrayList();
		List<StationDto> stations = Lists.newArrayList();
		StationDto stationDto = new StationDto("青浦供电公司", ConnectionDto.EMPTY, new ConnectionDto(
		        "三级网青青0000(I)PTK16", Lists.newArrayList(5, 6), 0));
		StationDto stationDto2 = new StationDto("220kv青浦变电站（通）", new ConnectionDto("三级网青青0000(I)PTK16",
		        Lists.newArrayList(5, 6), 0), ConnectionDto.EMPTY);
		stations.add(stationDto);
		stations.add(stationDto2);
		WorkSheetDto dto = new WorkSheetDto(false, "上海市电力公司话路运动", "沪电调通第20160697号",
		        "青浦供电公司-220kv干练变电站华为10G（光缆）", "华为三级网", new Date(), "光纤", 0, stations);
		pendingSheets.add(dto);
		return pendingSheets;
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
