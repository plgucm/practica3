package maquinap.instrucciones.es;

import java.util.Scanner;

import maquinap.MaquinaP;
import maquinap.instrucciones.Instruccion;
import maquinap.valor.Bool;
import maquinap.valor.Int;
import maquinap.valor.Valor;

public class Lee extends Instruccion {
	private static final Scanner entrada = new Scanner(System.in);

	@Override
	public void ejecutar(MaquinaP maq) {
		Valor<?> valor = null;

		if (entrada.hasNextInt()) {
			valor = new Int(entrada.nextInt());
		} else if (entrada.hasNextBoolean()) {
			valor = new Bool(entrada.nextBoolean());
		} else
			throw new UnsupportedOperationException(getClass().getSimpleName()
					+ " valor leido no reconocido.");

		maq.getPilaEvaluacion().push(valor);
		maq.incrementaContadorPrograma();
	}
	
	public static void cierra(){
		entrada.close();
	}
}
