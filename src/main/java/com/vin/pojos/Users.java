package com.vin.pojos;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Users {

	public class Posts {

		@SerializedName("result")
		public List<User> users;

		public List<User> getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
		}
	}
}
