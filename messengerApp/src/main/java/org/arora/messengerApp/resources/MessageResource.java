package org.arora.messengerApp.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.arora.messengerApp.model.Message;
import org.arora.messengerApp.service.MessageService;


@Path("/{messages}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	
	@GET
	public List<Message> getAllMessages(@QueryParam("year") int year){
		
		if(year > 0)
		{
			return messageService.getMessageForYear(year);
			
		}
		
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id){
		
		return messageService.getMessage(id);
		
	}
	
	@POST
	public Message addMessage(Message message) {
		
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id, Message message) {
		
		message.setId(id);
		
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	
	public Message removeMessage(@PathParam("messageId") long id) {
		return messageService.removeMessage(id);
	}
	
	

}
