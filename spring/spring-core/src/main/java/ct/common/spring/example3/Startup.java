package ct.common.spring.example3;

import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Start Jconsole  and from that Connect to the Startup.java class
 * you can insert an Order via Jconsole the signature should match to method
 * {@link ct.common.spring.example3.TradeEntryMBean.bookOrder}
 * @author nikhil
 *
 */
public class Startup 
{

	private static final Logger log = Logger.getLogger(Startup.class);
	
	private static final CountDownLatch latch = new CountDownLatch(1);

	public static void main(String[] args) 
	{

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.example3.xml");

		log.info("[ Context Initilized.]");

		context.start();
		log.info("[ Context Started.]");
		
		
		Runtime.getRuntime().addShutdownHook(new Thread() 
		{
			@Override
			public void run() 
			{

				context.close();
			
				log.info("[****************************************]");
				log.info("[\t * Applicaton closed *\t\t]");
				log.info("[****************************************]");
			}
		});

		context.registerShutdownHook();

		log.info("[****************************************]");
		log.info("[\t * Application Started *\t\t]");
		log.info("[****************************************]");
		
		
		await();
		
		
	}

	public static void shutDown()
    {
        latch.countDown();
    }

    /**
     * Await the reception of the shutdown signal.
     */
    public static void await()
    {
        try
        {
            latch.await();
        }
        catch (final InterruptedException ignore)
        {
            Thread.currentThread().interrupt();
        }
    }
	
}