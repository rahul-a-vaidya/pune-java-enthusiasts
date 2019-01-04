package ct.common.spring.example1;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExample1Startup
{

private static final Logger log = Logger.getLogger(SpringExample1Startup.class);
	
	public static void main(String[] args) 
	{
		ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.example1.xml");
		log.info("[Context Initialized.]");
		
		TradeService ts = (TradeService) appContext.getBean("tradeService");
		
		ts.bookTrade();
		
	}
}
