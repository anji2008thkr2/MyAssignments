package week3.day2;

public abstract class CanaraBank implements Payments{

	@Override
	public void cashOnDelivery() {
		System.out.println("Cash on Delivery");
		
	}

	@Override
	public void upiPayments() {
		// TODO Auto-generated method stub
		System.out.println("upi Payments");
		
	}

	@Override
	public void cardPayments() {
		System.out.println("Card Payments");
		
	}

	@Override
	public void internetBanking() {
		System.out.println("Internet Banking");
		
	}
	
	
	abstract void recordPaymentDetails();
	

}
