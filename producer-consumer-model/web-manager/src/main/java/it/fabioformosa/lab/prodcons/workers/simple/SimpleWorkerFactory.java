package it.fabioformosa.lab.prodcons.workers.simple;

import it.fabioformosa.lab.prodcons.spi.workers.Worker;
import it.fabioformosa.lab.prodcons.workers.impl.BaseWorkerFactory;

public class SimpleWorkerFactory extends BaseWorkerFactory {

	/* (non-Javadoc)
	 * @see it.fabioformosa.lab.prodcons.standalone.workers.WorkerFactoryInt#getConsumerInstance()
	 */
	@Override
	public Worker getConsumerInstance() {
		return new SimpleConsumer(consIndex++, buffer);
	}

	/* (non-Javadoc)
	 * @see it.fabioformosa.lab.prodcons.standalone.workers.WorkerFactoryInt#getProducerInstance()
	 */
	@Override
	public Worker getProducerInstance() {
		return new SimpleProducer(prodIndex++, buffer);
	}

}
