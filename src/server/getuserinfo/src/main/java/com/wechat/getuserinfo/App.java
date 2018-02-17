package com.wechat.getuserinfo;

import com.wechat.utils.weChatUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	
    	//构造函数由小程序端传送
    	weChatUtils wechatutil = new weChatUtils("001EnTYs1BHJ5c0UCd2t1uYFYs1EnTY9");
    	try {
			System.out.println(wechatutil.getOpenId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
    }
}
