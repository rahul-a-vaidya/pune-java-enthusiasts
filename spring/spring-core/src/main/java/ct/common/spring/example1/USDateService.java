package ct.common.spring.example1;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class USDateService implements DateService
{
	public USDateService()
	{
		log.info("[ USDate Service Constructor Called]");
	}
	private static final Logger log = Logger.getLogger(USDateService.class);
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

		holidays.add(firstJan);
		holidays.add(christmas);

		return holidays;
	}

}
