package com.nick.wood.java_learning.removing_null_objects_and_fsm;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Demo {

	private void offerMoneyBack() {
		System.out.println("Offer money back");
	}

	private void offerRepair() {
		System.out.println("Offer repair");
	}

	public void claimWarranty(Article article) {
		LocalDate today = LocalDate.now();

		article.getMoneyBackGuarantee().on(today).claim(this::offerMoneyBack);
		article.getExpressWarranty().on(today).claim(this::offerRepair);

		System.out.println("---------------------");
	}

	public void run() {

		LocalDate sellingDate = LocalDate.now().minus(40, ChronoUnit.DAYS);

		System.out.println("Article 1");

		// this first article is a normal one that is valid for express warranty if broken, but not valid for money back
		Warranty moneyBack1 = new TimeLimitedWarranty(sellingDate, Duration.ofDays(30));
		Warranty warranty1 = new TimeLimitedWarranty(sellingDate, Duration.ofDays(365));

		Article article1 = new Article(moneyBack1, warranty1);
		this.claimWarranty(article1);
		this.claimWarranty(article1.withVisibleDamage());
		this.claimWarranty(article1.withVisibleDamage().notOperational());
		this.claimWarranty(article1.notOperational());

		System.out.println("Article 2");

		// this second article has no money back (uses VOID default object found in interface), but a lifetime repair warranty
		Article article2 = new Article(Warranty.VOID, Warranty.lifetime(sellingDate));
		this.claimWarranty(article2);
		this.claimWarranty(article2.withVisibleDamage());
		this.claimWarranty(article2.withVisibleDamage().notOperational());
		this.claimWarranty(article2.notOperational());

		System.out.println("Article 3");

		// this third article is valid for express warranty if broken and valid for money back
		Warranty moneyBack2 = new TimeLimitedWarranty(sellingDate, Duration.ofDays(60));
		Warranty warranty2 = new TimeLimitedWarranty(sellingDate, Duration.ofDays(365));

		Article article3 = new Article(moneyBack2, warranty2);
		this.claimWarranty(article3);
		this.claimWarranty(article3.withVisibleDamage());
		this.claimWarranty(article3.withVisibleDamage().notOperational());
		this.claimWarranty(article3.notOperational());
	}
}
