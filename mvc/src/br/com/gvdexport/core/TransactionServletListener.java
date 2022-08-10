package br.com.gvdexport.core;

import javax.inject.Inject;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.transaction.Status;

@WebListener
public class TransactionServletListener implements ServletRequestListener {
	
	@Inject
	private TransactionCtrl transactionCtrl;

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		if (transactionCtrl.getStatus() != Status.STATUS_ACTIVE) {
			transactionCtrl.begin();
		}
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		switch (transactionCtrl.getStatus()) {
		case Status.STATUS_ACTIVE:
			transactionCtrl.commit();
			break;
		case Status.STATUS_MARKED_ROLLBACK:
		case Status.STATUS_PREPARED:
		case Status.STATUS_PREPARING:
			transactionCtrl.rollback();
			break;
		case Status.STATUS_COMMITTED:
		case Status.STATUS_COMMITTING:
		case Status.STATUS_ROLLING_BACK:
		case Status.STATUS_UNKNOWN:
		case Status.STATUS_ROLLEDBACK:
		case Status.STATUS_NO_TRANSACTION:
			break;
		}
	}
}
