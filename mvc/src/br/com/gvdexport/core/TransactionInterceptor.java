package br.com.gvdexport.core;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.Status;

@Transactional
@Interceptor
public class TransactionInterceptor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TransactionCtrl transactionCtrl;
	
	@AroundInvoke
	public Object aroundInvoke(final InvocationContext ctx) throws Exception {
		boolean localTx = transactionCtrl.getStatus() == Status.STATUS_NO_TRANSACTION;
		try {
			if (localTx) {
				transactionCtrl.begin();
			}
			Object result = ctx.proceed();
			if (localTx) {
				if (transactionCtrl.getStatus() != Status.STATUS_MARKED_ROLLBACK) {
					transactionCtrl.commit();
				} else {
					transactionCtrl.rollback();
				}
			}
			return result;
		} catch (Exception e) {
			if (localTx) {
				transactionCtrl.rollback();
			} else {
				transactionCtrl.setRollbackOnly();
			}
			throw e;
		}
	}
}
