package maquinap.instrucciones;

import maquinap.MaquinaP;
import maquinap.valor.Valor;

public class ApilaDir extends Instruccion {

	private int dir;

	public ApilaDir(int dir) {
		this.dir = dir;
	}

	@Override
	public void ejecutar(MaquinaP maq) {
		Valor<?> valor = maq.getMemoriaDatos().get(dir);
		
		if(valor == null)
			throw new UnsupportedOperationException(getClass().getSimpleName()
					+ " dirección no válida.");
		
		maq.getPilaEvaluacion().push(valor);
		maq.incrementaContadorPrograma();
	}
}
