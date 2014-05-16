package maquinap.instrucciones.apila;

import java.util.Stack;

import maquinap.MaquinaP;
import maquinap.instrucciones.Instruccion;
import maquinap.valor.Valor;

public class ApilaDir extends Instruccion {

	private int dir;

	public ApilaDir(int dir) {
		this.dir = dir;
	}

	@Override
	public void ejecutar(MaquinaP maq) throws Exception {
		Valor<?> valor = maq.getMemoriaDatosEstatica().get(dir);	
		
		if(valor == null)
			throw new UnsupportedOperationException(getClass().getSimpleName()
					+ " direcci√≥n no v√°lida.");
		
		Stack<Valor<?>> pe = maq.getPilaEvaluacion();
		if (pe.size() == pe.capacity()){
			throw new Exception("M·xima direcciÛn de la pila.");
		}		
		
		maq.getPilaEvaluacion().push(valor);
		maq.incrementaContadorPrograma();
	}
}
