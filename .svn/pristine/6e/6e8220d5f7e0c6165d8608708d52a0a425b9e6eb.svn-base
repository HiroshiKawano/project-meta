package com.meta.db;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="system")
public class BookSystem {
	private String status;

	private String reserveurl;

	private List<Lend> libkeys;

	@XmlElementWrapper(name = "libkeys")
	@XmlElement(name = "libkey")
	public List<Lend> getLibkeys() {
		return libkeys;
	}

	public String getReserveurl() {
		return reserveurl;
	}

	public void setReserveurl(String reserveurl) {
		this.reserveurl = reserveurl;
	}

	public void setLibkeys(List<Lend> libkeys) {
		this.libkeys = libkeys;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
