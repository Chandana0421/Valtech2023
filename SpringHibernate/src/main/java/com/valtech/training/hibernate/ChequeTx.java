package com.valtech.training.hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ctx")
public class ChequeTx extends Tx{

	private int checqueNum;
	private int micr;
	
	public ChequeTx() {
	}
	public ChequeTx(float amount, int checqueNum, int micr) {
		super(amount);
		this.checqueNum = checqueNum;
		this.micr = micr;
	}
	
	public int getChecqueNum() {
		return checqueNum;
	}
	public void setChecqueNum(int checqueNum) {
		this.checqueNum = checqueNum;
	}
	public int getMicr() {
		return micr;
	}
	public void setMicr(int micr) {
		this.micr = micr;
	}

}
