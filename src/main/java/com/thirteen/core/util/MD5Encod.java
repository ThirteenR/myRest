package com.thirteen.core.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Encod {
	 /**
	    * 生成md5
	    * @param message
	    * @return String
	    */
	   public static String getMD5(String message) {
	       String md5str = "";
	           //1 创建个提供信息摘要算法的对象，初始化为md5算法对象
		   MessageDigest md = null;
		   try {
			   md = MessageDigest.getInstance("MD5");
		   //2 将消息变成byte数组
	           byte[] input = message.getBytes();

	           byte[] buff = md.digest(input);

	           md5str = bytesToHex(buff);
		   } catch (NoSuchAlgorithmException e) {
			   e.printStackTrace();
		   }
	       return md5str;
	   }

	   /**
	    * 二进制转十六进制
	    * @param bytes
	    * @return
	    */
	   public static String bytesToHex(byte[] bytes) {
	       StringBuffer md5str = new StringBuffer();
	       int digital;
	       for (int i = 0; i < bytes.length; i++) {
	            digital = bytes[i];

	           if(digital < 0) {
	               digital += 256;
	           }
	           if(digital < 16){
	               md5str.append("0");
	           }
	           md5str.append(Integer.toHexString(digital));
	       }
	       return md5str.toString();
	   }

}
