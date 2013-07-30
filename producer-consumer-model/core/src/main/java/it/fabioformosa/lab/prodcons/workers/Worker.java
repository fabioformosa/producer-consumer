package it.fabioformosa.lab.prodcons.workers;

import it.fabioformosa.lab.prodcons.entities.Buffer;

/**
 * A worker uses the shared buffer. A worker has a index number fixed in
 * creation phase.
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

	public abstract String getName();

	public abstract void run();

	protected abstract String getLogHeader();

}