package maquinap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

}
