package maquinap.instrucciones.aritmeticas;

import java.util.Stack;

import maquinap.MaquinaP;
import maquinap.instrucciones.Instruccion;
import maquinap.valor.Int;
import maquinap.valor.Valor;

public class Resta extends Instruccion {
	
	@Override
	public void ejecutar(MaquinaP maq) {
		Stack<Valor<?>> pe = maq.getPilaEvaluacion();
		if (pe.isEmpty()){ return; }		
		Valor<?> valor1 = pe.pop();
		if (!(valor1.getValor() instanceof Integer)){
			return;
		}
		if (pe.isEmpty()){ return; }		
		Valor<?> valor2 = pe.pop();
		if (!(valor2.getValor() instanceof Integer)){
			return;
		}
		Int newValue = new Int((Integer)valor2.getValor()-(Integer)valor1.getValor());
		maq.getPilaEvaluacion().push(newValue);
		maq.aumentarContadorPrograma(1);
	}

}
