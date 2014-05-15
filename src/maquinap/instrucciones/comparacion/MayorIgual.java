package maquinap.instrucciones.comparacion;

import java.util.Stack;

import maquinap.MaquinaP;
import maquinap.instrucciones.Instruccion;
import maquinap.valor.Bool;
import maquinap.valor.Valor;

public class MayorIgual extends Instruccion {
	
	@Override
	public void ejecutar(MaquinaP maq) {
		Stack<Valor<?>> pe = maq.getPilaEvaluacion();
		if (pe.isEmpty()){ return; }		
		Valor<?> valor1 = pe.pop();
		if (pe.isEmpty()){ return; }		
		Valor<?> valor2 = pe.pop();
		if (!(valor2.getValor().getClass().equals(valor1.getValor().getClass()))){
			return;
		}
		boolean comparacion;
		if (valor1.getValor().getClass().equals(Boolean.class)){
			// true > false
			comparacion = ((Boolean) valor1.getValor()) && !((Boolean) valor2.getValor());
		} else {
			comparacion = (Integer) valor1.getValor() < (Integer) valor2.getValor();
		}
		
		Bool newValue = new Bool(comparacion);
		maq.getPilaEvaluacion().push(newValue);
		maq.aumentarContadorPrograma(1);
	}

}
