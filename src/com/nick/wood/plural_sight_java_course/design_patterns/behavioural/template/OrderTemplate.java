package com.nick.wood.plural_sight_java_course.design_patterns.behavioural.template;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.Permission;
import java.security.Policy;

public abstract class OrderTemplate {
	public boolean isGift;
	public abstract void doCheckout();
	public abstract void doPayment();
	public abstract void doReceipt();
	public abstract void doDelivery();

	// final means cant be overwritten by subclasses
	public final void wrapGift() {
		System.out.println("Wrap gift");
	}

	public final void process() {

		doCheckout();
		doPayment();
		if (isGift) {
			wrapGift();
		} else {
			doReceipt();
		}
		doDelivery();

	}

}
