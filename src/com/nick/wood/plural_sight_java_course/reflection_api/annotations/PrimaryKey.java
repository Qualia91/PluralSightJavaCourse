package com.nick.wood.plural_sight_java_course.reflection_api.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// needs to be available at run time so need to add following annotation
@Retention(RetentionPolicy.RUNTIME)
public @interface PrimaryKey {
}
