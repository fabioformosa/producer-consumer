package it.fabioformosa.lab.prodcons.model;

import it.fabioformosa.lab.prodcons.manager.DefaultManagerImpl;
import it.fabioformosa.lab.prodcons.spi.workers.Consumer;
import it.fabioformosa.lab.prodcons.spi.workers.Producer;
import it.fabioformosa.lab.prodcons.workers.simple.SimpleConsumer;
import it.fabioformosa.lab.prodcons.workers.simple.SimpleProducer;

/**
 * 
 * this bean has been defined in application context. It's a default manager
 * injected with a Simple Worker Factory
 * 
 * @author Fabio Formosa
 * 
 */
public class SimpleManager extends DefaultManagerImpl {

	public enum TaskStatus {
		RUNNING, COMPLETED, UNDEFINED
	}

	private int producerCycleNum;
	private int taskId;

	private TaskStatus taskStatus;

	public int getTaskId() {
		return taskId;
	}

	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	@Override
	public void run() {
		taskStatus = TaskStatus.RUNNING;
		super.run();
		taskStatus = TaskStatus.COMPLETED;

	}

	public void setProducerCycleNum(int producerCycleNum) {
		this.producerCycleNum = producerCycleNum;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	@Override
	protected void onConsumerSetup(Consumer consumerInstance) {
		SimpleConsumer simpleConsumer = (SimpleConsumer) consumerInstance;
		simpleConsumer.setTaskId(taskId);
	}

	@Override
	protected void onProducerSetup(Producer producerInstance) {
		SimpleProducer simpleProducer = (SimpleProducer) producerInstance;
		simpleProducer.setCycleNum(producerCycleNum);
		simpleProducer.setTaskId(taskId);
	}

}
