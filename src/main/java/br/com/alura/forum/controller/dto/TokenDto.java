package br.com.alura.forum.controller.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("access_token")
	private String accessToken;

	public TokenDto(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public TokenDto() {
		super();
	}


	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	

}
