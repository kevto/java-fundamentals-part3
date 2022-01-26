package nl.openvalue.samples.listeners;

public class Transactie {
	
	private String vanIBAN, naarIBAN;
	private float amount;
	private Status status;
	
	public Transactie(String vanIBAN, String naarIBAN, float amount) {
		this.vanIBAN = vanIBAN;
		this.naarIBAN = naarIBAN;
		this.amount = amount;
		this.status = Status.IN_AFWACHTING;
	}

	public String getVanIBAN() {
		return vanIBAN;
	}

	public String getNaarIBAN() {
		return naarIBAN;
	}

	public float getAmount() {
		return amount;
	}
	
	public void updateStatus(Status status) {
		switch(this.status) {
		case GOEDGEKEURD:
		case AFGEKEURD:
			throw new IllegalStateException("status kan niet gewijzigd worden");
		case IN_AFWACHTING:
			this.status = status;
		}
	}
	
	public Status getStatus() {
		return this.status;
	}
	
	public static enum Status {
		GOEDGEKEURD, AFGEKEURD, IN_AFWACHTING;
	}

}
