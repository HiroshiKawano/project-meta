package com.meta.db;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="libraryapi")
public class LibraryApi {

	@Id private int id ;
	private String category;
	private String city;
	private String shortname;
	private String tel;
	private String pref;
	private String faid;
	private String geocode;
	private String systemid;
	private String address;
	private Integer libid;
	private String libkey;
	private String post;
	private String url_pc;
	private String systemname;
	private String isil;
	private String formal;
	private String lat;
	private String lng;

	public String getLat() {
		return lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public int getId() {
		return id;
	}
	public String getCategory() {
		return category;
	}
	public String getCity() {
		return city;
	}
	public String getShortname() {
		return shortname;
	}
	public String getTel() {
		return tel;
	}
	public String getPref() {
		return pref;
	}
	public String getFaid() {
		return faid;
	}
	public String getGeocode() {
		return geocode;
	}
	public String getSystemid() {
		return systemid;
	}
	public String getAddress() {
		return address;
	}
	public Integer getLibid() {
		return libid;
	}
	public String getLibkey() {
		return libkey;
	}
	public String getPost() {
		return post;
	}
	public String getUrl_pc() {
		return url_pc;
	}
	public String getSystemname() {
		return systemname;
	}
	public String getIsil() {
		return isil;
	}
	public String getFormal() {
		return formal;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setPref(String pref) {
		this.pref = pref;
	}
	public void setFaid(String faid) {
		this.faid = faid;
	}
	public void setGeocode(String geocode) {
		this.geocode = geocode;
	}
	public void setSystemid(String systemid) {
		this.systemid = systemid;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setLibid(Integer libid) {
		this.libid = libid;
	}
	public void setLibkey(String libkey) {
		this.libkey = libkey;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public void setUrl_pc(String url_pc) {
		this.url_pc = url_pc;
	}
	public void setSystemname(String systemname) {
		this.systemname = systemname;
	}
	public void setIsil(String isil) {
		this.isil = isil;
	}
	public void setFormal(String formal) {
		this.formal = formal;
	}


}
