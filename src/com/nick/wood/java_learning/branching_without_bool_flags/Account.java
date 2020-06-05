package com.nick.wood.java_learning.branching_without_bool_flags;

import java.math.BigDecimal;

/**
	example of class using bools to do different things
    problem 1 - need to many tests:
        Would need 2 tests for depositing and 3 for withdrawing due to all flags
    problem 2 - more requirements would mean more flags and changing of all code inside
        If you wanted a frozen account behaviour, would need to ass another flag and change deposit and
        withdraw with more if statements
 */

public class Account {

	private boolean isVerified;
	private boolean isClosed;
	private BigDecimal balance;

	public Account() {
		this.balance = BigDecimal.ZERO;
	}

	public void holderVerified() {
		this.isVerified = true;
	}

	public  void closeAccount() {
		this.isClosed = true;
	}

	public void deposit(BigDecimal amount) {
		if (this.isClosed) {
			return;
		}
		this.balance = this.balance.add(amount);
	}

	public void withdraw(BigDecimal amount) {
		if (!this.isVerified) {
			return;
		}
		if (this.isClosed) {
			return;
		}
		this.balance = this.balance.subtract(amount);
	}
}
