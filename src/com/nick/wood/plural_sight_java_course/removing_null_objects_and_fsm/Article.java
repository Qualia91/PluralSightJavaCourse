package com.nick.wood.plural_sight_java_course.removing_null_objects_and_fsm;

// finite state machine:
// It is changing the 'state' of the article via the method calls withVisibleDamage and
// notOperational. The expressWarranty getter gets the effectiveExpressWarranty, which at initialisation
// is VOID as is its not broken then you wont get it repaired. By calling the withVisibleDamage,
// you make the money back void and keep the effectiveExpressWarranty void so you cant get money
// back or repaired for damages made on it. On notOperational, you keep monetBack the same
// and change the effectiveExpressWarranty to expressWarranty as its not you fault
// and if you are still under any warranty you will get it. You can also chain these methods
// together as they return a new Article object with altered states.
public class Article {

	private Warranty moneyBackGuarantee;
	private Warranty expressWarranty;
	private Warranty effectiveExpressWarranty;

	public Article(Warranty moneyBackGuarantee, Warranty expressWarranty) {
		this(moneyBackGuarantee, expressWarranty, Warranty.VOID);
	}

	private Article(Warranty moneyBackGuarantee, Warranty expressWarranty, Warranty effectiveExpressWarranty) {

		if (moneyBackGuarantee == null) throw new IllegalArgumentException();
		if (expressWarranty == null) throw new IllegalArgumentException();

		this.moneyBackGuarantee = moneyBackGuarantee;
		this.expressWarranty = expressWarranty;
		this.effectiveExpressWarranty = effectiveExpressWarranty;
	}

	public Warranty getMoneyBackGuarantee() {
		return moneyBackGuarantee;
	}

	public Warranty getExpressWarranty() {
		return effectiveExpressWarranty;
	}

	public Article withVisibleDamage() {
		return new Article(Warranty.VOID, this.expressWarranty, this.effectiveExpressWarranty);
	}

	public Article notOperational() {
		return new Article(this.moneyBackGuarantee, this.expressWarranty, this.expressWarranty);
	}
}
