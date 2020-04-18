package com.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import com.sun.jmx.snmp.Timestamp;

/**
 * 
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		/*boolean test = new Test().isDateFormat("2015");*/
//		if(test){
//			System.out.println("ƥ��");
//		}else{
//			System.out.println("��ƥ��");
//		}
		
		/*String s = "BOChnlReportConfirmInfoExt.bo";
		if ((!s.startsWith("BO") && !s.startsWith("IBO")) || s.endsWith(".bo")) {
			System.out.println("yes");
		}*/
		
		/*String s = "000";
		System.out.println(Integer.parseInt(s));*/
		
//		test("20161106");
		
		
		/*testSubString("+00000497.00");*/
		
		/*testSplitString("caihe|lumin1|2016-11-20|2016-11-22");*/
		
		
		/*if(Pattern.compile("^\\d+$").matcher("s007312312312").find()){
			System.out.println("是数字");
		}else{
			System.out.println("no");
		}*/
		
		try {
			String date = "20161201 00:00:00";
			DateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
			new Timestamp(df.parse(date).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	

	private static void testSplitString(String string) {
		String [] str = string.split("\\|");
		for(int i = 0;i<str.length;i++){
			System.out.println(str[i]);
		}
	}


	private static void testSubString(String string) {
		System.out.println(string.substring(1,string.length()));  
	}


	private static void test(String date) {
		try {
			SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd");
			Date d;
			d = sdf.parse(date);
			Calendar calendar = Calendar.getInstance(); 
			calendar.setTime(d);
			calendar.add(Calendar.DATE,-1);
			System.out.println(sdf.format(calendar.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private boolean isDateFormat(String kpiDate) {
		String yyyyMMFmt = "[0-9]{4}-((0[1-9])|(1[0-2]))"; // 2010-01 format
		Pattern p = Pattern.compile(yyyyMMFmt);

		boolean falg = false;

		if (p.matcher(kpiDate).matches()) {
			falg = true;
		} else {
			falg = false;
		}

		return falg;
	}
}
