package it.fabioformosa.lab.prodcons.simple;

import it.fabioformosa.lab.prodcons.entities.Buffer;
import it.fabioformosa.lab.prodcons.entities.Item;
import it.fabioformosa.lab.prodcons.workers.impl.LoopConsumer;

/**
 * 
 * Silly consumer get an item from shared buffer and nothing else.
 * 
 * @author Fabio Formosa
 * 
 */
public class SimpleConsumer extends LoopConsumer {

	public SimpleConsumer(int i, Buffer buffer) {
		super(i, buffer);
	}

	@Override
	protected void consumeItem(Item item) {

	}

}
