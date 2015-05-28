package edu.bionic.com;
import javax.inject.Named;
import javax.jws.WebService;

@WebService(endpointInterface = "edu.bionic.com.HelloWorldService")
@Named
public class HelloWorldServiceImpl implements HelloWorldService {
	public String sayHello() {
		return "Hello World!!!";
	}
}
