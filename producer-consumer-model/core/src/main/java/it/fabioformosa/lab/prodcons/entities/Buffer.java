package it.fabioformosa.lab.prodcons.entities;

public interface Buffer {

	void addItem(Item i) throws InterruptedException;

	Item getItem() throws InterruptedException;

	boolean hasEmptyPlace();

	boolean isEmpty();

	boolean isFull();

	String toString();

}
