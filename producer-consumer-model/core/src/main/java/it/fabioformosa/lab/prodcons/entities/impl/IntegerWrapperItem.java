package it.fabioformosa.lab.prodcons.entities.impl;

import it.fabioformosa.lab.prodcons.entities.ValuedItem;

public class IntegerWrapperItem implements ValuedItem<Integer> {

	private Integer value;

	public IntegerWrapperItem(Integer value) {
		setValue(value);
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value.toString();
	}

}
