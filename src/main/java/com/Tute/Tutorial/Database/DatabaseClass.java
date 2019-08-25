package com.Tute.Tutorial.Database;
import java.util.*;

import com.Tute.Tutorial.Model.Message;
import com.Tute.Tutorial.Model.Profile;

public class DatabaseClass {
	// map id to message object and store in hashmap
	
	// long must be wrpper class object
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages(){
		
		return messages;
	}

	public static Map<String, Profile> getProfiles(){
		
		return profiles;
	}

}
