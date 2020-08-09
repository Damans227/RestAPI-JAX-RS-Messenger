package org.arora.messengerApp.database;

import java.util.*;

import org.arora.messengerApp.model.Message;

public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	
	
	

}
