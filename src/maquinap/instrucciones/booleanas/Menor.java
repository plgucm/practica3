package maquinap.instrucciones.booleanas;

import maquinap.valor.Valor;

public class Menor extends InstruccionBooleana {

	@Override
	protected boolean compara(Valor<?> cima, Valor<?> subCima) {
		return cima.menor(subCima);
	}
}
