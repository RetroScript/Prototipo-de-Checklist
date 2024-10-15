package experiments.testClasses.IO.javaSerialization;

import java.util.Scanner;

public class Main {

	public Main() {
		
		Scanner s = new Scanner(System.in);
		DataStructure data = new DataStructure();
		
		
		System.out.println("dar Load? (s/n):");
		if(s.nextLine().equals("s")) {
			
			System.out.println("dando load... \n");
			
			try {
				data = (DataStructure) DataManager.load("dados.temp");
				
				System.out.println(data.nome);
				System.out.println(data.idade + "\n");
				
				System.out.println("load concluido!!!");
				
				return;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("couldn't load: " + e.getMessage());
				return;
			}
			
		}
		
		System.out.println("insira nome e idade:");
				
		System.out.print("nome: ");
		data.nome = s.nextLine();
		System.out.print("idade: ");
		data.idade = s.nextInt();
		s.nextLine();
		
		System.out.println("salvar? (s/n): ");
		if(s.nextLine().equals("s")) {
			
			System.out.println("\n salvando...");
			
			try {
				DataManager.save(data, "dados.temp");
				System.out.println("salvo");
			} catch (Exception e) {
				System.out.println("couldn't save: " + e.getMessage());
			}
			
		}
		
		
		
	}
	
	public static void main(String [] args) {
		
		Main main = new Main();
		
	}
	
}
