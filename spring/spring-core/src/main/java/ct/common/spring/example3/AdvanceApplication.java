package ct.common.spring.example3;

import org.apache.log4j.Logger;
import org.springframework.context.SmartLifecycle;

public class AdvanceApplication implements SmartLifecycle
{

	private static final Logger log = Logger.getLogger(AdvanceApplication.class);

	private boolean startAutomatically = true;

	private boolean isRunning = false;

	/**
	 * Can be used to initialize your Application startups if its Multi-threaded the
	 * thread Pools or managers can be Initialized here
	 */
	@Override
	public void start()
	{
		log.info("[Start of bean implementing the SmartLifecycle Interface Called. ]");
		isRunning = true;
	}

	/**
	 * Cleanup or shutdown hooks for application specific resources can be added
	 * here.
	 */
	@Override
	public void stop()
	{
		log.info("[Stop of bean implementing the LifeCycle Interface Called. ]");
		isRunning = false;

	}

	@Override
	public boolean isRunning()
	{
		return isRunning;
	}

	/**
	 * an Integer value that tells when our Been needs to be Notified when the
	 * context is refreshed. if this beans value is higher than other beans  Phase
	 * value then this bean will :
	 * <p>
	 * be called after that bean ( second bean - whose values is less)when the system starts up
	 * </p>
	 * <p>
	 * the first bean will be called before when the system is shutting down.
	 * 
	 * Higher value simply means this needs more setup compared to other bean. so
	 * can clean more things and needs event before others.
	 */
	@Override
	public int getPhase()
	{
		// Integer.MAX can be used
		return 1000;
	}

	/**
	 * interface Implementation of : @See
	 * org.springframework.context.LifecycleProcessor
	 * 
	 */
	@Override
	public boolean isAutoStartup()
	{
		return startAutomatically;
	}

	@Override
	public void stop(Runnable callback)
	{
		log.info("[ Callback runnable Called in smart lifeCycle]");

		if (callback != null) {
			try {
				callback.run();

			} catch (Exception ex) {
				// eat all the thread should not die it may be processing other details.

			}
		}

	}

}
