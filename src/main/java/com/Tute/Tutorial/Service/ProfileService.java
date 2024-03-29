package com.Tute.Tutorial.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.Tute.Tutorial.Database.DatabaseClass;
import com.Tute.Tutorial.Model.Profile;

public class ProfileService {
	
	private Map<String,Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("manu", new Profile(1l,"Manoj","Madushanka","Nothing"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile goProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() +1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}

}
