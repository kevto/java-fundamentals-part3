package nl.openvalue.samples.listeners;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import nl.openvalue.samples.listeners.Transactie.Status;

public class Bank {

	private Map<String, Bankrekening> rekeningen;
	private List<Transactie> transacties;
	private List<TransactieListener> transactieListeners;
	
	public Bank() {
		rekeningen = new HashMap<>();
		transacties = new LinkedList<>();
		transactieListeners = new ArrayList<>();
	}
	
	public void addTransactieListener(TransactieListener listener) {
		transactieListeners.add(listener);
	}
	
	public Bankrekening openRekening(String iban, String naam, float saldo) {
		if (rekeningen.containsKey(iban)) {
			throw new IllegalArgumentException("IBAN bestaat al");
		}
		
		Bankrekening r =  new Bankrekening(iban, naam, saldo);
		rekeningen.put(iban, r);
		return r;
	}
	
	
	public void geldOvermaken(Transactie transactie) {
		if (transactie.getStatus() != Status.IN_AFWACHTING) {
			throw new IllegalStateException("transactie is al afgerond");
		}
		transacties.add(transactie);
		
		try {
			Bankrekening van = getRekening(transactie.getVanIBAN());
			Bankrekening naar = getRekening(transactie.getNaarIBAN());
			
			if (van.getSaldo() < transactie.getAmount()) {			
				throw new IllegalStateException("transactie afgekeurd door te weinig saldo");
			}
			
			van.removeSaldo(transactie.getAmount());
			naar.addSaldo(transactie.getAmount());
			transactie.updateStatus(Status.GOEDGEKEURD);
		} catch (IllegalStateException | IllegalArgumentException e) {
			transactie.updateStatus(Status.AFGEKEURD);
			throw e;
		} finally {
			notifyListeners(transactie);
		}
	}
	
	private void notifyListeners(Transactie transactie) {
		switch(transactie.getStatus()) {
		case GOEDGEKEURD:
			for(TransactieListener l : transactieListeners) {
				l.onGoedgekeurd(transactie);
			}
			break;
		case AFGEKEURD:
			for(TransactieListener l : transactieListeners) {
				l.onAfgekeurd(transactie);
			}
			break;
		default:
			break;
		}
	}
	
	private Bankrekening getRekening(String iban) {
		Bankrekening r = rekeningen.get(iban);
		if (r == null) {
			throw new IllegalStateException(String.format("rekening met IBAN [%s] bestaat niet", iban));
		}
		return r;
	}
	
	public List<Transactie> getTransacties() {
		return Collections.unmodifiableList(this.transacties);
	}
	
}
