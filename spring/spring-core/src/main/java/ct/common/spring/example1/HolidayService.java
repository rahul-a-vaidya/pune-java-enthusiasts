package ct.common.spring.example1;

import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * This class requires Dateservice based on the region it calculates the
 * Holidays.
 * 
 * @author nikhil
 *
 */
public class HolidayService
{

	public HolidayService()
	{
		log.info("[ HolidayService Constructor Called]");
	}

	private DateService dtService;

	private static final Logger log = Logger.getLogger(HolidayService.class);

	/**
	 * Assuming we can only Trade today, future trades are not allowed but past
	 * trades are.
	 * 
	 * @param dt
	 * @return
	 */
	public boolean isValidTradeDate(LocalDate dt)
	{
		LocalDate tradeDate = dtService.getTradeDate();

		return tradeDate.equals(dt);
	}

	public List<LocalDate> getHolidayCal()
	{
		return dtService.getHolidayCalendar();
	}

	// Processors Missing
	public DateService getDtService()
	{
		return dtService;
	}

	// Processors Missing.
	public void setDtService(DateService dtService)
	{
		log.info("[Setting dtService in Holiday Services]");
		this.dtService = dtService;
	}

}
