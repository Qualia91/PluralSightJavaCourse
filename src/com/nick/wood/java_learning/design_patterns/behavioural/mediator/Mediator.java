package com.nick.wood.java_learning.design_patterns.behavioural.mediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** only one mediator so its concrete instead of an abstract or interface class
 * if you needed multiple mediators (usually for platform difference), you would need interface or abstract class
 * used for compounded commands, each class still has single responsibility
 * this pattern is also using command pattern, they go well together
 **/
public class Mediator {

	private List<LightForMediatorPattern> lightForMediatorPatterns = new ArrayList<>();

	public void registerLight(LightForMediatorPattern...lightsForMediatorPattern) {
		lightForMediatorPatterns.addAll(Arrays.asList(lightsForMediatorPattern));
	}

	public void turnOnAllLights() {
		for (LightForMediatorPattern lightForMediatorPattern : lightForMediatorPatterns) {
			if (!lightForMediatorPattern.isOn()) {
				lightForMediatorPattern.toggle();
			}
		}
	}

	public void turnOffAllLights() {
		for (LightForMediatorPattern lightForMediatorPattern : lightForMediatorPatterns) {
			if (lightForMediatorPattern.isOn()) {
				lightForMediatorPattern.toggle();
			}
		}
	}
}
