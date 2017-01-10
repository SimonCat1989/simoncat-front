package com.simoncat.front.cableaccess.dao;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;

import com.simoncat.framework.json.api.JsonOperator;
import com.simoncat.framework.json.core.JacksonJsonOperator;
import com.simoncat.framework.json.exception.InvalidJsonConversionException;
import com.simoncat.front.cableaccess.dto.WorkSheetDto;
import com.simoncat.front.cableaccess.setting.WorkSheetSetting;
import com.simoncat.front.cableaccess.status.WorkSheetStatus;

public class WorkSheetJsonDaoImplTest {

	private static final WorkSheetSetting setting = new WorkSheetSetting();
	private static final JsonOperator operator = new JacksonJsonOperator();
	private static WorkSheetDao workSheetJsonDao;

	@BeforeClass
	public static void setup() {
		setting.setJsonFileRootPath(WorkSheetJsonDaoImplTest.class.getResource("/").getPath());
		setting.setJsonWorkSheetFileName("test.json");
		workSheetJsonDao = new WorkSheetJsonDaoImpl(setting, operator);
	}

	@Test
	public void testGetSheets() throws InvalidJsonConversionException {
		Collection<WorkSheetDto> pendingSheets = workSheetJsonDao.getSheets(WorkSheetStatus.PENDDING);
		assertTrue("should get 1 sheets in pending", pendingSheets.size() == 1);
	}
}
