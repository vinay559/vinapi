package com.vin.helpers;

import com.google.gson.Gson;
import com.vin.httpcore.HttpRequests;
import com.vin.pojos.Post;
import com.vin.pojos.Posts;

public class PostHelper extends BaseHelper{

	public Posts getAllPosts() throws Exception {

		String URL = BASEURL + "posts";
		String result = HttpRequests.httpGet(URL);

		Gson gson = new Gson();
		Posts posts = gson.fromJson("{result:" + result + "}", Posts.class);
		return posts;
	}

	public Post getPostsById(int postId) throws Exception {

		String URL = BASEURL + "posts/" + postId;
		String result = HttpRequests.httpGet(URL);

		Gson gson = new Gson();
		Post post = gson.fromJson(result, Post.class);
		return post;
	}

}
