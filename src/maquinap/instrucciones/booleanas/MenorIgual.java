package maquinap.instrucciones.booleanas;

import maquinap.valor.Valor;

public class MenorIgual extends InstruccionBooleana {

	@Override
	protected boolean compara(Valor<?> cima, Valor<?> subCima) {
		return !cima.mayor(subCima);
	}
}
