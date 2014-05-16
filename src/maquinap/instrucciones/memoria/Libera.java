package maquinap.instrucciones.memoria;

import java.util.ArrayList;

import maquinap.MaquinaP;
import maquinap.instrucciones.Instruccion;
import maquinap.valor.Int;
import maquinap.valor.Vacio;
import maquinap.valor.Valor;

public class Libera extends Instruccion {

	private Integer cantidad;
	
	public Libera(Integer cantidad) {
		this.cantidad = cantidad;
	}	
	
	@Override
	public void ejecutar(MaquinaP maq) throws Exception {
		ArrayList<Valor<?>> md = (ArrayList<Valor<?>>) maq.getMemoriaDatosDinamica();
		
		Int direccion = (Int) maq.getPilaEvaluacion().pop();
		for (int dir = direccion.getValor(), size=dir+cantidad; dir < size; ++dir){
			md.set(dir, new Vacio());			
		}
		
		maq.aumentarContadorPrograma(1);		
	}

}
