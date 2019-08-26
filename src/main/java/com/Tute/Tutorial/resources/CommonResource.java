package com.Tute.Tutorial.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class CommonResource {
	
	@GET
	public String test() {
		return "new sub resource";
	}
	
	@GET
	@Path("/{commentID}")
	public String test2() {
		return "comment id works";
	}
}
