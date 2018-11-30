package com.meta.db;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="users")
public class UserDB {

	@Id private int userID; //UserID

	//@Patternでメールアドレスの正規表現を定義
	@Pattern
		(message="メールアドレスの形式で入力して下さい",
		regexp = "^[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+(\\.[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+)*+(.*)@[a-zA-Z0-9][a-zA-Z0-9\\-]*(\\.[a-zA-Z0-9\\-]+)+$")
	private String mail; //mailアドレス

	@Pattern
		(message="半角英数字のみ有効です",
		regexp = "[a-zA-Z0-9]+")
	@Size(min=8,message="パスワードは8桁以上で入力して下さい")
	private String pw; //パスワード

	//プロパティのsetter/getter
	public int getUserID() {
		return userID;
	}
	public String getMail() {
		return mail;
	}
	public String getPw() {
		return pw;
	}

	//setterでデータのDB出入時の制約を定める（後程記入）
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}




}
