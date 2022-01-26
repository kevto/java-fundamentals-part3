package nl.openvalue.samples.listeners;

public class Bankrekening {
	
	private String iban;
	private String naam;
	private float saldo;
	
	public Bankrekening(String iban, String naam) {
		this(iban, naam, 0);
	}
	
	public Bankrekening(String iban, String naam, float saldo) { 
		this.iban = iban;
		this.naam = naam;
		this.saldo = saldo;
	}
	
	public void addSaldo(float saldo) {
		this.saldo += saldo;
	}
	
	public void removeSaldo(float saldo) {
		this.saldo -= saldo;
	}
	
	public float getSaldo() {
		return saldo;
	}
	
	public String getIBAN() {
		return iban;
	}
	
	public String getNaam() {
		return naam;
	}
	
	@Override
	public String toString() {
		return String.format("Bankrekening[iban=%s, naam=%s, saldo=%.2f]", this.iban, this.naam, this.saldo);
	}

}
