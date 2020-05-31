package com.todo.model;

public class CustomResponse {

	public CustomResponse() {

	}

	public CustomResponse(String message, Object response, String responseStatus) {
		super();
		this.message = message;
		this.response = response;
		this.responseStatus = responseStatus;
	}

	private String message;

	private Object response;

	private String responseStatus;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomResponse [message=").append(message).append(", response=").append(response)
				.append(", responseStatus=").append(responseStatus).append("]");
		return builder.toString();
	}

}
