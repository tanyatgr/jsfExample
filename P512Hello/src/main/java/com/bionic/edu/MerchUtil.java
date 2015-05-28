package com.bionic.edu;

import java.io.StringWriter;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Named
public class MerchUtil {
	private MerchantList merchants = new MerchantList();
	@Inject
	private MerchantService merchantService;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws JAXBException {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"application-config.xml");
		MerchUtil util = context.getBean(MerchUtil.class);
		util.getList();
	}

	public void getList() throws JAXBException {
		merchants.setMerchants(merchantService.findAll());
		JAXBContext jc = JAXBContext.newInstance(MerchantList.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		StringWriter sw = new StringWriter();
		m.marshal(merchants, sw);
		System.out.println(sw.toString());
	}
}
