package it.fabioformosa.lab.prodcons.workers.impl;

import it.fabioformosa.lab.prodcons.entities.Buffer;
import it.fabioformosa.lab.prodcons.entities.Item;
import it.fabioformosa.lab.prodcons.workers.Consumer;

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
				Item item = buffer.getItem();
				consumeItem(item);
			} catch (InterruptedException e1) {
				break;
			}
		}
	
		log.trace(getLogHeader() + "Ended");
	}

}