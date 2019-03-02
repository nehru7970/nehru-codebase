package com.in28minutes.rest.webservices.restfulwebservices.versioning;

public class PersonV1 {

	private String name;

	protected PersonV1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected PersonV1(String name) {
		super();
		this.name = name;
	}

}
