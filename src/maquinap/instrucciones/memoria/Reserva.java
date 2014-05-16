package maquinap.instrucciones.memoria;

import java.util.ArrayList;

import maquinap.MaquinaP;
import maquinap.instrucciones.Instruccion;
import maquinap.valor.Int;
import maquinap.valor.Vacio;
import maquinap.valor.Valor;

public class Reserva extends Instruccion {
	
	private Integer cantidad;
	
	public Reserva(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public void ejecutar(MaquinaP maq) throws Exception {
		ArrayList<Valor<?>> md = (ArrayList<Valor<?>>) maq.getMemoriaDatosDinamica();
		
		int espacio = 0, direccion = 0;
		
		for (Valor<?> v : md){
			if (v instanceof Vacio){
				espacio++;
				if (espacio == cantidad){
					break;
				}
			} else {
				espacio = 0;
				direccion++;
			}
		}
		
		if (!(direccion < md.size()) || (espacio < cantidad)){
			for (int i = 0; i < cantidad; ++i){
				md.add(new Vacio());
			}
		}
		
		Int item = new Int(new Integer(direccion));
		maq.getPilaEvaluacion().push(item);
	}

}
