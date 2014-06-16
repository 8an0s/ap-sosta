package quiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
/*Αυτή η κλάση αναλαμβάνει να διαβάσει από τα αρχεία Highscores και να τα εκχωρήσει σε πίνακα,να τα ταξινομήσει 
 * και να ελέγξει εφόσων υπάρχει νέο Highscore να ανανεώσει το αρχείο
 */
public class ScoresRW {
	static Scanner s; 
	static File f = new File("src/quiz/Classic.HighScores.txt");
	public static String  Word[]= new String[200];
	static Classicframe category = new Classicframe();
	
	//Δέχεται την κατηγορία και τον δείκτη της εγγραφής που πρέπει να επιστραφεί, και επιστρέφει την εγγραφή.
	public static String setWord(String a,int i) {
		
				try {
					s = new Scanner(f);
				} catch (FileNotFoundException e) {

					e.printStackTrace();
				}
				//Instantiate a new Array of String type
				String  theWord [] = new String[20];
				
				//while it has next ..
				int j =0;
				while(s.hasNext()){
					//Initialize variable 
					int i1=0;
					
					//store each word read in array and use variable to move across array
					theWord[i1]=s.next();

					//print 
					
					//so we increment so we can store in the next array index
					Word[j]=theWord[i1];
					j++;	
					
				}
				
				
		 a=Word[i];
		 return a;
	}
//Επιστρέφει τον πίνακα word που περιέχει όλες τις εγγραφές όλων των κατηγοριών.
	public static String[] getWord() {
		
		return Word;
		
	}
	//άνοιγμα του αρχείου των σκορ για το παιχνίδι ενάντια στο χρόνο, σε περίπτωση που πατηθεί το ανάλογο κουμπί στο παράθυρο 
	//των σκορ.
	public void changetobtt(){
		f = new File("src/quiz/btt.HighScores.txt");
	try {
		s = new Scanner(f);
	} catch (FileNotFoundException e) {

		e.printStackTrace();
	}
	
}	
	//άνοιγμα του αρχείου των σκορ για το κλασσικό παιχνίδι, σε περίπτωση που πατηθεί το ανάλογο κουμπί στο παράθυρο 
	//των σκορ.
	public void changetoclassic(){
	f = new File("src/quiz/Classic.HighScores.txt");
try {
	s = new Scanner(f);
} catch (FileNotFoundException e) {

	e.printStackTrace();
}

}
//Ταξινόμηση των εγγραφών βάσει πόντων. σε περίπτωση ισοβαθμίας δεν γίνεται αλλαγή.
 	public static String Taksinomisi(int k,String a,int l){
 		
		
		
		for(int c=k+1;c<k+19;c=c+2){
			for(int b=k+19;b>c;b=b-2){
				if(Integer.parseInt(Word[b])>Integer.parseInt(Word[b-2])){
					String x=Word[b];
					Word[b]=Word[b-2];
					Word[b-2]=x;
					x=Word[b-1];
					Word[b-1]=Word[b-3];
					Word[b-3]=x;
					
				}
			}
		}		
		
		return a=Word[l];	
 	}
	
 	 
//Η παρακάτω μέθοδος ανανεώνει το αρχείο με νέο high score, διαγράφοντας το τελευταίο (εφόσον υπάρχει high score).
 	public static void highScoreWr(int sc,int ch, boolean isQualified, String scname) throws IOException{
 		int i=0;
 		String Cat =category.cat;
 		String a1 = null;
 		String a[]=new String[200];

 		if(isQualified){
 			
 			if(ch==1){
 				f = new File("src/quiz/Classic.HighScores.txt");
 				try {
 					s = new Scanner(f);
 				} catch (FileNotFoundException e) {
 	 			
 				e.printStackTrace();
 	 		}
 		}
 			else{
 				f = new File("src/quiz/btt.HighScores.txt");
 				try {
 					s = new Scanner(f);
 				} catch (FileNotFoundException e) {
 	 			
 	 			e.printStackTrace();
 	 		}
 			
 		}
 		
 		
 			if(Cat.equals("Athlitika")) i=0;
 			else if(Cat.equals("Epistimi")) i=20;
 			else if(Cat.equals("Fagita_Pota")) i=40;
 			else if(Cat.equals("Games")) i=60;
 			else if(Cat.equals("Geografia")) i=80;
 			else if(Cat.equals("Glossa")) i=100;
 			else if(Cat.equals("Istoria")) i=120;
 			else if(Cat.equals("Technologia")) i=140;
 			else i=160;
 			int i1;
 			
 			i1=Integer.parseInt(Taksinomisi(i,a1,i+19));
 			
 			if(sc>i1){
 				setWord(Cat,0);
 	 			BufferedWriter writer = null;
 	 			f.delete(); 
 	 	 		File newF = null;
 	 	 		
 	 	 		if(ch==1){
 	 	 			newF = new File("src/quiz/Classic.HighScores.txt"); 
 	 	 		}
 	 	 		else{
 	 	 			newF = new File("src/quiz/btt.HighScores.txt");
 	 	 		} 			
 	 	 		
 	 			
 	 			
 	 	 		Word[i+19]=Taksinomisi(i,a1,i+19);
 	 	 		Word[i+19]=Integer.toString(sc);
 	 			Word[i+18]=scname;
 	 			
 	 			
 	 			
 	 			
 	 			
 	 			newF.createNewFile(); 
 	 			writer= new BufferedWriter(new FileWriter(newF));
 	 	 		for(i=0;i<180;i=i+2){
 	 	 			writer.write(Word[i]);
 	 	 			writer.write(" ");
 	 	 			writer.write(Word[i+1]);
 	 	 			writer.write(String.format("%n"));	
 	 	 	 		
 	 	 		}
 	 	 		writer.close();
 				
 			}
 		
 		

 	}
 	}
 	//έλεγχος εάν το score είναι high score, ώστε να ανανεωθούν οι εγγραφές. Επιστρέφει true εάν είναι high score.
 	public boolean isQ(int sc,int ch){
 		boolean isQualified=false;
 		int i=0;
 		String Cat =category.cat;
 		String a1 = null;
 		String a[]=new String[200];	
 		if(ch==1){
 			f = new File("src/quiz/Classic.HighScores.txt");
 	 		try {
 	 			s = new Scanner(f);
 	 		} catch (FileNotFoundException e) {
 	 			
 	 			e.printStackTrace();
 	 		}
 		}
 		else{
 			f = new File("src/quiz/btt.HighScores.txt");
 	 		try {
 	 			s = new Scanner(f);
 	 		} catch (FileNotFoundException e) {
 	 			
 	 			e.printStackTrace();
 	 		}
 			
 		}
 
 		if(Cat.equals("Athlitika")) i=0;
		else if(Cat.equals("Epistimi")) i=20;
		else if(Cat.equals("Fagita_Pota")) i=40;
		else if(Cat.equals("Games")) i=60;
		else if(Cat.equals("Geografia")) i=80;
		else if(Cat.equals("Glossa")) i=100;
		else if(Cat.equals("Istoria")) i=120;
		else if(Cat.equals("Technologia")) i=140;
		else i=160;
 		int i1;
 		i1=Integer.parseInt(Taksinomisi(i,a1,i+19));
 		if(sc>i1){
 			
 			isQualified=true; 	 		
 		}
 		
 		return isQualified;
 		
 		
 	}
 	
}



