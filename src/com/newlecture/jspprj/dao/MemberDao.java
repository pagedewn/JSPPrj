package com.newlecture.jspprj.dao;

import java.util.List;

import com.newlecture.jspprj.model.Member;
import com.newlecture.jspprj.model.Notice;

public interface MemberDao {
	
	public Member getMember(String uid);
}
