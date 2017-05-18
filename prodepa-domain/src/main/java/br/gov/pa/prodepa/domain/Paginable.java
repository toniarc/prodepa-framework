package br.gov.pa.prodepa.domain;

import java.io.Serializable;

public interface Paginable<I> extends Serializable {

	public I getId();
}