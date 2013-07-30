package it.fabioformosa.lab.prodcons.entities.impl;

import it.fabioformosa.lab.prodcons.entities.Buffer;
import it.fabioformosa.lab.prodcons.entities.Item;

import java.util.LinkedList;
import java.util.Queue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimpleBufferImpl implements Buffer {

	Log log = LogFactory.getLog(SimpleBufferImpl.class);

	private int size;
	volatile private Queue<IntegerWrapperItem> buff = new LinkedList<IntegerWrapperItem>();

	public SimpleBufferImpl() {
	}

	public SimpleBufferImpl(int size) {
		this.size = size;
	}

	synchronized public void addItem(Item i) throws InterruptedException {
		if (!(i instanceof IntegerWrapperItem))
			throw new IllegalArgumentException(
					"Argument must be a IntegerWrapperItem");

		IntegerWrapperItem item = (IntegerWrapperItem) i;

		while (!hasEmptyPlace())
			wait();

		buff.add(item);
		notifyAll();
	}

	synchronized public IntegerWrapperItem getItem()
			throws InterruptedException {
		while (isEmpty())
			wait();

		IntegerWrapperItem item = buff.poll();
		notifyAll();

		return item;
	}

	public boolean hasEmptyPlace() {
		return buff.size() < size;
	}

	public boolean isEmpty() {
		return buff.isEmpty();
	}

	public boolean isFull() {
		return buff.size() == size;
	}

	@Override
	public String toString() {
		return "buff=" + buff;
	}

}
