package it.fabioformosa.lab.prodcons.manager;

import it.fabioformosa.lab.prodcons.spi.workers.Consumer;
import it.fabioformosa.lab.prodcons.spi.workers.Producer;

import java.util.List;

/**
 * 
 * This manager implements the default behavior: to wait all recurrent producer
 * termination and then to interrupt all consumers
 * 
 * @author Fabio Formosa
 * 
 */
public class DefaultManagerImpl extends BaseManager {

	public DefaultManagerImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see it.fabioformosa.lab.prodcons.Manager#exitCondition()
	 */
	@Override
	public void exitCondition() {
		waitProducers(producers);
		terminateConsumers(consumers);
	}

	private void terminateConsumers(List<Thread> consumers) {
		for (Thread consumer : consumers) {
			log.info("MANAGER> Stopping " + consumer.getName());
			consumer.interrupt();
		}
	}

	private void waitProducers(List<Thread> producers) {
		for (Thread producer : producers)
			try {
				log.info("MANAGER> Waiting to join with " + producer.getName());
				producer.join();
				log.info("MANAGER> Joined with " + producer.getName());
			} catch (InterruptedException e) {
				break;
			}

	}

	@Override
	protected void onConsumerSetup(Consumer consumerInstance) {
		//noop
	}

	@Override
	protected void onProducerSetup(Producer producerInstance) {
		//noop
	}

}
