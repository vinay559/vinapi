package com.vin.httpcore;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.SecureRandom;

import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpRequests {

	static CloseableHttpClient client;

	public static HttpClient getHttpsClient() throws Exception {
		
		
//		if (client != null) {
//			return client;
//		}
		SSLContext sslcontext = SSLContext.getInstance("SSL");
		sslcontext.init(null, new X509TrustManager[] { new HttpsTrustManager() }, new SecureRandom());
		SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(sslcontext,
				SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
		client = HttpClients.custom().setSSLSocketFactory(factory).build();

		return client;
	}

	public static String httpGet(String url) throws Exception {

		HttpClient client = getHttpsClient();
		System.out.println("Request URL : " + url);

		HttpGet getRequest = new HttpGet(url);
		getRequest.addHeader("accept", "application/json");

		HttpResponse response = client.execute(getRequest);

		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = br.readLine()) != null) {
			result.append(line);
		}

		System.out.println("Response Content : " + result);
		return result.toString();
	}

}
