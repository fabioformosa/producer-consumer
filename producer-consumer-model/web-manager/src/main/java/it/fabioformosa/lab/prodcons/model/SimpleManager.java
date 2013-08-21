package it.fabioformosa.lab.prodcons.model;

import it.fabioformosa.lab.prodcons.manager.DefaultManagerImpl;
import it.fabioformosa.lab.prodcons.spi.workers.Producer;
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

	private int producerCycleNum;

	public void setProducerCycleNum(int producerCycleNum) {
		this.producerCycleNum = producerCycleNum;
	}

	@Override
	protected void onProducerSetup(Producer producerInstance) {
		SimpleProducer simpleProducer = (SimpleProducer) producerInstance;
		simpleProducer.setCycleNum(producerCycleNum);
	}

}
