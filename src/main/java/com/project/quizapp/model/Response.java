package com.project.quizapp.model;

public class Response {
	
	private String Response;
	private Integer id;

	public Response() {
		// TODO Auto-generated constructor stub
	}

	public String getResponse() {
		return Response;
	}

	public void setResponse(String response) {
		Response = response;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Response(String response, Integer id) {
		super();
		Response = response;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Response [Response=" + Response + ", id=" + id + "]";
	}

}
