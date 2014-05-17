
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Contador {
	
	public static void printInstrNumbers(BufferedReader file) throws IOException {
		String line = "";
		int row = 0;

		try {
			while ((line = file.readLine()) != null) {
				line = line.trim();

				if (line.equals("") || line.startsWith("//")) {
					System.out.println(line);
					continue;
				}

				System.out.println(row++ + " " + line);
			}
		} catch (Exception e) {
			throw new IOException("Error al leer la l�nea " + row + ": " + line.toLowerCase());
		}
	}
	
	public static void main(String[] args) {
		try {
			printInstrNumbers(new BufferedReader(new FileReader("traducción_manual.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
