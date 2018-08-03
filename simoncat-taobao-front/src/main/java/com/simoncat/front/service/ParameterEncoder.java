package com.simoncat.front.service;

import java.io.IOException;
import java.net.URI;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ParameterEncoder {
 
	public static String encode(String requestUrl) {
		
		String resultString = "";
		CloseableHttpResponse response = null;
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
			// 创建uri
			URIBuilder builder = new URIBuilder("http://api.ft12.com/api.php?url=" + requestUrl);
			URI uri = builder.build();
 
			// 创建http GET请求
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
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}
	public static void main(String[] args) {
		System.out.println(encode("http:/www.baidu.com/RtaF3MhB"));
	}

}
