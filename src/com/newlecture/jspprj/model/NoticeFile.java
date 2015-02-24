package com.newlecture.jspprj.model;

import java.sql.Date;

public class NoticeFile {
	private String code;
	private String src;
	private	String description;
	private Date Regdate;
	private String NoticeCode;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getRegdate() {
		return Regdate;
	}
	public void setRegdate(Date regdate) {
		Regdate = regdate;
	}
	public String getNoticeCode() {
		return NoticeCode;
	}
	public void setNoticeCode(String noticeCode) {
		NoticeCode = noticeCode;
	}
	
	
}
