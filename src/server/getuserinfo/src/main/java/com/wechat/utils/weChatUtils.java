package com.wechat.utils;

import java.io.IOException;
import java.net.URI;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

/**
 * @author XiaoWu
 *
 */
/**
 * @author XiaoWu
 *
 */
final public class weChatUtils {

	private Map<String,String> params = new HashMap<String,String>();

	private String appid = "wxe8c01284a821705f";

	private String secret = "69b46f976ef82555276b595ba4218a35";

	private String grant_type = "authorization_code";

	private  String WeChatUri = "https://api.weixin.qq.com/sns/jscode2session";

	public weChatUtils(String js_code) {
		this.params.put("appid", appid);
		this.params.put("secret", secret);
		this.params.put("js_code", js_code);
		this.params.put("grant_type", grant_type);
	}


	/**
	 * 获取用户的唯一标识openid
	 * @return
	 * @throws Exception
	 */
	public String getOpenId() throws Exception {
		Map<String, Object> result = JSON.parseObject(requestWX());
		String openid = result.get("openid").toString() == null ? "":result.get("openid").toString();
		String session_key =  result.get("session_key").toString() == null ? "":result.get("openid").toString();
		if(openid == null) {
			throw new Exception("get openid failed");
		}else if(session_key  == null) {
			throw new Exception("get session_key failed");
		}
		return openid;
	}


	private String requestWX( ){
		CloseableHttpClient httpclient = HttpClients.createDefault();

		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(WeChatUri);
			if (params != null) {
				for (String key : params.keySet()) {
					builder.addParameter(key, params.get(key));
				}
			}
			URI uri = builder.build();

			// 创建http GET请求

			System.out.println(uri.toString());
			HttpGet httpGet = new HttpGet(uri);

			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;

	}



	/**
	 * 解析微信服务器的encryptedData内容
	 * @param encryptedData
	 * @param iv
	 * @return
	 */
	public String analyzeEncryptedData(String encryptedData,String iv) {

		Map<String, Object> result = JSON.parseObject(requestWX());
		byte[] result_out = null;
		Cipher cipher = null;
		byte[] seesion_key_de64 =  Base64.decodeBase64(result.get("openid").toString().getBytes());
		byte[] encrypyen_64 =  Base64.decodeBase64(encryptedData.getBytes());
		byte[] iv_de64 =  Base64.decodeBase64(iv.getBytes());

		try {
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
			cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}  
		Key sKeySpec = new SecretKeySpec(seesion_key_de64, "AES");  
		try {
			cipher.init(Cipher.DECRYPT_MODE, sKeySpec, generateIV(iv_de64));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}// 初始化  

		try {
			result_out = cipher.doFinal(encrypyen_64);
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}  
		return new String(result_out);  
	}

	public  AlgorithmParameters generateIV(byte[] iv) throws Exception{  
		AlgorithmParameters params = AlgorithmParameters.getInstance("AES");  
		params.init(new IvParameterSpec(iv));  
		return params;  
	}  

}
