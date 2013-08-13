package it.fabioformosa.lab.prodcons.workers.impl;

import it.fabioformosa.lab.prodcons.spi.entities.Buffer;
import it.fabioformosa.lab.prodcons.spi.workers.Consumer;

/**
 * It consumes item until manager stops it
 * 
 * @author Fabio Formosa
 * 
 */
public abstract class LoopConsumer extends Consumer {

	public LoopConsumer(int i, Buffer buffer) {
		super(i, buffer);
	}

	@Override
	public void run() {

		while (true) {
			if (Thread.currentThread().isInterrupted())
				break;

			try {
				Object item = buffer.getItem();
				consumeItem(item);
			} catch (InterruptedException e1) {
				break;
			}
		}

		log.trace(getLogHeader() + "Ended");
	}

}