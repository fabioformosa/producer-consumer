package it.fabioformosa.lab.prodcons.workers.impl;

import it.fabioformosa.lab.prodcons.spi.entities.Buffer;
import it.fabioformosa.lab.prodcons.spi.workers.Producer;

/**
 * 
 * it runs a cycleNum of times and it puts X items into the buffer
 * 
 * 
 * @author Fabio Formosa
 * 
 */
public abstract class RecurrentProducer extends Producer {

	static final int LIFE_CYCLE = 10;
	private int cycleNum;

	public RecurrentProducer(int i, Buffer buffer) {
		super(i, buffer);
		cycleNum = LIFE_CYCLE;

		log.trace(getLogHeader() + "Creating...");
	}

	public RecurrentProducer(int i, Buffer buffer, int cycleNum) {
		this(i, buffer);
		this.cycleNum = cycleNum;
	}

	@Override
	public void run() {
		while (cycleNum > 0) {
			Object item = produceItem();

			try {
				buffer.addItem(item);
			} catch (InterruptedException e) {
				break;
			}

			cycleNum--;
		}

		log.trace(getLogHeader() + "Ended");
	}

}