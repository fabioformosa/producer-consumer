package it.fabioformosa.lab.prodcons.workers.simple;

import it.fabioformosa.lab.prodcons.spi.entities.Buffer;
import it.fabioformosa.lab.prodcons.workers.impl.LoopConsumer;

/**
 * 
 * Silly consumer gets an item from shared buffer and get it away.
 * 
 * @author Fabio Formosa
 * 
 */
public class SimpleConsumer extends LoopConsumer {

	public SimpleConsumer(int i, Buffer buffer) {
		super(i, buffer);
	}

	@Override
	protected void consumeItem(Object item) {

	}

}
