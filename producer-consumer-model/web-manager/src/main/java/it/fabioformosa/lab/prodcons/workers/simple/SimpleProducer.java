package it.fabioformosa.lab.prodcons.workers.simple;

import it.fabioformosa.lab.prodcons.spi.entities.Buffer;
import it.fabioformosa.lab.prodcons.workers.impl.RecurrentProducer;

import java.util.Random;

/**
 * 
 * Very simple producer gets a random integer (0-100 range) and puts it in the
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
	protected Integer produceItem() {
		Random rand = new Random();
		int num = rand.nextInt(100);
		return new Integer(num);
	}

}