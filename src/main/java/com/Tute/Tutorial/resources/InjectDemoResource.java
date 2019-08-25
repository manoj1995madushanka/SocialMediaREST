package com.Tute.Tutorial.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN) // accept json
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	// metrix param eg. message:name=kasun
	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
											@HeaderParam("authSessionId") String header,
											@CookieParam("name") String cookie) {
		return "Matrix param : " + matrixParam + "HeaderParam : " + header + " Cookie : " + cookie;
	}

}
