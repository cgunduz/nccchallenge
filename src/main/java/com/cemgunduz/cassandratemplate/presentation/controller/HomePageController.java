package com.cemgunduz.cassandratemplate.presentation.controller;

import com.cemgunduz.cassandratemplate.presentation.model.URI;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomePageController {

	@RequestMapping("/")
	public String homepageInterceptor(ModelMap model) {

		return URI.HOMEPAGE.getAddress();
	}
}