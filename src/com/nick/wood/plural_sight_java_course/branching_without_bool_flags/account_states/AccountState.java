package com.nick.wood.plural_sight_java_course.branching_without_bool_flags.account_states;

import java.math.BigDecimal;
import java.util.function.Consumer;

public interface AccountState {
	AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance);
	AccountState withdraw(BigDecimal amount, Consumer<BigDecimal> subtractFromBalance);
	AccountState holderVerified();
	AccountState closeAccount();
}
