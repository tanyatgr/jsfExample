package edu.bionic.com.P561FirstMarshaller;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
	private String name;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
