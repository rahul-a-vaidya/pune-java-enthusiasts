import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Spring MVC based Annotation that tells - this class is Special its a Controlller which will take
 * decision.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/")
public class HelloPuneEnthusiasts 
{
    
    /**
     * 
     * @return
     */
    @RequestMapping()
    public String home() 
    {
		return "<b>Hello Pune Java Enthusiasts</b>  <marquee> Didn't try this in Hello World !  - This is Depricated TAG </marquee>";
	}

    @RequestMapping("/1")
	String home1() {
		return "Hello World!";
    }
    
    public static void main(String[] args) 
    {
		SpringApplication.run(HelloPuneEnthusiasts.class, args);
	}

}