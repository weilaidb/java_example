//获取当前时间
package com.DataCalenDar;

import java.util.Date;
import java.util.Calendar;

public class Date_Calendar_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		long now = System.currentTimeMillis();
		System.out.println("now = " + now);
		
		
		Date dl = new Date(now);
		System.out.println("dl = " + dl);
		
		Calendar cl = Calendar.getInstance();
		System.out.println("cl = " + cl.getTime().toString());
		
		
	}

}

//result
//now = 1459172273159
//dl = Mon Mar 28 21:37:53 CST 2016
//cl = Mon Mar 28 21:37:53 CST 2016

