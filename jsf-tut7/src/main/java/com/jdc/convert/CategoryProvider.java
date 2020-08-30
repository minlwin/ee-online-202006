package com.jdc.convert;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
public class CategoryProvider {
	
	@Named
	@Produces
	private List<Category> categories = Arrays.asList(
			new Category("Foods"),
			new Category("Drinks"),
			new Category("Fashion")
			);
}
