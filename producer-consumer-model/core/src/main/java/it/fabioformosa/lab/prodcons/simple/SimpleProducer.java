package it.fabioformosa.lab.prodcons.simple;

import it.fabioformosa.lab.prodcons.entities.Buffer;
import it.fabioformosa.lab.prodcons.entities.Item;
import it.fabioformosa.lab.prodcons.entities.impl.IntegerWrapperItem;
import it.fabioformosa.lab.prodcons.workers.impl.RecurrentProducer;

import java.util.Random;

/**
 * 
 * Very simple producer get a random integer (0-100 range) and put it in the
 * shared buffer. His life cycle executes for a fixed number of times.
 * 
 * @author Fabio Formosa
 * 
 */
public class SimpleProducer extends RecurrentProducer {

	public SimpleProducer(int i, Buffer buffer) {
		super(i, buffer);
	}

	@Override
	protected Item produceItem() {
		Random rand = new Random();
		int num = rand.nextInt(100);
		return new IntegerWrapperItem(num);
	}

}