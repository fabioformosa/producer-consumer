package it.fabioformosa.lab.prodcons.spi.entities;

public interface Buffer {

	void addItem(Object i) throws InterruptedException;

	Object getItem() throws InterruptedException;

	boolean hasEmptyPlace();

	boolean isEmpty();

	boolean isFull();

	@Override
	String toString();

}
