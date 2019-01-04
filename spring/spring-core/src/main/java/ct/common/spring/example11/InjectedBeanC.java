package ct.common.spring.example11;

import org.apache.log4j.Logger;

public class InjectedBeanC
{
	private static final Logger log = Logger.getLogger(InjectedBeanC.class);
	
	public InjectedBeanC()
	{
		log.info("[ BeanC Constructor Called..] ");
	}
}
