package com.meta.db;

import java.io.StringReader;

import javax.xml.bind.JAXB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {

	@Autowired SearchHistoryDB shDB;

	private final String[] okinawa = new String[] {
			  "Okinawa_Chatan",
			  "Okinawa_Ginowan",
			  "Okinawa_Ginoza",
			  "Okinawa_Haebaru",
			  "Okinawa_Ishigaki",
			  "Okinawa_Itoman",
			  "Okinawa_Kadena",
			  "Okinawa_Kin",
			  "Okinawa_Kitanakagusuku",
			  "Okinawa_Miyakojima_Hirara",
			  "Okinawa_Nago",
			  "Okinawa_Naha",
			  "Okinawa_Nakanojyo",
			  "Okinawa_Nanjo",
			  "Okinawa_Nishihara",
			  "Okinawa_Okinawa",
			  "Okinawa_Onna",
			  "Okinawa_Pref",
			  "Okinawa_Tomigusuku",
			  "Okinawa_Urasoe",
			  "Okinawa_Uruma",
			  "Okinawa_Yaese",
			  "Okinawa_Yomitani",
			  "Okinawa_Yonabaru",
			  "Special_Affrc",
			  "Special_Nt_Okinawa",
			  "Special_Tiruru",
			  "Univ_Meio",
			  "Univ_Ocjc",
			  "Univ_Okigei",
			  "Univ_Okijo",
			  "Univ_Okinawa",
			  "Univ_Okinawa_Ct",
			  "Univ_Okinawa_Nurs",
			  "Univ_Okiu",
			  "Univ_Ryukyu"
	};

	private final String URL =
		"http://api.calil.jp/check?appkey=f284930445600eb8c4a8f4e17de0fb06&isbn=";


	public BookXML service(String isbn) throws Exception {

		String url = URL + isbn + "&systemid=" ;

				for(int i = 0; i <= okinawa.length-1; i++) {
					url += okinawa[i] + "," ;
				}

				url +=  "&format=xml";

				//System.out.println(url);

				RestTemplate restTemplate = new RestTemplate();

				ResponseEntity<String> responseEntity =
						restTemplate.getForEntity(url, String.class,String.class);

				String xml = responseEntity.getBody();

				//exam(polling)--
				System.out.println("exam(polling) stage01");
				final String _prefix = "<continue>";
				final int _preIdx = xml.indexOf(_prefix) + _prefix.length();

				final String _suffix = "</continue>";
				final int _sufIdx = xml.indexOf(_suffix);
				System.out.println("exam(polling) stage02");
				System.out.println(xml.substring(_preIdx, _sufIdx));
				while(xml.substring(_preIdx, _sufIdx).equals("1")) {
					System.out.println("exam(polling) stage03");
				long waitChkTime = 2000;
				try {
					Thread.sleep(waitChkTime);
					responseEntity = restTemplate.getForEntity(url, String.class,String.class);
					xml = responseEntity.getBody();
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				//--exam(polling)

				BookXML xxx = JAXB.unmarshal(new StringReader(xml), BookXML.class);

				System.out.println(xml);

				System.out.println(xxx.getSession());
				System.out.println(xxx.getCon());
				System.out.println(xxx.getBooklist());
				System.out.println(xxx.getBooklist().get(0).getBs());
				//System.out.println(xxx.getBooklist().get(0).getBs().get(0).getStatus());
				//System.out.println(xxx.getBooklist().get(0).getBs().get(0).getReserveurl());
				//System.out.println(xxx.getBooklist().get(0).getBs().get(0).getLibkeys().get(0).getLibStatus());
				//System.out.println(xxx.getBooklist().get(0).getBs().get(0).getLibkeys().get(0).getLibName());

		return xxx;
	}
}
