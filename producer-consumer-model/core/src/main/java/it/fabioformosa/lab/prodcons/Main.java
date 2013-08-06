package it.fabioformosa.lab.prodcons;

import it.fabioformosa.lab.prodcons.manager.BaseManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * It creates and starts a set of producer threads and a set of consumer
 * threads, then it stops to wait all producers ends. Finally it terminates all
 * consumers.
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
					new String[] { "application-context.xml" });

			BaseManager manager = (BaseManager) ctx.getBean("manager");
			manager.run();

		} catch (Exception e) {
			if (ctx != null)
				ctx.close();
			log.error(e);
		}

		log.info("MAIN> End.");
	}

}
