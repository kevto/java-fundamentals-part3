package nl.openvalue.samples.listeners;

public class Demo {
	
	public static void main(String[] args) {
		Bank ing = new Bank();
		
		ing.addTransactieListener(new TransactieListener() {
			@Override
			public void onGoedgekeurd(Transactie transactie) {
				System.out.printf("[GOEDGEKEURD: %s --> %s: %.2f]\n", 
						transactie.getVanIBAN(), transactie.getNaarIBAN(), transactie.getAmount());
			}
		});
		
		Bankrekening kevin = ing.openRekening("12345", "Kevin", 100);
		Bankrekening openvalue = ing.openRekening("789456", "OpenValue", 200);
		
		System.out.println("Voor de transactie");
		System.out.println(kevin);
		System.out.println(openvalue);
		
		ing.geldOvermaken(new Transactie("12345", "789456", 50));
		System.out.println("Na de transactie");
		System.out.println(kevin);
		System.out.println(openvalue);
				
	}

}
