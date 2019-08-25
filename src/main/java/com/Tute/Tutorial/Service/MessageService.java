package com.Tute.Tutorial.Service;

import java.util.ArrayList;
import java.util.List;

import com.Tute.Tutorial.Model.Message;

public class MessageService {
	
	public List<Message> getAllMessages(){
		Message m1 = new Message(1l, "Hello","testing");
		Message m2 = new Message(2l,"second","world");
		List<Message> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;
	}


}
