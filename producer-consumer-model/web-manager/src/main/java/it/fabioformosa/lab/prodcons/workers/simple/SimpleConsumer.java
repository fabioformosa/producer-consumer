package it.fabioformosa.lab.prodcons.workers.simple;

import it.fabioformosa.lab.prodcons.spi.entities.Buffer;
import it.fabioformosa.lab.prodcons.workers.impl.LoopConsumer;

/**
 * 
 * Silly consumer gets an item from shared buffer and get it away.
 * 
 * @author Fabio Formosa
 * 
 */
public class SimpleConsumer extends LoopConsumer {

	private int taskId;

	public SimpleConsumer(int i, Buffer buffer) {
		super(i, buffer);
	}

	@Override
	public String getName() {
		return "Task-" + taskId + "-" + super.getName();
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	@Override
	protected void consumeItem(Object item) {

	}

}
