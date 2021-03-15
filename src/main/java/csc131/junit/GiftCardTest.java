package csc131.junit;

//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class GiftCardTest {

	@Test
	public void getIssuingStore() {
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());
	}
	@Test
	public void getBalance() {
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getBalance()", balance, card.getBalance(), 0.001);
	}
	@Test
	public void deduct_RemainingBalance() {
		double balance;
		GiftCard card;
		int issuingStore;
		double deduct_amount;
		double remaining_balance;
		
		issuingStore = 1337;
		balance = 100.00;
		deduct_amount = 10.00;
		remaining_balance = balance - deduct_amount;
		
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("deduct_RemainingBalance()", "Remaining Balance: " + String.format("%6.2f", Math.abs(remaining_balance)), card.deduct(10.00));
	}
}
