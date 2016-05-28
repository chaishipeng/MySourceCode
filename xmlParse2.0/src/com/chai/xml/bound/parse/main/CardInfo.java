package com.chai.xml.bound.parse.main;

public class CardInfo {

	public String cardNo;
	
	public Currency currency;
	
	public BankAcType bankAcType;

	public BankAcType getBankAcType() {
		return bankAcType;
	}

	public void setBankAcType(BankAcType bankAcType) {
		this.bankAcType = bankAcType;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public String toString(){
		
		return "#"+cardNo+"#"+currency.toString()+"#"+bankAcType.toString();
		
	}
	
}
