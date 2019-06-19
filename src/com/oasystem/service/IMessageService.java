package com.oasystem.service;

import java.util.List;

import com.oasystem.bean.Message;

public interface IMessageService {
	
	int insert(Message m);
	
	
	int delete(int id);
	
	List<Message> selectAll();
}
