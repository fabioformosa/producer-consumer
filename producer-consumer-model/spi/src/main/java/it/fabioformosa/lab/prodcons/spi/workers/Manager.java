package it.fabioformosa.lab.prodcons.spi.workers;

public interface Manager {

	public abstract void exitCondition();

	public abstract void run();

	public abstract void setupWorkers();

}