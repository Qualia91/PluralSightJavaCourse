package com.nick.wood.plural_sight_java_course.security;

import java.security.*;
import java.util.Enumeration;

public class MySecurityManager extends SecurityManager {

	public void listPermissions() {

		Policy policy = Policy.getPolicy();

		// getClassContext() returns a list of classes that are involved in security for this location
		Class<?>[] classContext = getClassContext();

		for (Class<?> aClass : classContext) {
			ProtectionDomain pd = aClass.getProtectionDomain();
			CodeSource codeSource = pd.getCodeSource();
			PermissionCollection permissions = policy.getPermissions(codeSource);

			Enumeration<Permission> permissionEnumeration = permissions.elements();

			while (permissionEnumeration.hasMoreElements()) {
				System.out.println(permissionEnumeration.nextElement());
			}
		}
	}

}
