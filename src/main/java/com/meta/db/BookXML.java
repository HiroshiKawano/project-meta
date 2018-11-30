package com.meta.db;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="result")
public class BookXML {
	private String session;

	private String con;

	private List<Book> booklist ;

    @XmlElementWrapper(name="books")
    @XmlElement(name="book")
    public List<Book> getBooklist() {
        return booklist;
    }

    @XmlElement(name="continue")
	public String getCon() {
		return con;
	}

	public void setCon(String con) {
		this.con = con;
	}

	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}


}
