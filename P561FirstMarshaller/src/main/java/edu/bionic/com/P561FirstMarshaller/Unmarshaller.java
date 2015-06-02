package edu.bionic.com.P561FirstMarshaller;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class Unmarshaller {

	public static void main(String[] args) {
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(Person.class);

			javax.xml.bind.Unmarshaller unmarshaller = jc.createUnmarshaller();
			File inFile = new File("Test.xml");
			Person person = (Person) unmarshaller.unmarshal(inFile);
			System.out.println("person: " + person.getName() + ", "
					+ person.getAddress());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
