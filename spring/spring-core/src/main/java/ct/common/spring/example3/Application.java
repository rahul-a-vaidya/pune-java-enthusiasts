package ct.common.spring.example3;

import org.apache.log4j.Logger;
import org.springframework.context.Lifecycle;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class Application implements Lifecycle
{

	private static final Logger log = Logger.getLogger(Application.class);

	private boolean isRunning = false;

	/**
	 * Can be used to initialize your Application startups
	 * if its Multi-threaded the thread Pools or managers can be Initialized here
	 */
	@Override
	public void start()
	{
		log.info("[Start of bean implementing the LifeCycle Interface Called ]");
		
		
		EmbeddedDatabase 	db = new EmbeddedDatabaseBuilder()
    		.setType(EmbeddedDatabaseType.HSQL)
    		.addScript("spring.example3.sql")
    		.build();
		
		isRunning = true;
	}

	/**
	 * Cleanup or shutdown hooks for application specific resources can be added
	 * here.
	 */
	@Override
	public void stop()
	{
		log.info("[Stop of bean implementing the LifeCycle Interface Called ]");
		isRunning = false;

	}

	@Override
	public boolean isRunning()
	{
		return isRunning;
	}

}
