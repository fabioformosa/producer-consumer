package it.fabioformosa.lab.prodcons.workers;

import it.fabioformosa.lab.prodcons.entities.Buffer;
import it.fabioformosa.lab.prodcons.simple.SimpleConsumer;
import it.fabioformosa.lab.prodcons.simple.SimpleProducer;

public class WorkerFactory {

	public enum WorkerType {
		CONS, PROD
	}

	private Buffer buffer;

	static private int consIndex = 0;
	static private int prodIndex = 0;

	public Worker getConsumerInstance() {
		return new SimpleConsumer(consIndex++, buffer);
	}

	public Worker getProducerInstance() {
		return new SimpleProducer(prodIndex++, buffer);
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}

}
