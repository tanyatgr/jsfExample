package edu.bionic.com.P563MerchantXML;

@XmlRootElement
public class MerchantList {
    private List<Merchant> merchants;

    public MerchantList(){
	merchants = new ArrayList<Merchant>();
    }
