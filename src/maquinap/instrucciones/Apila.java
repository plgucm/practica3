package maquinap.instrucciones;

import maquinap.MaquinaP;
import maquinap.valor.Valor;


public class Apila extends Instruccion {

	private Valor<?> val;

	public Apila(Valor<?> val) {
		this.val = val;
	}
	
	@Override
	public void ejecutar(MaquinaP maq) {
		maq.getPilaEvaluacion().push(val);
		maq.incrementaContadorPrograma();
	}
	
}
