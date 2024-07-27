package com.vansh.rest.webservices.restful_web_services.versioning;

public class Name {


private String firstName;
private String lastName;




public Name( String firstName,String lastName) {
	this.firstName=firstName;
	this.lastName=lastName;
}


public String getFirstName() {
	return firstName;
	
}

public String getlastName() {
	return lastName;
}


@Override
public String toString() {
	return "Name [firstName=" + firstName + ", lastname=" + lastName + "]";
}





}
