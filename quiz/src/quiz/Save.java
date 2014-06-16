package quiz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/* Η παρακάτω κλάση αναλαμβάνει να υλοποιήσει την λειτουργία αποθήκευσης. γράφει στο αρχείο 
 * τις αρχικοποιημένες τιμές για τα σκορ, τις βοήθειες, τον χρόνο αλλά και τις ερωτήσεις.*/
public class Save {
	GUI g=new GUI();
	public String a;
	Scanner s;
	int miden;
	/*  Η μέθοδος που γράφει στο αρχείο τα δεδομένα που χρειάζεται να αποθηκευτούν. δέχεται την κατηγορία, το σκορ,
	*	τον χρόνο, τις βοήθειες, καθώς και τον πίνακα με τον δείκτη του που δείχνουν τις ερωτήσεις που έχουν ήδη απαντηθεί.
	*	Επιπλέον, δέχεται μετρητή που καθορίζει τους πόντους που κερδίζουν οι παίκτες σε κάθε ερώτηση, και μετρητή 
	*	αυξάνει τις ερωτήσεις, όπως ορίζουν οι κανονισμοί του παιχνιδιού.*/
	public void Write(String cat,int sc,int time,int h1,int h2,int h3,int[] questions,int curpos,int hcounter,int scoreEr) throws IOException{
		String a=cat;
		int b=sc;
		int c=time;
		int d=h1;
		int e=h2;
		int j=h3;
		int h[]=questions;
		int k=curpos;
		int l=hcounter;
		int m=scoreEr;
		if (g.choice==1){
			File f = new File("src/quiz/SaveCl.txt");
			f.delete(); 
			File newF = new File("src/quiz/SaveCL.txt");
			newF.createNewFile(); 
			BufferedWriter writer = new BufferedWriter(new FileWriter(newF));
			writer.write(d +" " +e +" " +j +" " +l+" " +a +" " +b  +" " +k +" " +m);
			for(int i=0;i<14;i++){
				writer.write(" " +h[i]);
			}
			writer.close();
		}
		else{
			File f = new File("src/quiz/SaveBtt.txt");
			f.delete(); 
			File newF = new File("src/quiz/SaveBtt.txt");
			newF.createNewFile(); 
			BufferedWriter writer = new BufferedWriter(new FileWriter(newF));
			writer.write(d +" " +e +" " +j+ " " +l + " " +a +" " +b  +" " +c +" " +k +" " +m);
			for(int i=0;i<14;i++){
				writer.write(" " +h[i]);
			}
			writer.close();
		}
		
		
		
		
	}

	// Αυτή η μέθοδος αρχικοποιεί τα αρχεία αποθήκευσης σε περίπτωση που πρέπει να διαγραφεί το αποθηκευμένο παιχνίδι.
	public void WriteNull() throws IOException{
		int d;
		int e;
		int j;
		int l;
		
		if (g.choice==1){
			Scanner scan=null;
			File f = new File("src/quiz/SaveCl.txt");
			try {
				scan = new Scanner(f);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			d=scan.nextInt();
			e=scan.nextInt();
			j=scan.nextInt();
			l=scan.nextInt();
		
		}
		
		else{
			
			Scanner scan=null;
			File f = new File("src/quiz/SaveBtt.txt");
			try {
				scan = new Scanner(f);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			d=scan.nextInt();
			e=scan.nextInt();
			j=scan.nextInt();
			l=scan.nextInt();
		}
		if (g.choice==1){
			File f = new File("src/quiz/SaveCl.txt");
			f.delete(); 
			File newF = new File("src/quiz/SaveCL.txt");
			newF.createNewFile(); 
			BufferedWriter writer = new BufferedWriter(new FileWriter(newF));
			writer.write(d +" " +e +" " +j +" " +l+" " +"noname" +" " +"0"  +" " +"0" +" " +"1");
			writer.write(" " +"4");
			for(int i=1;i<14;i++){
				writer.write(" " +"-1");
			}
			writer.close();
		}
		else{
			File f = new File("src/quiz/SaveBtt.txt");
			f.delete(); 
			File newF = new File("src/quiz/SaveBtt.txt");
			newF.createNewFile(); 
			BufferedWriter writer = new BufferedWriter(new FileWriter(newF));
			writer.write(d +" " +e +" " +j+ " " +l + " " +"noname" +" " +"0"  +" " +"60" +" " +"0" +" " +"1");
			writer.write(" " +"4");
			for(int i=1;i<14;i++){
				writer.write(" " +"-1");
			}
			writer.close();
		}
		
		
		
		
	}
		
		
	
	
}