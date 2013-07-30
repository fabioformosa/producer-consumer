package it.fabioformosa.lab.prodcons.workers.impl;

import it.fabioformosa.lab.prodcons.entities.Buffer;
import it.fabioformosa.lab.prodcons.entities.Item;
import it.fabioformosa.lab.prodcons.workers.Producer;

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
			Item item = produceItem();

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