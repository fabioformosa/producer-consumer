package it.fabioformosa.lab.prodcons.spi.workers;

import it.fabioformosa.lab.prodcons.spi.entities.Buffer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @see RecurrentProducer in core.jar provides an implementation of this
 *      abstract class
 * 
 * @author Fabio Formosa
 * 
 */
public abstract class Producer extends Worker {
	protected Log log = LogFactory.getLog(Producer.class);

	public Producer(int index, Buffer buffer) {
		super(index, buffer);
	}

	@Override
	public String getName() {
		return "PROD" + index;
	}

	@Override
	public abstract void run();

	protected abstract Object produceItem();

}