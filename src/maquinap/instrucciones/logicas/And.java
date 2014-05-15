package maquinap.instrucciones.logicas;

import java.util.Stack;

import maquinap.MaquinaP;
import maquinap.instrucciones.Instruccion;
import maquinap.valor.Bool;
import maquinap.valor.Valor;

public class And extends Instruccion {
	
	@Override
	public void ejecutar(MaquinaP maq) {
		Stack<Valor<?>> pe = maq.getPilaEvaluacion();
		if (pe.isEmpty()){ return; }		
		Valor<?> valor1 = pe.pop();
		if (!(valor1.getValor() instanceof Boolean)){
			return;
		}
		if (pe.isEmpty()){ return; }		
		Valor<?> valor2 = pe.pop();
		if (!(valor2.getValor() instanceof Boolean)){
			return;
		}
		Bool newValue = new Bool((Boolean)valor2.getValor()&&(Boolean)valor1.getValor());
		maq.getPilaEvaluacion().push(newValue);
		maq.aumentarContadorPrograma(1);
	}

}
