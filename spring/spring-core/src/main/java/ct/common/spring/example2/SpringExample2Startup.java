package ct.common.spring.example2;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ct.common.spring.example2.TradeService;

/**
 * Boiler plate startup class similar to Basic Startup this example enhances the
 * example 1 with checks in terms of annotations and bit of best practices when
 * coding a spring application. this tells that they are not mandatory but will
 * save a lot of hassle for other developers.
 * @author nikhil
 *
 */
public class SpringExample2Startup
{

	private static final Logger log = Logger.getLogger(SpringExample2Startup.class);

	public static void main(String[] args)
	{
		ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.example2.xml");
		log.info("[Context Initialized.]");

		TradeService ts = (TradeService) appContext.getBean("tradeService");

		ts.bookTrade();

	}
}
