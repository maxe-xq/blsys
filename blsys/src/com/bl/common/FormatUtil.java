package com.bl.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat();
	public static String DateToStr(Date date, String pattern){
		sdf.applyPattern(pattern);	
		return sdf.format(date);
	}
	public static boolean isEmptyString(String obj){
		if(obj==null || "".equals(obj)){
			return true;
		}
		return false;
	}
	public static int[] objectToInt(Integer[] a){
		int[] b = new int[a.length];
		for(int i=0; i< a.length; i++){
			b[i] = a[i];
		}
		return b;
	}
}
