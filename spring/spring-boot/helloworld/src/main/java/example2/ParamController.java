package example2;

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
public class ParamController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

}