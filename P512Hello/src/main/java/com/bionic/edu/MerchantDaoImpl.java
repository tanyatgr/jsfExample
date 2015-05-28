package com.bionic.edu;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class MerchantDaoImpl implements MerchantDao {
	@PersistenceContext
	private EntityManager em;

	public Merchant findById(int id) {
		Merchant m = null;
		m = em.find(Merchant.class, id);
		return m;
	}

	public List<Merchant> findAll() {
		TypedQuery<Merchant> query = em.createQuery("SELECT m FROM Merchant m",
				Merchant.class);
		List<Merchant> listM = null;
		listM = query.getResultList();
		return listM;
	}

	public List<Merchant> getSortedByNeedToPay() {
		String txt = "SELECT m FROM Merchant m ORDER BY m.needToSend";
		TypedQuery<Merchant> query = em.createQuery(txt, Merchant.class);
		return query.getResultList();
	}

	public List<Result> getTotalReport() {
		String txt = "SELECT new com.bionics.edu.Result ((p.merchant.name, count(p), SUM(p.chargePayed))";
		txt += "FROM Payment p GROUP BY p.merchant.name";

		TypedQuery<Result> query = em.createQuery(txt, Result.class);
		return query.getResultList();
	}

	@Override
	public void save(Merchant m) {

		if (m.getId() == 0) {
			em.persist(m);
		} else {
			em.merge(m);
		}

	}
}
