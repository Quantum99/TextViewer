
import java.io.*;
import java.util.*;

public class Driver {

	public Driver(){
		menu();
		
		
	}
	
	
	public static void menu(){
		System.out.println("");
		System.out.println("---------------------------");
		System.out.println("Welcome To TextView!!!!");
		System.out.println("Here are your option:");
		System.out.println("1. Search for files");
		System.out.println("2. View 'ex.txt'");
		System.out.println("3. Exit");
		System.out.println("----------------------------");
        System.out.println("");
        System.out.print("Please select an option from 1-3");
        System.out.println("");
        System.out.println("");
        main_prompt();	
	}
	
	public static void main_prompt(){
		Scanner ui = new Scanner( System.in );
		try{	
			int choice = ui.nextInt();
			switch (choice) {
	            case 1:
	            	SearchForFile();
	                break;
	            case 2:
	            	viewDefault("ex.txt");
	                break;
	            case 3:
	                quitProgram();
	                break;
			}
		}catch(InputMismatchException ex ){
			ui.close();
			System.out.println("This is not a valid Try again please");
			menu();
		}
		finally{
			ui.close();
		}
	}

	
	public static void SearchForFile(){
		Scanner in = new Scanner( System.in );
		String filename = "ex.txt";
		
		try{
			System.out.println("Enter filename with extension default is ex.txt");
			filename = in.next();
			try {
				List tx = AppendTextArea(filename);
				System.out.println("----------------------------------------------------------------------------------------------------------------");
				tx.PrintTheList();
				System.out.println("----------------------------------------------------------------------------------------------------------------");
				System.out.println("Line Num: " + tx.CountNodes() + " " + "Word Num: " + tx.CountWords());
				promptUser();
				promptResponse(tx);
			} catch (FileNotFoundException e) {
				System.out.println(filename + " was not found");
				SearchForFile();
			}
		}
		catch(NullPointerException g){
			System.out.println("No Input Detected");
			SearchForFile();
		}
		in.close();
		
	}
	
	public static void viewDefault(String filename){
		try {
			List tx = AppendTextArea(filename);
			System.out.println("Line Num: " + tx.CountNodes() + " " + "Word Num: " + tx.CountWords());
			System.out.println("----------------------------------------------------------------------------------------------------------------");
			tx.PrintTheList();
			System.out.println("----------------------------------------------------------------------------------------------------------------");
			System.out.println("Line Num: " + tx.CountNodes() + " " + "Word Num: " + tx.CountWords());
			promptUser();
			promptResponse(tx);
		} catch (FileNotFoundException e) {
			System.out.println(filename + " was not found");
		}
	}
	
	public static void promptUser(){
		System.out.println("-------------------------------------------");
		System.out.println("1. Search for a Word");
		System.out.println("2. Sort alphabetically and display");
		System.out.println("3. Return to Menu");
		System.out.println("4. Exit the program");
		System.out.println("-------------------------------------------");
	}
	
	public static void promptResponse(List tx){
		Scanner po = new Scanner( System.in );
		try{	
			int choice = po.nextInt();
			switch (choice) {
	            case 1:
	            	SearchWord(tx);
	            	promptUser();
	    			promptResponse(tx);
	                break;
	            case 2:
	            	Tree srt = makeTree(tx);
	            	ViewSort(srt);
	            	promptUser();
	    			promptResponse(tx);
	                break;
	            case 3:
	            	menu();
	            case 4:
	                quitProgram();
	                break;
			}
		}catch(InputMismatchException ex ){
			po.close();
			System.out.println("This is not a valid Try again please");
			menu();
		}
		finally{
			po.close();
		}
		
	}
	
	public static void SearchWord(List tx){
		Tree Bst = makeTree(tx);
		System.out.println("Enter the word you are looking for :");
		Scanner vo = new Scanner( System.in );
		try{	
			String key = vo.next();
			Bst.Search(key, Bst.getRoot(), 0);
		}
		catch(InputMismatchException ex ){
			vo.close();
			System.out.println("This is not a valid Try again please");
			SearchWord(tx);
		}
		finally{
			vo.close();
		}
		System.out.println();
	}
	
	public static List AppendTextArea(String Filename) throws FileNotFoundException
	
	{
		List tx = new List();
		BufferedReader re = new BufferedReader
		        (new FileReader(Filename));
		String line = null;
		try {
			while((line = re.readLine()) != null){
				tx.InsertAtBack(line);
			}
			re.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return tx;
	}
	
	public static void ViewSort(Tree bst){
		bst.PrintSorted(bst.getRoot());
	}
	
	public static void quitProgram() {
	    System.out.println("You have quit the program");
	    System.exit(1);
	}
	
	public static Tree makeTree(List tx){
		Tree Bst = new Tree();
		Node position = tx.getHead();
		while (position != null){
			String[] words = tx.getAllStrings(position);
			for (String word : words){
				Bst.InsertNode(word);
			}
			position = position.getNextNode();
		}
		return Bst;
	}
	
	public static void main(String[] args) {
		new Driver();
		/*Tree Bst = new Tree();
		this is to test the tree
		Bst.InsertNode("saomofi");
		Bst.InsertNode("conclusionemque");
		Bst.InsertNode("deseruisse");
		Bst.InsertNode("animal");
		Bst.InsertNode("alienum");
		Bst.InsertNode("audiam");
		Bst.InsertNode("novum");
		Bst.InsertNode("blast");
		Bst.PrintSorted(Bst.getRoot());*/
	}

}

