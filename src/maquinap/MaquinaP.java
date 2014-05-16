package maquinap;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import maquinap.instrucciones.Instruccion;
import maquinap.instrucciones.apila.Apila;
import maquinap.instrucciones.apila.ApilaDir;
import maquinap.instrucciones.aritmeticas.Div;
import maquinap.instrucciones.aritmeticas.Mod;
import maquinap.instrucciones.aritmeticas.Mult;
import maquinap.instrucciones.aritmeticas.Neg;
import maquinap.instrucciones.aritmeticas.Resta;
import maquinap.instrucciones.aritmeticas.Suma;
import maquinap.instrucciones.comparacion.Dist;
import maquinap.instrucciones.comparacion.Igual;
import maquinap.instrucciones.comparacion.Mayor;
import maquinap.instrucciones.comparacion.MayorIgual;
import maquinap.instrucciones.comparacion.Menor;
import maquinap.instrucciones.comparacion.MenorIgual;
import maquinap.instrucciones.desapila.DesapilaDir;
import maquinap.instrucciones.io.Escribe;
import maquinap.instrucciones.io.Lee;
import maquinap.instrucciones.logicas.And;
import maquinap.instrucciones.logicas.Not;
import maquinap.instrucciones.logicas.Or;
import maquinap.instrucciones.memoria.Libera;
import maquinap.instrucciones.memoria.Reserva;
import maquinap.valor.Int;
import maquinap.valor.Valor;

public class MaquinaP {

	private final Map<Integer, Valor<?>> memoriaDatosEstatica = new HashMap<Integer, Valor<?>>();	
	private final List<Valor<?>> memoriaDatosDinamica = new ArrayList<Valor<?>>();	
	private final Stack<Valor<?>> pilaEvaluacion = new Stack<Valor<?>>();
	private final List<Instruccion> memoriaPrograma = new ArrayList<Instruccion>();
	private int contadorPrograma = 0;
	private boolean ejecuta = false;


	public Map<Integer, Valor<?>> getMemoriaDatosEstatica() {
		return memoriaDatosEstatica;
	}
	
	public List<Valor<?>> getMemoriaDatosDinamica() {
		return memoriaDatosDinamica;
	}
	
	public Stack<Valor<?>> getPilaEvaluacion() {
		return pilaEvaluacion;
	}

	public List<Instruccion> getMemoriaPrograma() {
		return memoriaPrograma;
	}
	
	public void incrementaContadorPrograma(){
		++contadorPrograma;
	}
	
	public void aumentarContadorPrograma(int cantidad){
		contadorPrograma += cantidad;
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
					//System.out.println(Arrays.toString(lineaSinBasura.toArray())+'\n');
					
					Instruccion instruccion = transformaEnInstruccion(lineaSinBasura);
					agregaEnMemoriaDePrograma(instruccion);
					
					lineaSinBasura.clear();
				}
			}			
			
			sc.close();		
			
			Lee.abreEscaner();
			while (contadorPrograma < memoriaPrograma.size()){
				System.out.println("contadorPrograma:"+contadorPrograma);
				System.out.println("pilaEvaluacion:"+getPilaEvaluacion().toString());
				memoriaPrograma.get(contadorPrograma).ejecutar(this);
			}
			Lee.cierraEscaner();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Instruccion transformaEnInstruccion(ArrayList<String> line){
		int size = line.size();
		if (size ==  1){
			String inst = line.get(0);
			
			// ENTRADA / SALIDA
			
			if (inst.equalsIgnoreCase("LEE")){
				return new Lee();
			} else if (inst.equalsIgnoreCase("ESCRIBE")){
				return new Escribe();
			}
			
			// ARITMETICAS			
			
			else if (inst.equalsIgnoreCase("MUL")){
				return new Mult();
			} else if (inst.equalsIgnoreCase("SUMA")){
				return new Suma();
			} else if (inst.equalsIgnoreCase("DIV")){
				return new Div();
			} else if (inst.equalsIgnoreCase("RESTA")){
				return new Resta();
			} else if (inst.equalsIgnoreCase("MOD")){
				return new Mod();
			} else if (inst.equalsIgnoreCase("NEG")){
				return new Neg();
			} 			
			
			// COMPARACION			
			
			else if (inst.equalsIgnoreCase("IGUAL")){
				return new Igual();
			} else if (inst.equalsIgnoreCase("DISTINTO")){
				return new Dist();
			} else if (inst.equalsIgnoreCase("MENORIGUAL")){
				return new MenorIgual();
			} else if (inst.equalsIgnoreCase("MAYORIGUAL")){
				return new MayorIgual();
			} else if (inst.equalsIgnoreCase("MENOR")){
				return new Menor();
			} else if (inst.equalsIgnoreCase("MAYOR")){
				return new Mayor();
			}
			
			// LOGICAS
			
			else if (inst.equalsIgnoreCase("AND")){
				return new And();
			} else if (inst.equalsIgnoreCase("OR")){
				return new Or();
			} else if (inst.equalsIgnoreCase("NOT")){
				return new Not();
			}			
		
		} else if (size == 2){
			String inst1 = line.get(0);
			String inst2 = line.get(1);
			
			if (inst1.equalsIgnoreCase("APILA")){
				return new Apila(new Int(Integer.valueOf(inst2)));
			} else if (inst1.equalsIgnoreCase("APILA_DIR")){
				return new ApilaDir(Integer.valueOf(inst2));
			} else if (inst1.equalsIgnoreCase("DESAPILA_DIR")){
				return new DesapilaDir(Integer.valueOf(inst2));
			}else if (inst1.equalsIgnoreCase("RESERVA")){
				return new Reserva(Integer.valueOf(inst2));
			} else if (inst1.equalsIgnoreCase("LIBERA")){
				return new Libera(Integer.valueOf(inst2));
			}	
			
		}
		
		return null;
	}

	private void agregaEnMemoriaDePrograma(Instruccion instruccion) {
		memoriaPrograma.add(instruccion);
	}

	public void setContadorPrograma(int dir) {
		contadorPrograma = dir;
	}	
	

}
