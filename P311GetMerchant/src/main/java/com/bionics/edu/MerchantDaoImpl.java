package com.bionics.edu;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class MerchantDaoImpl implements MerchantDao {
    @PersistenceContext
    private EntityManager em;

    public Merchant findById(int id){
    	Merchant m = null;
	m = em.find(Merchant.class, id);
	return m;
    }
}

