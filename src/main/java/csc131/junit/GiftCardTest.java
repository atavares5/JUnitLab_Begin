package csc131.junit;

import static org.junit.jupiter.api.Assertions.*;
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
		
		assertEquals("deduct_RemainingBalance()", "Remaining Balance: " + String.format("%6.2f", Math.abs(remaining_balance)), card.deduct(deduct_amount));
	}
	@Test
	public void deduct_RemainingBalance_2ndtest() {
		double balance;
		GiftCard card;
		int issuingStore;
		double deduct_amount;
		
		issuingStore = 1337;
		balance = 100.00;
		deduct_amount = -5.00;
		
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("deduct_RemainingBalance()", "Invalid Transaction", card.deduct(deduct_amount));
	}
	@Test
	public void deduct_RemainingBalance_3rdtest() {
		double balance;
		GiftCard card;
		int issuingStore;
		double deduct_amount;
		double remaining_balance;
		
		issuingStore = 1337;
		balance = 80.00;
		deduct_amount = 100.00;
		remaining_balance = balance - deduct_amount;
		
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("deduct_RemainingBalance()", "Amount Due: " + String.format("%6.2f",Math.abs(remaining_balance)), card.deduct(deduct_amount));
	}
	@Test
	public void giftCard_test() {
		
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1, -100.00);});
	}
	@Test
	public void constructor_IncorrectID_Low() {
		
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-1, -100.00);});
	}
	@Test
	public void constructor_IncorrectID_High() {
		
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(10000, -100.00);});
	}
}
