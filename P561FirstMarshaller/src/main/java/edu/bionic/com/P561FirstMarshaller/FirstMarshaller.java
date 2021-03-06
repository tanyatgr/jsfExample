package edu.bionic.com.P561FirstMarshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class FirstMarshaller {
	public void marshall() throws JAXBException {
		Person person = new Person();
		person.setName("Oleg");
		person.setAddress("Kiev");
		JAXBContext jc = JAXBContext.newInstance(Person.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(person, System.out);
	}
}
