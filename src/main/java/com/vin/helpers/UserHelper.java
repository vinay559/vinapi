package com.vin.helpers;

import com.google.gson.Gson;
import com.vin.httpcore.HttpRequests;
import com.vin.pojos.User;
import com.vin.pojos.Users;

public class UserHelper extends BaseHelper {

	public Users getAllUsers() throws Exception {
		String URL = BASEURL + "users";
		String result = HttpRequests.httpGet(URL);

		Gson g = new Gson();
		Users users = g.fromJson("{result:" + result + "}", Users.class);
		return users;
	}

	public User getUserById(String id) throws Exception {
		String URL = BASEURL + "users/" + id;
		String result = HttpRequests.httpGet(URL);

		Gson g = new Gson();
		User user = g.fromJson(result, User.class);
		return user;
	}
}
