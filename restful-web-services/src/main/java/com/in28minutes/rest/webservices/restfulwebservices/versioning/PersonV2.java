package com.in28minutes.rest.webservices.restfulwebservices.versioning;

public class PersonV2 {

	private Name name;

	protected PersonV2(Name name) {
		super();
		this.name = name;
	}

	protected PersonV2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
}
