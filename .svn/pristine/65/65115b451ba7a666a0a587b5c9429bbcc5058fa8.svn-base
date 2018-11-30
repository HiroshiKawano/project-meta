package com.meta.db.Dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity //DBから特定の列のデータを持ってきてオブジェクトに代入
@Component //JavaBeanとして登録するクラス
@Table(name="libraryapi") // ⑧Itemテーブルと接続
public class Item {
@Id private int id;
	private String libkey;
	private String lat;
	private String lng;
	private String address;
	private String tel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibkey() {
		return libkey;
	}
	public void setLibkey(String libkey) {
		this.libkey = libkey;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
