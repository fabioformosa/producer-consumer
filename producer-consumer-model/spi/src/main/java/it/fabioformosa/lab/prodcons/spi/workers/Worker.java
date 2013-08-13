package it.fabioformosa.lab.prodcons.spi.workers;

import it.fabioformosa.lab.prodcons.spi.entities.Buffer;

/**
 * A worker uses the shared buffer. A worker has a index number fixed in
 * creation phase. It can be a producer or a consumer
 * 
 * @author Fabio Formosa
 * 
 */
public abstract class Worker implements Runnable {

	protected int index;
	protected Buffer buffer;

	public Worker(int index, Buffer buffer) {
		super();

		this.index = index;
		this.buffer = buffer;
	}

	public int getIndex() {
		return index;
	}

	public String getLogHeader() {
		return getName() + "> ";
	}

	public abstract String getName();

	@Override
	public abstract void run();

}