package week3.day2;

public class Amazon extends CanaraBank {
	
	@Override
	void recordPaymentDetails() {
		System.out.println("Record Payment Details");
		
	}


	public static void main(String[] args)  {
		// TODO Auto-generated method stub

	Amazon amazon =new Amazon();
	amazon.recordPaymentDetails();
	amazon.cardPayments();
	amazon.cashOnDelivery();
	amazon.internetBanking();
	amazon.upiPayments();
	
	
	}

	
}
