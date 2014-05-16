package maquinap.instrucciones.aritmeticas;

import java.util.Stack;

import maquinap.MaquinaP;
import maquinap.instrucciones.Instruccion;
import maquinap.valor.Int;
import maquinap.valor.Valor;

public class Negación extends Instruccion {

	@Override
	public void ejecutar(MaquinaP maq) {
		Stack<Valor<?>> pila = maq.getPilaEvaluacion();

		if (pila.isEmpty())
			throw new UnsupportedOperationException(getClass().getSimpleName()
					+ " la pila de evaluación está vacía.");

		Valor<?> cima = pila.pop();

		if (!(cima instanceof Int))
			throw new UnsupportedOperationException(getClass().getSimpleName()
					+ " la cima no es un entero " + cima.getClass());

		Valor<?> res = new Int(-((Int) cima).getValor());

		maq.getPilaEvaluacion().push(res);
		maq.incrementaContadorPrograma();
	}
}
