package ct.common.spring.example3;

import javax.annotation.PostConstruct;

import org.hsqldb.util.DatabaseManagerSwing;

/**
 * patterns for Other in memory DB
 * <P><b>
 * DERBY
 * </b>
 * </P>
 * <b>
 * <code>DatabaseManagerSwing.main(new String[] { "--url", "jdbc:h2:mem:testdb", "--user", "sa", "--password", "" }) </code>
 * <P>
 * H2
 * </b>
 * </P>
 * <code>DatabaseManagerSwing.main(new String[] { "--url", "jdbc:derby:memory:testdb", "--user", "", "--password", "" }) </code>
 * 
 * @author nikhil
 *
 */
public class DBViewer
{

	/**
	 * Similar to startup but the post construct is bean specification whose processor we have added in the 
	 * Spring xml
	 */
	@PostConstruct
	public void startDBManager()
	{

		// hsqldb
		DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "SA", "--password", "" });

	}
}
