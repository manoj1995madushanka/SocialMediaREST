package com.Tute.Tutorial.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.Tute.Tutorial.Model.Message;
import com.Tute.Tutorial.Service.MessageService;

@Path("/message")
public class MessageResource {
	
	MessageService ms = new MessageService();
	
	/*
	 * @GET
	 * 
	 * @Produces(MediaType.TEXT_PLAIN) public String getMessage() { return
	 * "get message works"; }
	 */
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessage() {
		
		return ms.getAllMessages();
		
	}
}
