package com.nick.wood.java_learning.design_patterns.behavioural.command;

import java.util.Random;

public class BigCommand extends Command {

	private Light light;
	private long a = new Random().nextInt();
	private long b = new Random().nextInt();
	private long c = new Random().nextInt();
	private long d = new Random().nextInt();
	private long e = new Random().nextInt();
	private long f = new Random().nextInt();
	private long g = new Random().nextInt();
	private long h = new Random().nextInt();

	public BigCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.off();
	}

	@Override
	public void unExecute() {
		light.on();
	}
}
