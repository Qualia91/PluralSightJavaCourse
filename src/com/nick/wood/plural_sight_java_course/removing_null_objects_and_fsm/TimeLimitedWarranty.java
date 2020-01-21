package com.nick.wood.plural_sight_java_course.removing_null_objects_and_fsm;

import java.time.Duration;
import java.time.LocalDate;

public class TimeLimitedWarranty implements Warranty {

	private LocalDate dateIssued;
	private Duration validFor;

	public TimeLimitedWarranty(LocalDate dateIssued, Duration validFor) {
		this.dateIssued = dateIssued;
		this.validFor = validFor;
	}

	@Override
	public Warranty on(LocalDate date) {
		return date.compareTo(this.dateIssued) < 0 ? Warranty.VOID
				: date.compareTo(this.getExpiredDate()) > 0 ? Warranty.VOID
				: this;
	}

	private LocalDate getExpiredDate() {
		return this.dateIssued.plusDays(this.getValidForDays());
	}

	private long getValidForDays() {
		return validFor.toDays();
	}
}
