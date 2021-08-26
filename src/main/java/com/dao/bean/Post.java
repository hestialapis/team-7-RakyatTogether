package com.dao.bean;

public class Post {

	private int postID;
	private String postContent, profileID, postTag, postLike, postDislike;
	
	//generate getters and setters
	
	public int getId() {
		return postID;
	}
	public void setId(int postID) {
		this.postID = postID;
	}
	
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	
	public String getProfileID() {
		return profileID;
	}
	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}
	
	public String getPostTag() {
		return postTag;
	}
	public void setPostTag(String postTag) {
		this.postTag = postTag;
	}
	
	public String getPostLike() {
		return postLike;
	}
	public void setPostLike(String postLike) {
		this.postLike = postLike;
	}
	
	public String getPostDislike() {
		return postDislike;
	}
	public void setPostDislike(String postDislike) {
		this.postDislike = postDislike;
	}
}
