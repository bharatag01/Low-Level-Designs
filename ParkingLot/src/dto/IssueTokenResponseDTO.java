package dto;

import models.Token;

public class IssueTokenResponseDTO {
	
	private Token token;
	private dto.ResponseStatus responseMessage;
	private String failureMessage;
	public Token getToken() {
		return token;
	}
	public void setToken(Token token) {
		this.token = token;
	}
	public dto.ResponseStatus getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(dto.ResponseStatus responseMessage) {
		this.responseMessage = responseMessage;
	}
	public String getFailureMessage() {
		return failureMessage;
	}
	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}

}
