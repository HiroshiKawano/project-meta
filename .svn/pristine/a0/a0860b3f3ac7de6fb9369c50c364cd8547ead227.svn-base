package com.meta.db;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="searchhistory")
public class SearchHistoryDB {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title; //図書名
	private String authorname; //著者名
	private String publishername; //出版社
	private Date publicationyear; //出版年
	private String subject; //件名
	private String classification; //分類
	private String isbn; //ISBN
	private Date date; //検索日時
	private int userID; //検索したUserのID

	public Integer getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthorname() {
		return authorname;
	}
	public String getPublishername() {
		return publishername;
	}
	public Date getPublicationyear() {
		return publicationyear;
	}
	public String getSubject() {
		return subject;
	}
	public String getClassification() {
		return classification;
	}
	public String getIsbn() {
		return isbn;
	}
	public Date getDate() {
		return date;
	}
	public int getUserID() {
		return userID;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public void setPublishername(String publishername) {
		this.publishername = publishername;
	}
	public void setPublicationyear(Date publicationyear) {
		this.publicationyear = publicationyear;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}

	//getter郡

}
