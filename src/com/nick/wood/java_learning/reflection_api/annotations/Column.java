package com.nick.wood.java_learning.reflection_api.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// needs to be available at run time so need to add following annotation
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
}
