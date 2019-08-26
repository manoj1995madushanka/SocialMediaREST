package com.Tute.Tutorial.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

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
	/*
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public List<Message>
	 * getMessage(@QueryParam("year") int year,
	 * 
	 * @QueryParam("start") int start,
	 * 
	 * @QueryParam("end") int end) { if(year>0) { ms.getAllMessagesForYear(year); }
	 * if(start>0 && end>0) { ms.getAllMessagesPaginated(start, end); } return
	 * ms.getAllMessages();
	 * 
	 * }
	 */
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage(@BeanParam MessageFilterBean filterbean) {
		if(filterbean.getYear()>0) {
			ms.getAllMessagesForYear(filterbean.getYear());
		}
		if(filterbean.getStart()>0 && filterbean.getEnd()>0) {
			ms.getAllMessagesPaginated(filterbean.getStart(), filterbean.getEnd());
		}
		return ms.getAllMessages();
		
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long Id) {
		return ms.getMessage(Id);
	}
	
//	@POST
//	@Produces(MediaType.APPLICATION_JSON) // accept json
//	@Consumes(MediaType.APPLICATION_JSON) // return json
//	public Message addMessage(Message message) {
//		return ms.addMessage(message);
//	}
	
	// edit responce code and return new resource url when create new message
	@POST
	@Produces(MediaType.APPLICATION_JSON) // accept json
	@Consumes(MediaType.APPLICATION_JSON) // return json
	public Response addMessage(Message message, @Context UriInfo uriInfo) throws URISyntaxException {
		/* return ms.addMessage(message); */
		
		Message newMessage = ms.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.status(Status.CREATED)
				.entity(newMessage).build();
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
	
	@Path("/{messageId}/comments")
	@Produces(MediaType.APPLICATION_JSON) // accept json
	@Consumes(MediaType.APPLICATION_JSON) // return json
	public CommonResource getCommonResource() {
		return new CommonResource();
	}
	
	
}
