package org.unicome.demo.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date getDate(int i) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, i);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
}
