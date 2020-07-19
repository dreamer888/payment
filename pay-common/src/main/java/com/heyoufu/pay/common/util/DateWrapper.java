package com.heyoufu.pay.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateWrapper {
	
	public static final String YYYYMMDDHH24MMSS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYYMMDDHH12MMSS = "yyyy-MM-dd hh:mm:ss";
	public static final String YYYYMMDD = "yyyy-MM-dd";
	public static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_TIME12 = "yyyy-MM-dd hh:mm:ss";
	public static final String DATE = "yyyy-MM-dd";
	private Date date;

	public DateWrapper(String date, String format) throws ParseException {
		SimpleDateFormat formatdate = new SimpleDateFormat(format,
				Locale.getDefault());
		this.date = formatdate.parse(date);
	}

	public DateWrapper(Date date) {
		this.date = date;
	}

	public String toString(String format) {
		return new SimpleDateFormat(format, Locale.getDefault())
				.format(this.date);
	}

	public String toString() {
		return toString("yyyy-MM-dd HH:mm:ss");
	}

	public int toTime() {
		return (int) (this.date.getTime() / 1000L);
	}

	public Date toDate() {
		return this.date;
	}

	public String toChinese(String formart) {
		return null;
	}

	public int pastTime() {
		return ((int) (new Date().getTime() / 1000L) - toTime());
	}

}
