package spittr.extension;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import spittr.error.SpitterHasExisted;

@ControllerAdvice
public class AppWideExceptionHandler {
	@ExceptionHandler(SpitterHasExisted.class)
	public String handleDuplicateSpitter() {
		
		return "error/duplicate";
	}
}
