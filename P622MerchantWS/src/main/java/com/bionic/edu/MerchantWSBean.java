package com.bionic.edu;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebService;
import java.io.StringWriter;

@WebService(endpointInterface = "com.bionic.edu.MerchantWS")
@Named
public class MerchantWSBean  implements MerchantWS{
	private MerchantList merchants = new MerchantList();
	@Inject
	private MerchantService merchantService;
	
	public MerchantWSBean(){   }
	
	public String getMerchantList(){
		try{
			merchants.setMerchants(merchantService.getAllMerchantList());
	        JAXBContext jc = JAXBContext.newInstance(MerchantList.class);
	        Marshaller m = jc.createMarshaller();
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	        StringWriter sw = new StringWriter();
	        m.marshal(merchants, sw);
	        String txt = sw.toString();
	        return txt;
		}
		catch(JAXBException e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Merchant getMerchant(int id){
		return merchantService.findById(id);
	}
 
}
