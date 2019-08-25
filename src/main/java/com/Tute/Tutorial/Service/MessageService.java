package com.Tute.Tutorial.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.Tute.Tutorial.Database.DatabaseClass;
import com.Tute.Tutorial.Model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		
		messages.put(1l, new Message(1, "hello", "testing"));
		messages.put(2l, new Message(2, "hello2", "testing2"));
	}
	
	public List<Message> getAllMessages(){
		/*
		 * Message m1 = new Message(1l, "Hello","testing"); Message m2 = new
		 * Message(2l,"second","world"); List<Message> list = new ArrayList<>();
		 * list.add(m1); list.add(m2); return list;
		 */
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() +1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId()<=0) {
			return null;
		}
		messages.put(message.getId(),message);
		return message;
	}
	
	public Message removeMessage(long id) {
		
		return messages.remove(id);
	}
	
	// filtering and pagination
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messageForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message: messages.values()) {
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year) {
				messageForYear.add(message);
			}
		}
		return messageForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if(start+size>list.size()) return new ArrayList<Message>();
		return list.subList(start, start+size);
	}


}
