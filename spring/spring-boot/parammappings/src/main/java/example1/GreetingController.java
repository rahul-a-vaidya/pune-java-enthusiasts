package example1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * In Spring’s approach to building web sites, HTTP requests are handled by a
 * controller. You can easily identify these requests by the @Controller
 * annotation. In the following example, the GreetingController handles GET
 * requests for /greeting by returning the name of a View, in this case,
 * "greeting". A View is responsible for rendering the HTML content:
 * 
 * {@link https://spring.io/guides/gs/serving-web-content/}
 */
@Controller
public class GreetingController {
	
	private static final String VIEW_NAMASTE_HTML = "namaste";
	private static final String VIEW_GREETINGS_HTML = "greeting";
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return VIEW_GREETINGS_HTML;
	}

	/**
	 * <p>
	 * Try and Remove defaultValue ='Hindi' the method starts to throw an Exception.
	 * <p>
	 * default and required flag work hand in hand.
	 */
	@GetMapping("/greetingHindi")
	public String greeting(@RequestParam(name = "name", required = true) String name,
			@RequestParam(name = "language", required = true, defaultValue = "Hindi") String language, Model model) {
		model.addAttribute("name", name);

		/**
		 * Add Additional data in Model
		 */
		List<String> dataStructure = new ArrayList<String>();
		dataStructure.add("Spring");
		dataStructure.add("Functional");
		dataStructure.add("SpringBoot");

		model.addAttribute("payLoad", dataStructure);
		
		return VIEW_NAMASTE_HTML;
	}

}