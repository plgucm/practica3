package maquinap.instrucciones.booleanas;

import java.util.Stack;

import maquinap.MaquinaP;
import maquinap.instrucciones.Instruccion;
import maquinap.valor.Bool;
import maquinap.valor.Valor;

public abstract class InstruccionBooleana extends Instruccion {
	@Override
	public void ejecutar(MaquinaP maq) {
		Stack<Valor<?>> pila = maq.getPilaEvaluacion();

		if (pila.size() < 2)
			throw new UnsupportedOperationException(getClass().getSimpleName()
					+ " la pila de evaluación debe tener al menos dos valores.");

		Valor<?> cima = pila.pop();
		Valor<?> subCima = pila.pop();

		Valor<?> res = new Bool(compara(cima, subCima));

		maq.getPilaEvaluacion().push(res);
		maq.incrementaContadorPrograma();
	}

	protected abstract boolean compara(Valor<?> cima, Valor<?> subCima);
}
