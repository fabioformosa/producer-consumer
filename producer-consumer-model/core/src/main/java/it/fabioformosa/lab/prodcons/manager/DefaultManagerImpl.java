package it.fabioformosa.lab.prodcons.manager;



import java.util.List;

public class DefaultManagerImpl extends BaseManager {

	public DefaultManagerImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see it.fabioformosa.lab.prodcons.Manager#exitCondition()
	 */
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

}
