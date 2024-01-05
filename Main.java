/*
  * Class:           Main
   * Author:  Muhammed-Sharif Adepetu
  * Date:     November 16, 2022
  *
   * Purpose: to play the simulator
   * 
   * 
   * 
   * Methods:
   * Main(): to play the controller
   * makeFile(output): creates and returns a file detailing what happened 
   * 
   *
   * 
  */      

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	
	public static void main(String args[]) throws IOException {

		
		simulationControler simcon = new simulationControler();
		
	
		simcon.initialize();

		
		simcon.displayNodes();

		simcon.rawMaterials();
		
		makeFile(simcon.display());
		
		
	}
	
	
	public static void makeFile(String output) throws IOException {
	
		try {
		      FileWriter chainOutput = new FileWriter("output.txt");
		      
		      chainOutput.write(output);
		      chainOutput.close();
		      
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
	
		      e.printStackTrace();
		    }

		
	}

}
