package com.nick.wood.plural_sight_java_course.branching_without_bool_flags.account_states;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class NotVerified implements AccountState {

	@Override
	public AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance) {
		addToBalance.accept(amount);
		return this;
	}

	@Override
	public AccountState withdraw(BigDecimal amount, Consumer<BigDecimal> subtractFromBalance) {
		return this;
	}

	@Override
	public AccountState holderVerified() {
		return new Active();
	}

	@Override
	public AccountState closeAccount() {
		return new Closed();
	}
}
