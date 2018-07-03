package com.simoncat.front.utils;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

import lombok.Getter;

public class EssayDateConvertor {

	@Getter
	public static class EssayDate {
		private final String year;
		private final String month;
		private final String monthSuffix;
		private final String day;

		private EssayDate(int year, Month month, int day) {
			this.year = Integer.toString(year);
			this.month = month.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
			this.monthSuffix = "";
			this.day = Integer.toString(day);
		}
	}

	public static EssayDate convertToMonth(Date date) {
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return new EssayDate(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth());
	}
}
