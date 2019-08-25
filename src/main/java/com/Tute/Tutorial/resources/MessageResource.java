package com.Tute.Tutorial.resources;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
	
	
	// message?year=2015
	// message?start=2015&end=2
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage(@QueryParam("year") int year, @QueryParam("start") int start, @QueryParam("end") int end) {
		if(year>0) {
			ms.getAllMessagesForYear(year);
		}
		if(start>0 && end>0) {
			ms.getAllMessagesPaginated(start, end);
		}
		return ms.getAllMessages();
		
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long Id) {
		return ms.getMessage(Id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON) // accept json
	@Consumes(MediaType.APPLICATION_JSON) // return json
	public Message addMessage(Message message) {
		return ms.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON) // accept json
	@Consumes(MediaType.APPLICATION_JSON) // return json
	public Message updateMessage(@PathParam("messageId") long Id, Message message) {
		message.setId(Id);
		return ms.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON) // accept json
	@Consumes(MediaType.APPLICATION_JSON) // return json
	public void deleteMessage(@PathParam("messageId") long Id) {
		
		ms.removeMessage(Id);
	}
	
	
}
