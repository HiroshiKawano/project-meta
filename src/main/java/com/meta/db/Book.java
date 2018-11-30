package com.meta.db;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="book")
public class Book {
	private List<BookSystem> bs;

	@XmlElement(name="system")
	public List<BookSystem> getBs() {
		return bs;
	}
	public void setBs(List<BookSystem> bs) {
		this.bs = bs;
	}
}
