package com.nick.wood.plural_sight_java_course.design_patterns.structural.bridge.movie_printer_example;

import java.util.List;

public interface Formatter {

	String format(String header, List<Detail> details);
}
