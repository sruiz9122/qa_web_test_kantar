package cvsRead;

import java.io.*;
import java.util.Arrays;

public class CsvRead {

	public static final String SEPARADOR = ",";

	public static void main(String[] args) {

		BufferedReader bufferLectura = null;
		try {
			bufferLectura = new BufferedReader(new FileReader("C:/Users/ruib04/Downloads/country-2020-11-23.csv"));

			String linea = bufferLectura.readLine();

			while (linea != null) {

				String[] campos = linea.split(SEPARADOR); 

				System.out.println(Arrays.toString(campos));

				linea = bufferLectura.readLine();
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {

			if (bufferLectura != null) {
				try {
					bufferLectura.close();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}