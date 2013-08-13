package it.fabioformosa.lab.prodcons.standalone;

import it.fabioformosa.lab.prodcons.spi.workers.Manager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * It gets the manager bean from application context and launches it
 * 
 * @author Fabio Formosa
 * @version 0.0.1
 * @since July 28, 2013
 */
public class Main {

	static private Log log = LogFactory.getLog(Main.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		log.info("MAIN> Starting...");

		AbstractApplicationContext ctx = null;
		try {
			ctx = new ClassPathXmlApplicationContext(
					new String[] { "standalone-context.xml" });

			Manager manager = (Manager) ctx.getBean("manager");
			manager.run();

		} catch (Exception e) {
			if (ctx != null)
				ctx.close();
			log.error(e);
		}

		log.info("MAIN> End.");
	}

}
