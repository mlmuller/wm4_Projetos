package br.com.gvdexport.core;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@Named
@RequestScoped
public class TransactionCtrl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	@Inject
	private UserTransaction tx;
	
	public void begin() {
		try {
			tx.begin();
		} catch (IllegalStateException | SystemException | NotSupportedException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void rollback() {
		try {
			tx.rollback();
		} catch (IllegalStateException | SystemException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void commit() {
		try {
			tx.commit();
		} catch (IllegalStateException | SystemException | SecurityException | RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void checkPoint() {
		em.flush();
		commit();
		begin();
		em.joinTransaction();
	}
	
	public void rollbackCheckPoint() {
		em.flush();
		rollback();
		begin();
		em.joinTransaction();
	}
	
	public void setRollbackOnly() {
		try {
			tx.setRollbackOnly();
		} catch (IllegalStateException | SystemException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int getStatus() {
		try {
			return tx.getStatus();
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}
	}
}
