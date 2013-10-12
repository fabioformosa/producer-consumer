package it.fabioformosa.lab.prodcons.spi.workers;

public interface Manager extends Runnable {

	public abstract void exitCondition();

	@Override
	public abstract void run();

	public abstract void setConsumerNum(int consumerNum);

	public abstract void setProducerNum(int producerNum);

	public abstract void setupWorkers();

}