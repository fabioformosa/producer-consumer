package it.fabioformosa.lab.prodcons.entities.impl;

import it.fabioformosa.lab.prodcons.spi.entities.Buffer;

import java.util.LinkedList;
import java.util.Queue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BufferImpl implements Buffer {

	Log log = LogFactory.getLog(BufferImpl.class);

	private int size;
	volatile private Queue<Object> buff = new LinkedList<Object>();

	public BufferImpl() {
	}

	public BufferImpl(int size) {
		this.size = size;
	}

	@Override
	synchronized public void addItem(Object item) throws InterruptedException {

		while (!hasEmptyPlace())
			wait();

		buff.add(item);
		notifyAll();
	}

	@Override
	synchronized public Object getItem() throws InterruptedException {
		while (isEmpty())
			wait();

		Object item = buff.poll();
		notifyAll();

		return item;
	}

	@Override
	public boolean hasEmptyPlace() {
		return buff.size() < size;
	}

	@Override
	public boolean isEmpty() {
		return buff.isEmpty();
	}

	@Override
	public boolean isFull() {
		return buff.size() == size;
	}

	@Override
	public String toString() {
		return "buff=" + buff;
	}

}
