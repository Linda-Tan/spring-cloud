package com.demo.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	
	public void test(){
		
	}
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
		
	}

}
