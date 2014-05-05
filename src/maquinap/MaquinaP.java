package maquinap;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class MaquinaP {

	private final Stack<Object> pilaEvaluacion = new Stack<Object>();
	private final List<Object> memoriaPrograma = new ArrayList<Object>();
	private final Integer contadorPrograma = new Integer(0);
	private final Map<Object, Object> memoriaDatos = new HashMap<Object, Object>();

	public Stack<Object> getPilaEvaluacion() {
		return pilaEvaluacion;
	}

	public List<Object> getMemoriaPrograma() {
		return memoriaPrograma;
	}

	public Integer getContadorPrograma() {
		return contadorPrograma;
	}

	public Map<Object, Object> getMemoriaDatos() {
		return memoriaDatos;
	}
	
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
