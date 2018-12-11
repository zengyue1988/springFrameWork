package com.moon.Java8.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

public class HelloBase64 {

	public static void main(String[] args) {
		String base64encodedString;
		try {
			base64encodedString = Base64.getEncoder().encodeToString("runoob?java8".getBytes("utf-8"));
			System.out.println(base64encodedString);
			byte[] base64decodedString = Base64.getDecoder().decode(base64encodedString);
			System.out.println(new String(base64decodedString, "utf-8"));
			
			base64encodedString = Base64.getUrlEncoder().encodeToString("moon?java8".getBytes("utf-8"));
			System.out.println(base64encodedString);
			byte[] base64decodedURLString = Base64.getUrlDecoder().decode(base64encodedString);
			System.out.println(new String(base64decodedURLString, "utf-8"));
			
			StringBuilder stringBuilder = new StringBuilder();
			for (int i=0; i<10; i++) {
				stringBuilder.append(UUID.randomUUID().toString());
			}
			byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
			String mimeString = Base64.getMimeEncoder().encodeToString(mimeBytes);
			System.out.println(mimeString);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
