package br.com.alura.forum.controller.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("type")
	private String type;

	public TokenDto(String accessToken, String type) {
		this.accessToken = accessToken;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
