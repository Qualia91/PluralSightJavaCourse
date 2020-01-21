package com.nick.wood.plural_sight_java_course.branching_without_bool_flags;

import com.nick.wood.plural_sight_java_course.branching_without_bool_flags.account_states.AccountState;
import com.nick.wood.plural_sight_java_course.branching_without_bool_flags.account_states.Active;

import java.math.BigDecimal;

/**
 example of class using state pattern to do different things
 have turned all bools into a state machine, leveraging polymorphism for branching
 tests are now simplier to do, just need to make sure state is tracked correctly and that each state does what is
 intended
 It is now just managing one changing thing, the state is managing the actual state of the account. Basically,
 each class focuses on 1 primary role, secondary roles are delegated to new classes.

 */

public class AccountStatePattern {

	private BigDecimal balance;

	private AccountState accountState;

	public AccountStatePattern() {
		this.balance = BigDecimal.ZERO;
		this.accountState = new Active();
	}

	public void deposit(BigDecimal amount) {
		this.accountState = this.accountState.deposit(amount, this::addToBalance);
	}

	public void withdraw(BigDecimal amount) {
		this.accountState = this.accountState.withdraw(amount, this::subtractFromBalance);
	}


	/**
	 * Helper functions for the state pattern
	 */
	private void holderVerified() {
		this.accountState = this.accountState.holderVerified();
	}

	private void closeAccount() {
		this.accountState = this.accountState.closeAccount();
	}

	private void addToBalance(BigDecimal amount) {
		balance = balance.add(amount);
	}

	private void subtractFromBalance(BigDecimal amount) {
		if (balance.compareTo(amount) >= 0) {
			balance = balance.subtract(amount);
		}
	}
}
