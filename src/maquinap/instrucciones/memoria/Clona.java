package maquinap.instrucciones.memoria;

import maquinap.MaquinaP;
import maquinap.instrucciones.Instruccion;

public class Clona extends Instruccion {
	
	private Integer cantidad;
	
	public Clona(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public void ejecutar(MaquinaP maq) throws Exception {
		// TODO		
	}

}
