package com.nick.wood.java_learning.security;

import java.security.BasicPermission;
import java.security.Permission;

public final class CustomPermission extends BasicPermission {

	private final int customFactor;

	public CustomPermission(String name, String actions) {
		super(name, actions);
		customFactor = Integer.parseInt(actions);
	}

	@Override
	public boolean implies(Permission p) {

		if (!(p instanceof CustomPermission)) {
			return false;
		}

		if (super.implies(p)) {
			CustomPermission customPermission = (CustomPermission) p;
			return (customFactor >= customPermission.customFactor);
		}

		return false;
	}
}
