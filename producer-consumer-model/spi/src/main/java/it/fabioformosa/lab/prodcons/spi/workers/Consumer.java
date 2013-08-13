package it.fabioformosa.lab.prodcons.spi.workers;

import it.fabioformosa.lab.prodcons.spi.entities.Buffer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @see LoopConsumer in core.jar provides an implementation of this abstract
 *      class
 * 
 * @author Fabio Formosa
 * 
 */
public abstract class Consumer extends Worker {

	protected Log log = LogFactory.getFactory().getInstance(Consumer.class);

	public Consumer(int i, Buffer buffer) {
		super(i, buffer);

		log.trace(getLogHeader() + "Creating...");
	}

	@Override
	public String getName() {
		return "CONS" + index;
	}

	@Override
	abstract public void run();

	protected abstract void consumeItem(Object item);

}