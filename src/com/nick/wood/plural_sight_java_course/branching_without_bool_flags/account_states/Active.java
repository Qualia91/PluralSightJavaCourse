package com.nick.wood.plural_sight_java_course.branching_without_bool_flags.account_states;

import jdk.dynalink.NamedOperation;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class Active implements AccountState {

	@Override
	public AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance) {
		addToBalance.accept(amount);
		return this;
	}

	@Override
	public AccountState withdraw(BigDecimal amount, Consumer<BigDecimal> subtractFromBalance) {
		subtractFromBalance.accept(amount);
		return this;
	}

	@Override
	public AccountState holderVerified() {
		return this;
	}

	@Override
	public AccountState closeAccount() {
		return new Closed();
	}
}
