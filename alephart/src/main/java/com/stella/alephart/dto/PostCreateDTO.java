package com.stella.alephart.dto;

public class PostCreateDTO {
    private String post_date;
    private String post_description;
    private Long userId;
    private Long userProfileId;
    
    public PostCreateDTO() {}
    
	public PostCreateDTO(String post_date, String post_description, Long userId, Long userProfileId) {
		super();
		this.post_date = post_date;
		this.post_description = post_description;
		this.userId = userId;
		this.userProfileId = userProfileId;
	}
	public String getPost_date() {
		return post_date;
	}
	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}
	public String getPost_description() {
		return post_description;
	}
	public void setPost_description(String post_description) {
		this.post_description = post_description;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(Long userProfileId) {
		this.userProfileId = userProfileId;
	}
	@Override
	public String toString() {
		return "PostCreateDTO [post_date=" + post_date + ", post_description=" + post_description + ", userId=" + userId
				+ ", userProfileId=" + userProfileId + "]";
	}

    
}