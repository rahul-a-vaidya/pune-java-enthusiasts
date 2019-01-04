package ct.common.spring.example11;

import org.apache.log4j.Logger;

/**
 * Empty Class
 * @author nikhil
 *
 */
public class InjectedBeanB
{
private static final Logger log = Logger.getLogger(InjectedBeanB.class);
	
	public InjectedBeanB()
	{
		log.info("[ BeanB Constructor Called..] ");
	}
	
}
