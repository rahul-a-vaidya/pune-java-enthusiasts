package ct.common.spring.example11;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

/**
 * Class parentA contains both InjectedBeanB and InjectedBeanC
 * @author nikhil
 *
 */
@Component
public class ParentA
{
	
	private InjectedBeanB beanB;

	private InjectedBeanC beanC;
	
	private static final Logger log = Logger.getLogger(ParentA.class);
	
	public ParentA() 
	{	
		log.info("[Initialized A Bean constructor. ]");
		
	}

	public InjectedBeanB getBeanB()
	{
		return beanB;
	}
	
	@Autowired
	public void setBeanB(InjectedBeanB beanB)
	{
		log.info("[ setBeanB setter Called. ]");
		this.beanB = beanB;
	}

	public InjectedBeanC getBeanC()
	{
		return beanC;
	}

	@Autowired
	public void setBeanC(InjectedBeanC beanC)
	{
		this.beanC = beanC;
		log.info("[ setBeanC setter Called. ]");
	}
	
	public void doAction()
	{
		log.info("[ Parent A Performed its Action. ]");
		
	}

}
