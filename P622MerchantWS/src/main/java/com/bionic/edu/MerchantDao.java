package com.bionic.edu;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.*;

@Repository
public class MerchantDao {
    @PersistenceContext
    private EntityManager em;
    
    public Merchant findById(int id){
    	Merchant m = null;
		m = em.find(Merchant.class, id);
		return m;
    }
    
    public void save(Merchant m){
     	em.persist(m);
    }
    
    public List<Merchant> getAllMerchantList(){
    	List<Merchant> list = null;
    	TypedQuery<Merchant> query =  em.createQuery("SELECT m FROM Merchant m", Merchant.class);
    	list = query.getResultList();
    	return list;
    }
}
