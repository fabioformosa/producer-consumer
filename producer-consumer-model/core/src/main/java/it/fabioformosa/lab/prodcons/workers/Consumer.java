package it.fabioformosa.lab.prodcons.workers;

import it.fabioformosa.lab.prodcons.entities.Buffer;
import it.fabioformosa.lab.prodcons.entities.Item;
import it.fabioformosa.lab.prodcons.simple.SimpleConsumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class Consumer extends Worker {

	protected Log log = LogFactory.getFactory().getInstance(
			SimpleConsumer.class);

	public Consumer(int i, Buffer buffer) {
		super(i, buffer);

		log.trace(getLogHeader() + "Creating...");
	}

	@Override
	public String getLogHeader() {
		return getName() + "> ";
	}

	@Override
	public String getName() {
		return "CONS" + index;
	}

	@Override
	abstract public void run();

	protected abstract void consumeItem(Item item);

}