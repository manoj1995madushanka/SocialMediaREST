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
import javax.ws.rs.core.MediaType;

import com.Tute.Tutorial.Model.Message;
import com.Tute.Tutorial.Model.Profile;
import com.Tute.Tutorial.Service.ProfileService;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON) // accept json
@Consumes(MediaType.APPLICATION_JSON) // return json
public class ProfileResource {
	
	private ProfileService profileservice = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getMessage() {
		
		return profileservice.getAllProfiles();
		
	}
	
	@GET
	@Path("/{profilename}")
	public Profile getProfile(@PathParam("profilename") String name ) {
		return profileservice.goProfile(name);
	}
	
	@POST
	public Profile addProfile(Profile profile) {
		return profileservice.addProfile(profile);
	}
	
	@PUT
	@Path("/{profilename}")
	public Profile updateProfile(@PathParam("profilename") String name, Profile profile) {
		profile.setProfileName(name);
		return profileservice.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profilename}")
	public void deleteProfile(@PathParam("profilename") String name) {
		
		profileservice.removeProfile(name);
	}

}
