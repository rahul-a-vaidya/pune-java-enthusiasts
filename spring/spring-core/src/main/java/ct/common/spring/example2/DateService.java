package ct.common.spring.example2;

import java.time.LocalDate;
import java.util.List;
/**
 * 
 * @author nikhil
 *
 */
public interface DateService
{
	
	/**
	 * @return the Latest or Current tradeDate
	 */
	LocalDate getTradeDate();
	
	/**
	 * @return List of Holidays in the System
	 */
	List<LocalDate> getHolidayCalendar();
}
