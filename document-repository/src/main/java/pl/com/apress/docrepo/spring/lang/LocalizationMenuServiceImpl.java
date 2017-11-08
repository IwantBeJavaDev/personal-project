package pl.com.apress.docrepo.spring.lang;

import java.util.Locale;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LocalizationMenuServiceImpl implements LocalizationMenuService {

	public void getLocalizationMenu(ClassPathXmlApplicationContext context) {
		context.getMessage("main.title", null, new Locale("pl"));
	}

}
