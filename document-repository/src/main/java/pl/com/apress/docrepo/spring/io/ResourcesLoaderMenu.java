package pl.com.apress.docrepo.spring.io;

import java.io.InputStream;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component("menu")
public class ResourcesLoaderMenu {

	@Autowired
	private ResourceLoader resources;

	public void printMenu(String fileName) {
		try {
			InputStream stream = resources.getResource(fileName).getInputStream();
			Scanner scanner = new Scanner(stream);
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
