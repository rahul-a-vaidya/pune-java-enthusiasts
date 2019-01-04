package ct.common.spring.example11;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Boiler plate startup class similar to Basic Startup
 * 
 * @author nikhil This is similar to Example 1 it ends introducing the spring
 *         with annotation example
 */
public class SpringExample1Startup
{

	private static final Logger log = Logger.getLogger(SpringExample1Startup.class);

	public static void main(String[] args)
	{
		ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.example11.xml");
		log.info("[Context Initialized.]");

		ParentA ts = (ParentA) appContext.getBean("parentA");

		ts.doAction();

	}
}
