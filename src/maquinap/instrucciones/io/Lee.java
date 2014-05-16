package maquinap.instrucciones.io;

import java.util.Scanner;

import maquinap.MaquinaP;
import maquinap.instrucciones.Instruccion;
import maquinap.valor.Bool;
import maquinap.valor.Int;
import maquinap.valor.Valor;

public class Lee extends Instruccion {

	@Override
	public void ejecutar(MaquinaP maq) throws Exception {
		Scanner sc = new Scanner(System.in);
		String value = sc.nextLine();		
		sc.close();
		Valor<?> valueMP;
		if (value.equalsIgnoreCase("true")){
			valueMP = new Bool(new Boolean(true));
		} else if (value.equalsIgnoreCase("false")){
			valueMP = new Bool(new Boolean(false));			
		} else {
			valueMP = new Int(Integer.valueOf(value));
		}
		maq.getPilaEvaluacion().push(valueMP);
		maq.aumentarContadorPrograma(1);
	}

}
