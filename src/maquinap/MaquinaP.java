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
			ArrayList<String> lineSinBasura = new ArrayList<String>(); 
			
			while (sc.hasNextLine()){
				String [] line = sc.nextLine().split(" ");
				
				String dato = null;
				for (int i = 0, s = line.length; i < s; ++i){
					dato = line[i];
					if (!dato.contains(" ") && !dato.contains("\t")){
						lineSinBasura.add(dato);						
					}					
				}
				
				System.out.println(
						Arrays.toString(lineSinBasura.toArray())+'\n');
				
				Object instruccion = transformaEnInstruccion(lineSinBasura);
				agregaEnMemoriaDePrograma(instruccion);
				
				lineSinBasura.clear();
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
