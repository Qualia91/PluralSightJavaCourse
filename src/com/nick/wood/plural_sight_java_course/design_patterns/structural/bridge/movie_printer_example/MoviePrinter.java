package com.nick.wood.plural_sight_java_course.design_patterns.structural.bridge.movie_printer_example;

import java.util.ArrayList;
import java.util.List;

public class MoviePrinter extends Printer {

	private Movie movie;

	public MoviePrinter(Movie movie) {
		super();
		this.movie = movie;
	}

	@Override
	protected String getHeader() {
		return movie.getClassification();
	}

	@Override
	protected List<Detail> getDetails() {
		List<Detail> details = new ArrayList<>();
		details.add(new Detail("Title", movie.getTitle()));
		details.add(new Detail("Year", movie.getYear()));
		details.add(new Detail("Runtime", movie.getRuntime()));
		return details;
	}
}
