package maquinap.instrucciones.booleanas;

import maquinap.valor.Valor;

public class MayorIgual extends InstruccionBooleana {

	@Override
	protected boolean compara(Valor<?> cima, Valor<?> subCima) {
		return !cima.menor(subCima);
	}
}
