package maquinap.instrucciones.booleanas;

import maquinap.valor.Valor;

public class Igual extends InstruccionBooleana {

	@Override
	protected boolean compara(Valor<?> cima, Valor<?> subCima) {		
		return	cima.equals(subCima);
	}
}
