package com.browserstack;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
public class statusupdate {
	public static void mark() throws URISyntaxException, UnsupportedEncodingException, IOException {
		  URI uri = new URI("https://mudassarsyed2:8ZezGR6GyZjP2ZqrXphh@api.browserstack.com/automate/sessions/2a5870c077d0a12d05c48452454fb0cc3973e99f.json");
		  HttpPut putRequest = new HttpPut(uri);

		  ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		  nameValuePairs.add((new BasicNameValuePair("status", "failed")));
		  nameValuePairs.add((new BasicNameValuePair("reason", "")));
		  putRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));

		  HttpClientBuilder.create().build().execute(putRequest);
		}


}
