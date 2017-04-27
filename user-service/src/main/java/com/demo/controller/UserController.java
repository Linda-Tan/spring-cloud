package com.demo.controller;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	
	public void test(){
		
	}
	/*
	public static void main(String[] args) {
		
		String cardBin="D Q R | 7 3 1 0 1 8 3 6 9 0 0 0 0 1 8 7 2 4 7 7 1 8 7 2 4 7 7 |  8 7 2 4 7 7";
		
		String temp2=cardBin.replaceAll(" ", "");
		System.out.println(temp2);
//		System.out.println(temp2.substring(6, 7));
		if(temp2.length()==27){
			System.out.println("SVC卡-实体卡");
			if(temp2.substring(0, 6).equals("731018")){
				System.out.println("星礼卡物理卡");
			}else if(temp2.substring(0, 6).equals("731012")){
				System.out.println("资和信发行的星礼卡");
			}else if(temp2.substring(0, 4).equals("7310")||temp2.substring(0, 4).equals("7320")){
				System.out.println("商通卡");
			}
			
		}else if(temp2.length()==36){
			if(temp2.substring(6, 7).equals("2")){
				System.out.println("SVC卡-电子卡");
				if(temp2.substring(0, 6).equals("731018")){
					System.out.println("电子星礼卡");
				}else if(temp2.substring(0, 6).equals("731029")){
					System.out.println("微信卖出的电子星礼卡");
				}
			} else if(temp2.substring(6, 7).equals("3")){
				System.out.println("券码-电子券");
				if(temp2.substring(0, 6).equals("731018")){
					System.out.println("电子券");
				}
			}
			
		}else if(temp2.length()==38){
			System.out.println("SVC卡-APP端星礼卡");
			
		}else if(temp2.length()==19){
			System.out.println("SVC卡-实体券");
			if(temp2.substring(6, 9).equals("001")){
				System.out.println("实体券（单张券编码-Moon cake");
			}else if(temp2.substring(6, 9).equals("005")){
				System.out.println("实体券（单张券编码-Dragon Dumpling");
			}else if(temp2.substring(6, 9).equals("002")){
				System.out.println("实体券（单张券编码-Partner Coupon");
			}else if(temp2.substring(6, 9).equals("003")){
				System.out.println("实体券（单张券编码-Retail B2B");
			}else if(temp2.substring(6, 9).equals("006")){
				System.out.println("实体券（单张券编码-咖啡护照");
			}else if(temp2.substring(6, 9).equals("007")){
				System.out.println("实体券（单张券编码-Thank you/Sorry/BOGO");
			}
			
		}else if(temp2.length()==18){
			System.out.println("实体券（整本编码）");
		}else if(temp2.length()==12){
			System.out.println("实体券（整箱编码）");
		}
		
	}*/
	public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        //字典序列排序  
        Map<String,String> paraMap = new HashMap<String,String>();  
        paraMap.put("total_fee","200");  
        paraMap.put("appid", "wxd678efh567hg6787");  
        paraMap.put("body", "腾讯充值中心-QQ会员充值");  
        paraMap.put("out_trade_no","20150806125346");  
        String url = formatUrlMap(paraMap, true, true);  
        System.out.println(UserController.SHA256(url));  
    } 
	
	/** 
	    *  
	    * 方法用途: 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序），并且生成url参数串<br> 
	    * 实现步骤: <br> 
	    *  
	    * @param paraMap   要排序的Map对象 
	    * @param urlEncode   是否需要URLENCODE 
	    * @param keyToLower    是否需要将Key转换为全小写 
	    *            true:key转化成小写，false:不转化 
	    * @return 
	    */  
	   public static String formatUrlMap(Map<String, String> paraMap, boolean urlEncode, boolean keyToLower)  
	   {  
	       String buff = "";  
	       Map<String, String> tmpMap = paraMap;  
	       try  
	       {  
	           List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(tmpMap.entrySet());  
	           // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）  
	           Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>()  
	           {  
	  
	               @Override  
	               public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2)  
	               {  
	                   return (o1.getKey()).toString().compareTo(o2.getKey());  
	               }  
	           });  
	           // 构造URL 键值对的格式  
	           StringBuilder buf = new StringBuilder();  
	           for (Map.Entry<String, String> item : infoIds)  
	           {  
	               if (StringUtils.isNotBlank(item.getKey()))  
	               {  
	                   String key = item.getKey();  
	                   String val = item.getValue();  
	                   if (urlEncode)  
	                   {  
	                       val = URLEncoder.encode(val, "utf-8");  
	                   }  
	                   if (keyToLower)  
	                   {  
	                       buf.append(key.toLowerCase() + "=" + val);  
	                   } else  
	                   {  
	                       buf.append(key + "=" + val);  
	                   }  
	                   buf.append("&");  
	               }  
	  
	           }  
	           buff = buf.toString();  
	           if (buff.isEmpty() == false)  
	           {  
	               buff = buff.substring(0, buff.length() - 1);  
	           }  
	       } catch (Exception e)  
	       {  
	          return null;  
	       }  
	       return buff;  
	   }  
	   
	   
	   public static String SHA256(final String strText)  
	   {  
	     return SHA(strText, "SHA-256");  
	   }
	   /** 
	    * 字符串 SHA 加密 
	    *  
	    * @param strSourceText 
	    * @return 
	    */  
	   private static String SHA(final String strText, final String strType)  
	   {  
	     // 返回值  
	     String strResult = null;  
	   
	     // 是否是有效字符串  
	     if (strText != null && strText.length() > 0)  
	     {  
	       try  
	       {  
	         // SHA 加密开始  
	         // 创建加密对象 并傳入加密類型  
	         MessageDigest messageDigest = MessageDigest.getInstance(strType);  
	         // 传入要加密的字符串  
	         messageDigest.update(strText.getBytes());  
	         // 得到 byte 類型结果  
	         byte byteBuffer[] = messageDigest.digest();  
	   
	         // 將 byte 轉換爲 string  
	         StringBuffer strHexString = new StringBuffer();  
	         // 遍歷 byte buffer  
	         for (int i = 0; i < byteBuffer.length; i++)  
	         {  
	           String hex = Integer.toHexString(0xff & byteBuffer[i]);  
	           if (hex.length() == 1)  
	           {  
	             strHexString.append('0');  
	           }  
	           strHexString.append(hex);  
	         }  
	         // 得到返回結果  
	         strResult = strHexString.toString();  
	       }  
	       catch (NoSuchAlgorithmException e)  
	       {  
	         e.printStackTrace();  
	       }  
	     }  
	   
	     return strResult;  
	   }  
	

}
