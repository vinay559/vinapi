package com.vin.vinapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vin.helpers.UserHelper;
import com.vin.pojos.User;
import com.vin.pojos.Users;

public class UserTests {

	UserHelper userHelper = new UserHelper();

	@Test
	public void getAllUsers() throws Exception {

		Users userList = userHelper.getAllUsers();
		Assert.assertNotNull(userList, "Empty users returned");
	}

	@Test
	public void getUserById() throws Exception {

		User user = userHelper.getUserById("1");
		Assert.assertNotNull(user, "Null user returned");
		Assert.assertEquals(user.getId(), "1", "returned user with different Id");
	}

}
