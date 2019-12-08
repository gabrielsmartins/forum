package br.com.alura.forum.controller.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorDto implements Serializable{


	private static final long serialVersionUID = 1L;

	@JsonProperty("code")
	private Integer code;
	
	@JsonProperty("description")
	private String descricao;
	
	@JsonProperty("message")
	private String mensagem;
	
	@JsonProperty("trace")
	private String trace;
	
	public ErrorDto(Integer code, String descricao, String mensagem) {
		this.code = code;
		this.descricao = descricao;
		this.mensagem = mensagem;
	}
	
	
	public ErrorDto() {
		super();
	}


	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public String getTrace() {
		return trace;
	}


	public void setTrace(String trace) {
		this.trace = trace;
	}
	
	
	
}
