package it.fabioformosa.lab.prodcons.loggers;

import org.apache.commons.logging.Log;

public interface LoggerFactory {

	Log getLogger(Class clazz);

}
