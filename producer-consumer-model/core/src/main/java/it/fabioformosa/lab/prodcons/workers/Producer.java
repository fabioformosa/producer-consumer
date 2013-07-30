package it.fabioformosa.lab.prodcons.workers;

import it.fabioformosa.lab.prodcons.entities.Buffer;
import it.fabioformosa.lab.prodcons.entities.Item;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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

	@Override
	protected String getLogHeader() {
		return getName() + "> ";
	}

	protected abstract Item produceItem();

}