package com.vansh.rest.webservices.restful_web_services.versioning;

public class PersonV2 {

	public PersonV2(Name name) {
		super();
		this.name = name;
	}

	private Name name;

	public Name getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonV2 [name=" + name + "]";
	}

}
