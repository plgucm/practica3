package maquinap;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import maquinap.valor.Valor;

public class MaquinaP {

	private final Map<Integer, Valor<?>> memoriaDatos = new HashMap<Integer, Valor<?>>();
	private final Stack<Valor<?>> pilaEvaluacion = new Stack<Valor<?>>();
	private final List<Object> memoriaPrograma = new ArrayList<Object>();
	private int contadorPrograma = 0;
	private boolean ejecuta = false;


	public Map<Integer, Valor<?>> getMemoriaDatos() {
		return memoriaDatos;
	}
	
	public Stack<Valor<?>> getPilaEvaluacion() {
		return pilaEvaluacion;
	}

	public List<Object> getMemoriaPrograma() {
		return memoriaPrograma;
	}
	
	public void incrementaContadorPrograma(){
		++contadorPrograma;
	}

	public int getContadorPrograma() {
		return contadorPrograma;
	}
	
	public boolean isEjecuta() {
		return ejecuta;
	}
	
	//////////////////7777
	
	public static void main(String [] args){
		MaquinaP mp = new MaquinaP();
		mp.ejecuta("input.txt");
	}

	private void ejecuta(String archivoDeEntrada) {
		Scanner sc;
		try {
			sc = new Scanner(new File(archivoDeEntrada));
			ArrayList<String> lineaSinBasura = new ArrayList<String>(); 
			
			while (sc.hasNextLine()){
				String [] linea = sc.nextLine().split(" ");
				
				final String espacios = " ", tabulaciones = "\t";
				
				String dato = null;
				for (int i = 0, s = linea.length; i < s; ++i){
					dato = linea[i];
					if (!dato.contains(espacios) && !dato.contains(tabulaciones)){
						lineaSinBasura.add(dato);						
					}					
				}
				
				if (lineaSinBasura.size() > 0){
					System.out.println(Arrays.toString(lineaSinBasura.toArray())+'\n');
					
					Object instruccion = transformaEnInstruccion(lineaSinBasura);
					agregaEnMemoriaDePrograma(instruccion);
					
					lineaSinBasura.clear();
				}
			}
			
			sc.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Object transformaEnInstruccion(ArrayList<String> line){
		
		
		return null;
	}

	private void agregaEnMemoriaDePrograma(Object instruccion) {
		
	}	
	

}
