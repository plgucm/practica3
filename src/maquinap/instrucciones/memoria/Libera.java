package maquinap.instrucciones.memoria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import maquinap.MaquinaP;
import maquinap.instrucciones.Instruccion;

public class Libera extends Instruccion {

	private Integer cantidad;
	
	public Libera(Integer cantidad) {
		this.cantidad = cantidad;
	}	
	
	@Override
	public void ejecutar(MaquinaP maq) throws Exception {
		int dirPila = (Integer) maq.getPilaEvaluacion().pop().getValor();
		List<Espacio> esp = maq.getListaDeEspacios();
		
		// Uso copias para no liarla.
		int dirPilaTmp = dirPila;
		int cantidadTmp = this.cantidad;

		Collections.sort(maq.getListaDeEspacios(), comparator);	
		
		for (Espacio e : esp){
			if (e.estaEnEsteEspacioDeDirecciones(dirPilaTmp)){
				if (e.superaElTamanio(dirPilaTmp, cantidadTmp)){		
					if (e.getDir_com() < dirPilaTmp){
						// Hay que dividir en dos partes
						
						int tam = dirPilaTmp - e.getDir_com();
						esp.add(new Espacio(e.getDir_com(), tam, e.isLibre()));
						
						int tam2 = (e.getDir_com()+e.getTam())-dirPilaTmp;
						e.setTam(tam2);
						e.setDir_com(dirPilaTmp);
						e.setLibre(true);

						dirPilaTmp += tam2;
						cantidadTmp -= tam2;
						
					} else /* Tienen la misma direccion */ {
						e.setLibre(true);
						dirPilaTmp += e.getTam();
						cantidadTmp -= e.getTam();
					}	
					
				} else if (e.loLiberaExacto(dirPilaTmp, cantidadTmp)){
					if (e.getDir_com() < dirPilaTmp){
						// Hay que dividir en dos partes
						
						int tam = dirPilaTmp - e.getDir_com();
						esp.add(new Espacio(e.getDir_com(), tam, e.isLibre()));
						
						int tam2 = (e.getDir_com()+e.getTam())-dirPilaTmp;
						e.setTam(tam2);
						e.setDir_com(dirPilaTmp);
						e.setLibre(true);

						dirPilaTmp += tam2;
						cantidadTmp -= tam2;
						
					} else /* Tienen la misma direccion <-> caso ideal */ {
						e.setLibre(true);
						dirPilaTmp += e.getTam();
						cantidadTmp -= e.getTam();
					}			
					break;
					
				} else /* No lo libera completamente */ {		
					// Hay que dividir en tres partes
					
					int tam1 = dirPilaTmp - e.getDir_com();
					esp.add(new Espacio(e.getDir_com(), tam1, e.isLibre()));
					
					int tam3 = e.getDir_com() - dirPilaTmp + cantidadTmp;
					esp.add(new Espacio(dirPilaTmp+cantidadTmp, tam3, e.isLibre()));
					
					e.setLibre(true);
					e.setTam(e.getTam()-tam1-tam3);
					e.setDir_com(e.getDir_com()+tam1);
					
					dirPilaTmp += e.getTam();
					cantidadTmp -= e.getTam();
					
					break;
				}
			}
		}
		
		/* fusiona y simplifica la lista de espacios. */		
		ArrayList<Espacio> espacios = new ArrayList<Espacio>();
		
		Collections.sort(esp, comparator);		
		Iterator<Espacio> it = esp.iterator();
		Espacio eAnt = it.next();
		while (it.hasNext()){
			Espacio e = it.next();
			if (eAnt.isLibre() && e.isLibre()){
				e.setDir_com(eAnt.getDir_com());
				e.setTam(e.getTam()+eAnt.getTam());
				espacios.add(eAnt);				
			}
			eAnt = e;
		}
		
		for (Espacio e : espacios){
			esp.remove(e);
		}
		
		maq.aumentarContadorPrograma(1);		
	}	
	
	private static final Comparator<Espacio> comparator = new Comparator<Espacio>() {
		@Override
		public int compare(Espacio e1, Espacio e2) {
			return e1.compareTo(e2);
		}		
	}; 	

}
