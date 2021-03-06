package com.nick.wood.java_learning.removing_null_objects_and_fsm;

import java.time.LocalDate;

public class LifetimeWarranty implements Warranty {
	private LocalDate issuedOn;

	public LifetimeWarranty(LocalDate issuedOn) {
		this.issuedOn = issuedOn;
	}

	@Override
	public Warranty on(LocalDate date) {
		return date.compareTo(issuedOn) < 0 ? Warranty.VOID : this;
	}
}
