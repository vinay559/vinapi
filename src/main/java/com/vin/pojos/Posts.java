package com.vin.pojos;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Posts {
	
	@SerializedName("result")
    public List<Post> posts;

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
}
