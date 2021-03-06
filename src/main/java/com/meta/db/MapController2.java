package com.meta.db;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meta.db.Dto.Calil;
import com.meta.db.Dto.CalilRepository;
import com.meta.db.Dto.Item;
import com.meta.db.Dto.ItemRepository;

//⑤googleMapsへjson型式でデータを送る
@RestController
public class MapController2 {
	@Autowired CalilRepository calilrepos;
	@Autowired ItemRepository itemrepos; // DBに接続
	ObjectMapper mappter = new ObjectMapper(); //Mapper(java object→json型式)
	@RequestMapping(value="/rest") // Ajax通信で/restにアクセスがあった場合
	public String index() throws Exception {
        List<Calil> obj = calilrepos.findAll(); //DBの内容をManyCalil.javaを呼び出して全レコード格納

        List<Item>lib= new ArrayList<Item>(); //ItemテーブルのEntityを初期化
        for(Calil c: obj) {
        	System.out.println("getLibkey:" + c.getLibkey());
        	for(Item i : itemrepos.findByLibkey(c.getLibkey())) {
        		lib.add(i); //CalilテーブルのLibkeyでItemテーブルを検索
        	}
        }

        StringBuffer json = new StringBuffer(); //文字列を加工するため
        for(Item i: lib) { // 拡張for文でlibの内容をItem.javaの形式でiに代入していく
        	json.append(mappter.writeValueAsString(i) + ",");
            for(Calil c: obj) {
            	if(i.getLibkey().equals(c.getLibkey())){
            		String tmp = ", \"lending\" : \"" + c.getLending() + "\"";
            	    json.insert(json.length() - 2, tmp);
            	}
            }
        }//変換済json(最初は空)が、{a:1,b:2},{c:3,d:4},のようになるように足していく
        json.delete(json.length()-1, json.length());//最後の,を取り除く
        json.insert(0,"["); // 0番目(最初)に[を追加
        json.append("]");//最後に]を追加→[{a:1,b:2},{c:3,d:4}]の形にする
        System.out.println(json);
		return json.toString();
	}
}
