package it.fabioformosa.lab.prodcons.entities;


public interface ValuedItem<T> extends Item {

	T getValue();

	void setValue(T value);

}
