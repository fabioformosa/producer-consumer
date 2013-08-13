package it.fabioformosa.lab.prodcons.manager;

import it.fabioformosa.lab.prodcons.spi.workers.Manager;
import it.fabioformosa.lab.prodcons.spi.workers.Worker;
import it.fabioformosa.lab.prodcons.workers.WorkerFactory;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * It creates producers and consumers and invokes an exit condition to
 * terminate.
 * 
 * @author Fabio Formosa
 * 
 */
public abstract class BaseManager implements Manager {

	private static final int DEFAULT_CONSUMER_NUM = 3;
	private static final int DEFAULT_PRODUCER_NUM = 3;

	protected Log log = LogFactory.getLog(DefaultManagerImpl.class);

	protected WorkerFactory workerFactory;

	protected List<Thread> producers;
	protected List<Thread> consumers;

	protected int producerNum = DEFAULT_PRODUCER_NUM;
	protected int consumerNum = DEFAULT_CONSUMER_NUM;

	public BaseManager() {
		super();
		producers = new ArrayList<Thread>(producerNum);
		consumers = new ArrayList<Thread>(consumerNum);
	}

	@Override
	public void run() {

		setupWorkers();

		exitCondition();

	}

	public void setConsumerNum(int consumerNum) {
		this.consumerNum = consumerNum;
	}

	public void setProducerNum(int producerNum) {
		this.producerNum = producerNum;
	}

	@Override
	public void setupWorkers() {
		for (int i = 0; i < consumerNum; i++) {
			Worker consumerInstance = workerFactory.getConsumerInstance();
			Thread newConsumer = new Thread(consumerInstance,
					consumerInstance.getName());
			newConsumer.start();
			consumers.add(newConsumer);
		}

		for (int i = 0; i < producerNum; i++) {
			Worker producerInstance = workerFactory.getProducerInstance();
			Thread newProducer = new Thread(producerInstance,
					producerInstance.getName());
			newProducer.start();
			producers.add(newProducer);
		}

	}

	public void setWorkerFactory(WorkerFactory workerFactory) {
		this.workerFactory = workerFactory;
	}

}