package com.meta.db;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LibraryService {
	private static final String URL =
			"http://api.calil.jp/library?appkey=f284930445600eb8c4a8f4e17de0fb06&pref=沖縄&format=json";


	public LibraryDto service() {

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> responseEntity =
				restTemplate.getForEntity(URL, String.class,String.class);
		LibraryDto libraryDto = null;

		try {
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(responseEntity.getBody());
			StringBuffer sb = new StringBuffer(responseEntity.getBody());
			sb.delete(0, 9);
			System.out.println(sb);
			sb.delete(sb.length()-2, sb.length());
			//json形式文字列を配列でもらうために必要なAPIのjsonにresultsの名前をインサート
			sb.insert(0, "{\"results\":");
			sb.append("}");
			System.out.println(sb);
			//shortの名前は使用不可　shortをshortnameに全変換
			String newStr = sb.toString().replaceAll("\"short\":", "\"shortname\":");
			System.out.println(newStr);
			libraryDto = mapper.readValue(newStr,LibraryDto.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return libraryDto;
	}
}
