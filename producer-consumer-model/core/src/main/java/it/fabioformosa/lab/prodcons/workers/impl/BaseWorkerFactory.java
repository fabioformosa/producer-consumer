package it.fabioformosa.lab.prodcons.workers.impl;

import it.fabioformosa.lab.prodcons.spi.entities.Buffer;
import it.fabioformosa.lab.prodcons.spi.workers.Worker;
import it.fabioformosa.lab.prodcons.workers.WorkerFactory;

public abstract class BaseWorkerFactory implements WorkerFactory {

	public enum WorkerType {
		CONS, PROD
	}

	protected Buffer buffer;
	protected static int consIndex = 0;
	protected static int prodIndex = 0;

	public BaseWorkerFactory() {
		super();
	}

	@Override
	public abstract Worker getConsumerInstance();

	@Override
	public abstract Worker getProducerInstance();

	@Override
	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}

}