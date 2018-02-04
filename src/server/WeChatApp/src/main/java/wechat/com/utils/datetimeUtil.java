package wechat.com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import wechat.com.common.normalConstant;

public class datetimeUtil {
	/**
	 * One day after today
	 */
	public static Date OneDayAfter(Date today) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		int day = calendar.get(Calendar.DATE);
		calendar.set(Calendar.DATE, day + 1);
		return calendar.getTime();
	}
	
	public static Date OneDayBegin(Date today) throws ParseException {
		SimpleDateFormat sdf = new 
				SimpleDateFormat(normalConstant.DATE);
		return sdf.parse(sdf.format(new Date()));
	}
}
