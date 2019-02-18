package example1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Spring MVC based Annotation that tells - this class is Special its a Controlller which will take
 * decision.
 */

@SpringBootApplication
//@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
/**
 *  @ComponentScan(basePackageClasses = {GreetingController.class})
 *  @ComponentScan({"example1.HelloPuneEnthusiasts"})
 * Use it the type safe way
 * */
public class HelloPuneEnthusiasts 
{
    
    /* 
     * 
     * @return
     */
    @RequestMapping()
    public String home() 
    {
		return "<b>Hello Pune Enthusiasts</b>  <marquee> Didn't try this in Hello World !  - This is Depricated TAG </marquee>";
	}

    @RequestMapping("/1")
    String home1() 
    {
		return "Hello World!";
    }
    
    public static void main(String[] args) 
    {
		SpringApplication.run(HelloPuneEnthusiasts.class, args);
	}

}