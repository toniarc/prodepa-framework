package br.gov.pa.prodepa.util;

import java.util.Date;

public class MedicaoDesempenho {

	private Date inicio, fim;

	public MedicaoDesempenho() {
		inicio = new Date();
	}

	public void tomadaTempo() throws Exception {
		fim = new Date();
		Long tempo = fim.getTime() - inicio.getTime();
		Integer segundos = (int) (tempo / 1000);
		Integer milisegundos = (int) (tempo % 1000);
		System.out.println("### executado em " + segundos + "s e " + milisegundos + "ms ###");
	}
}