package it.fabioformosa.lab.prodcons.dto;

import it.fabioformosa.lab.prodcons.validators.PositiveIntegerSetting;

import javax.validation.constraints.NotNull;

public class ProdConsSetting {

	@NotNull
	@PositiveIntegerSetting
	private Integer producerNumber;

	@NotNull
	@PositiveIntegerSetting
	private Integer consumerNumber;

	@NotNull
	@PositiveIntegerSetting
	private Integer prodCycleNumber;

	public Integer getConsumerNumber() {
		return consumerNumber;
	}

	public Integer getProdCycleNumber() {
		return prodCycleNumber;
	}

	public Integer getProducerNumber() {
		return producerNumber;
	}

	public void setConsumerNumber(Integer consumerNumber) {
		this.consumerNumber = consumerNumber;
	}

	public void setProdCycleNumber(Integer prodCycleNumber) {
		this.prodCycleNumber = prodCycleNumber;
	}

	public void setProducerNumber(Integer producerNumber) {
		this.producerNumber = producerNumber;
	}

	@Override
	public String toString() {
		return "ProdConsSetting [producerNumber=" + producerNumber
				+ ", consumerNumber=" + consumerNumber + ", prodCycleNumber="
				+ prodCycleNumber + "]";
	}

}
