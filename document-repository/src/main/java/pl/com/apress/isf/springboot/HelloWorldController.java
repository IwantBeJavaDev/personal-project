package pl.com.apress.isf.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class HelloWorldController {

	@RequestMapping("/")
	@ResponseBody
	public String getMessage() {
		return "<h1>Hello world </h1>";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(HelloWorldController.class, args);
	}
}
