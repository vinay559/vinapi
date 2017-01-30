package com.vin.vinapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vin.helpers.PostHelper;
import com.vin.pojos.Post;
import com.vin.pojos.Posts;

public class PostTests {
	
	PostHelper pHelpers = new PostHelper();

	@Test
	public void getAllPosts() throws Exception{
		
		Posts postList = pHelpers.getAllPosts();
		Assert.assertNotNull(postList, "Get All Posts returned null");
	}
	
	@Test
	public void getPostById() throws Exception{
		Post p = pHelpers.getPostsById(2);
		Assert.assertNotNull(p, "Get post by Id returned null");
		Assert.assertEquals(p.getId(), "1", "Returned post of different ID");
	}
}
