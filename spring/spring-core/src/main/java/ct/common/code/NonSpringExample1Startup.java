package ct.common.code;

import org.apache.log4j.Logger;
/**
 * Boiler plate startup class similar to Basic Startup
 * @author nikhil
 *
 */
public class NonSpringExample1Startup
{

private static final Logger log = Logger.getLogger(NonSpringExample1Startup.class);
	
	public static void main(String[] args) 
	{	
		/*
		 * The Manual Wirering we do In application.
		 */
		DateService dateService = new USDateService();
		
		HolidayService hService = new HolidayService();
		hService.setDtService(dateService);
		
		TradeService tService = new TradeService();
		tService.sethService(hService);
		
		tService.bookTrade();
		
	}
}
