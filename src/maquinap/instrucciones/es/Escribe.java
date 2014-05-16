package maquinap.instrucciones.es;

import java.util.Stack;

import maquinap.MaquinaP;
import maquinap.instrucciones.Instruccion;
import maquinap.valor.Valor;

public class Escribe extends Instruccion {

	@Override
	public void ejecutar(MaquinaP maq) {
		Stack<Valor<?>> pila = maq.getPilaEvaluacion();

		if (pila.isEmpty())
			throw new UnsupportedOperationException(getClass().getSimpleName()
					+ " la pila de evaluación está vacía.");

		System.out.println(pila.pop().toString());
		maq.incrementaContadorPrograma();		
	}
}
