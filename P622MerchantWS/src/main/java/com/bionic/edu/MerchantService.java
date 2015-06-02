package com.bionic.edu;

import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class MerchantService {
    @Inject
    private MerchantDao merchantDao;

    //@Transactional
    public Merchant findById(int id) {
      return merchantDao.findById(id);
    }
    
    public List<Merchant> getAllMerchantList(){
    	return merchantDao.getAllMerchantList();
    }
    
    @Transactional
    public void save(Merchant m){
    	merchantDao.save(m);
    }
}
