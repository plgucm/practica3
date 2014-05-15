package maquinap.instrucciones.comparacion;

import java.util.Stack;

import maquinap.MaquinaP;
import maquinap.instrucciones.Instruccion;
import maquinap.valor.Bool;
import maquinap.valor.Valor;

public class Dist extends Instruccion {
	
	@Override
	public void ejecutar(MaquinaP maq) throws Exception {
		Stack<Valor<?>> pe = maq.getPilaEvaluacion();
		if (pe.isEmpty()){ return; }		
		Valor<?> valor1 = pe.pop();
		if (pe.isEmpty()){ return; }		
		Valor<?> valor2 = pe.pop();
		if (!(valor2.getValor().getClass().equals(valor1.getValor().getClass()))){
			return;
		}
		Bool newValue = new Bool(valor2.getValor()!=valor1.getValor());
		maq.getPilaEvaluacion().push(newValue);
		maq.aumentarContadorPrograma(1);
	}

}