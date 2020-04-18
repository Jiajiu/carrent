package com.jiu.sys.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 生成随机数工具
 * @author Jiu
 *
 */
public class RandomUtils {
	
	private static SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat sdf2=new SimpleDateFormat("yyyyMMddHHmmssSSS");
	private static SimpleDateFormat sdf3=new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
	private static Random random=new Random();
	
	/**
	 * 得到当前日期
	 * 
	 */
	public static String getCurrentDateForString() {
		return sdf1.format(new Date());
	}
	
	/**
	 * 生成文件名 使用时间+4位随机数
	 * @param suffix 文件名称
	 */
	public static String createFileNameUseTime(String fileName,String suffix) {
		String fileSuffix=fileName.substring(fileName.lastIndexOf("."),fileName.length());
		String time=sdf2.format(new Date());
		Integer num=random.nextInt(9000)+1000;
		return time+num+fileSuffix+suffix;
	}
	
	/**
	 * 生成文件名使用UUID
	 * @param fileName 文件名称
	 */
	public static String createFileNameUseUUID(String fileName) {
		String fileSuffix=fileName.substring(fileName.indexOf("."),fileName.length());
		return UUID.randomUUID().toString().replace("-", "").toUpperCase()+fileSuffix;
	}

	/**
	 * 根据时间+5位随机数组成字符串
	 * @param preffix
	 * @return
	 */
    public static String createRandomStringUseTime(String preffix) {
		return preffix+"_"+sdf3.format(new Date())+"_"+(random.nextInt(90000)+10000);
    }
}
