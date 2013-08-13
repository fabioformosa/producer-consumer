package it.fabioformosa.lab.prodcons.workers;

import it.fabioformosa.lab.prodcons.spi.entities.Buffer;
import it.fabioformosa.lab.prodcons.spi.workers.Worker;

public interface WorkerFactory {

	public abstract Worker getConsumerInstance();

	public abstract Worker getProducerInstance();

	public abstract void setBuffer(Buffer buffer);

}