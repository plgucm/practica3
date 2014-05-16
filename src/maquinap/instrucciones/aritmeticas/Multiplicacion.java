package maquinap.instrucciones.aritmeticas;

import java.util.Stack;

import maquinap.MaquinaP;
import maquinap.instrucciones.Instruccion;
import maquinap.valor.Int;
import maquinap.valor.Valor;

public class Multiplicacion extends Instruccion {

	@Override
	public void ejecutar(MaquinaP maq) {
		Stack<Valor<?>> pila = maq.getPilaEvaluacion();

		if (pila.size() < 2)
			throw new UnsupportedOperationException(getClass().getSimpleName()
					+ " la pila de evaluación debe tener al menos dos valores.");

		Valor<?> cima = pila.pop();
		Valor<?> subCima = pila.pop();

		if (!(cima instanceof Int))
			throw new UnsupportedOperationException(getClass().getSimpleName()
					+ " la cima no es un entero " + cima.getClass());

		if (!(subCima instanceof Int))
			throw new UnsupportedOperationException(getClass().getSimpleName()
					+ " la sub-cima no es un entero " + subCima.getClass());

		Valor<?> res = new Int(((Int) subCima).getValor()
				* ((Int) cima).getValor());

		maq.getPilaEvaluacion().push(res);
		maq.incrementaContadorPrograma();
	}
}
