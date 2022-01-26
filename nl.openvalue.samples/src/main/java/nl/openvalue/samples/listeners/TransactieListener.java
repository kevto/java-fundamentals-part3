package nl.openvalue.samples.listeners;


public abstract class TransactieListener {
	
	public void onAfgekeurd(Transactie transactie) {
		// Default, do nothing
	}
	
	public void onGoedgekeurd(Transactie transactie) {
		// Default, do nothing
	}
}
