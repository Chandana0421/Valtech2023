package com.valtech.training.hibernate;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
@Embeddable
public class BankAccountId implements Serializable {

	private String accountType;
	private int accountName;

	public BankAccountId(String accountType, int accountName) {
		this.accountType = accountType;
		this.accountName = accountName;
	}

	public BankAccountId() {
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAccountName() {
		return accountName;
	}

	public void setAccountName(int accountName) {
		this.accountName = accountName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountName, accountType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccountId other = (BankAccountId) obj;
		return accountName == other.accountName && Objects.equals(accountType, other.accountType);
	}

}
