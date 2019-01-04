package ct.common.spring.example1;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class INDateService implements DateService
{
	
	/**
	 * Zero argument constructor gets defined for you automatically 
	 * added just for the sake of logging statement
	 */
	public INDateService()
	{
		log.info("[ INDate Service Constructor Called]");
	}
	private static final Logger log = Logger.getLogger(INDateService.class);
	/**
	 * Assumes current date is valid Trade Date
	 */
	@Override
	public LocalDate getTradeDate()
	{
		return LocalDate.now();
	}

	@Override
	public List<LocalDate> getHolidayCalendar()
	{

		List<LocalDate> holidays = new ArrayList<>();
		LocalDate firstJan = LocalDate.of(LocalDate.now().getYear(), Month.JANUARY, 1);
		LocalDate christmas = LocalDate.of(LocalDate.now().getYear(), Month.DECEMBER, 25);
		LocalDate republicDay = LocalDate.of(LocalDate.now().getYear(), Month.JANUARY, 26);
		LocalDate independenceDay = LocalDate.of(LocalDate.now().getYear(), Month.AUGUST, 15);

		holidays.add(firstJan);
		holidays.add(christmas);
		holidays.add(republicDay);
		holidays.add(independenceDay);

		return holidays;
	}

}
