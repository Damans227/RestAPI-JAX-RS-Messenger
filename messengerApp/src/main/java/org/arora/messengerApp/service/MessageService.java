package org.arora.messengerApp.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.arora.messengerApp.database.DatabaseClass;
import org.arora.messengerApp.model.Message;

public class MessageService {

	Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		
		messages.put(1L, new Message(1,"Daman", "Hello Daman!"));
		messages.put(2L, new Message(2,"Arora", "Hello Arora!"));
		
		
	}
	
	public List<Message> getAllMessages() {
		
		return new ArrayList<Message> (messages.values());
		
	}
	
	public Message getMessage(long id) {
		
		Message message = messages.get(id);
		
		if(message == null) {
			
			System.out.println("Message with ID "+id+" Not found");
		}
		return message;
		
	}
	
	
	public List<Message> getMessageForYear(int year) {
		List<Message> messagesForYear =  new ArrayList();
		
		Calendar cal = Calendar.getInstance();
		
		for(Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year) {
				
				messagesForYear.add(message);
				
			}
			
			
		}
		
		return messagesForYear;
		
	}
	
	public Message addMessage(Message message) {
		
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
		
	}
	
	public Message updateMessage(Message message) {
		
		if(message.getId() <= 0) {
			
			return null;
		}
		messages.put(message.getId(), message);
		
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
