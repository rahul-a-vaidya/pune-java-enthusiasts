package ct.common.spring.example2;

import java.time.LocalDate;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

public class TradeService
{
	
	public TradeService()
	{
		log.info("[ Trade Service Constructor Called]");
	}
	private HolidayService hService;
	
	private static final Logger log = Logger.getLogger(TradeService.class);
	
	public void bookTrade()
	{
		boolean validTradeDate = gethService().isValidTradeDate(LocalDate.now());
		log.info("[ Trade Date validity = " + validTradeDate  + "]");
		
		
		log.info("[ The holiday calender =" +gethService().getHolidayCal() + " ]");
	}
	
	public HolidayService gethService()
	{
		return hService;
	}
	@Required
	@Resource(name = "hService")
	public void sethService(HolidayService hService)
	{
		log.info("[Setting holiday Service in Trade Services]");
		this.hService = hService;
	}
	
}



