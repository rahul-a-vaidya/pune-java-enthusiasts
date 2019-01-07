package ct.common.spring.example2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

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
	
	private List<String> holidayLists = new ArrayList<String>();
	/**
	 * Converted
	 */
	private List<LocalDate> holidayLocalDates = new ArrayList<LocalDate>();

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
		List<LocalDate> holidayCal = getHolidayCal();
		return tradeDate.equals(dt) && !holidayCal.contains(tradeDate);
	}

	public List<LocalDate> getHolidayCal()
	{
		List<LocalDate> holidayOverride = getHolidayOverride();
		holidayOverride.addAll(dtService.getHolidayCalendar());
		return holidayOverride;
		
	}

	private Consumer<String> action = (date)-> {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		formatter = formatter.withLocale( Locale.getDefault() );  
		LocalDate lclDate = LocalDate.parse(date, formatter);
		holidayLocalDates.add(lclDate);
	};
	
	public DateService getDtService()
	{
		return dtService;
	}

	@Required
	public void setDtService(DateService dtService)
	{
		log.info("[Setting dtService in Holiday Services]");
		this.dtService = dtService;
	}

	public List<LocalDate> getHolidayOverride()
	{
		return holidayLocalDates;
	}
	
	/**
	 * Not mandatory to be called can be empty
	 * @param holidayOverride
	 */
	public void setHolidayLists(List<String> holidayLists)
	{
		if(holidayLists != null )
		{
			this.holidayLists = holidayLists;
			holidayLists.forEach(action);
		}
	}

}
