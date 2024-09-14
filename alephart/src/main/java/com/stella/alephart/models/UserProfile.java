package com.stella.alephart.models;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class UserProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user_profile;
	
	@Column
	private byte profile_photo;
	
	@Column
	private byte banner;
	
	@Column
	private String about_me;
	
	@Column
	private String profession;
	
	@OneToOne
	@JoinColumn(name = "id_user", nullable = false)
	private User user;
	
	public UserProfile() {}

	public UserProfile(Long id_user_profile, byte profile_photo, byte banner, String about_me, String profession) {
		super();
		this.id_user_profile = id_user_profile;
		this.profile_photo = profile_photo;
		this.banner = banner;
		this.about_me = about_me;
		this.profession = profession;
	}

	public Long getId_user_profile() {
		return id_user_profile;
	}

	public void setId_user_profile(Long id_user_profile) {
		this.id_user_profile = id_user_profile;
	}

	public byte getProfile_photo() {
		return profile_photo;
	}

	public void setProfile_photo(byte profile_photo) {
		this.profile_photo = profile_photo;
	}

	public byte getBanner() {
		return banner;
	}

	public void setBanner(byte banner) {
		this.banner = banner;
	}

	public String getAbout_me() {
		return about_me;
	}

	public void setAbout_me(String about_me) {
		this.about_me = about_me;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Override
	public String toString() {
		return "UserProfile [id_user_profile=" + id_user_profile + ", profile_photo=" + profile_photo + ", banner="
				+ banner + ", about_me=" + about_me + ", profession=" + profession + "]";
	}
	
	
}
