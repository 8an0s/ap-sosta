package quiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Random;
/*���� � ����� ����������� �� ������� ��� �������� ��� ���������� ��� ��������� ��� ��� ����������,���� ��� ��������
 * ��� �� ������ (Category).txt
 */
public class Erwtiseis {
	static Scanner s; 
	static File f;
	static Scanner reader;
	static String  er[]= new String[200]; //������� ��������� ��� ����������
	static String cate;
	/*� �������� ������� ����������� �� ������� ��� ����������.������� ��������� n ��� ��� ����� ���������
	 * ��� ��������� a ��� ����� � ������� ��� �������� ��� ����� �� ���������� � ���� �������� ����� ��� ��� ������. */
	public static String setEr(String n,int a) {
		
		GUI g=new GUI();
		if (g.choice==1){
			File f = new File("src/quiz/SaveCl.txt");
			try {
				s = new Scanner(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cate=s.next();
			cate=s.next();
			cate=s.next();
			cate=s.next();
			cate=s.next();
		}
		else{
			File f = new File("src/quiz/SaveBtt.txt");
			try {
				s = new Scanner(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cate=s.next();
			cate=s.next();
			cate=s.next();
			cate=s.next();
			cate=s.next();
		}
		if(cate.equals("noname")){
			if(n==null){
				n="a";
			}
			
		}
		else{
			n=cate;
		}
				if (n.equals("Athlitika")){
					f = new File("src/quiz/Athlitika.txt");
				}
				else if(n.equals("Epistimi")){
					f = new File("src/quiz/Epistimi.txt");
				}
				else if(n.equals("Fagita_Pota")){
					f = new File("src/quiz/Fagita_Pota.txt");
				}
				else if(n.equals("Games")){
					f = new File("src/quiz/Games.txt");
				}
				else if(n.equals("Geografia")){
					f = new File("src/quiz/Geografia.txt");
				}
				else if(n.equals("Glossa")){
					f = new File("src/quiz/Glossa.txt");
				}
				else if(n.equals("Istoria")){
					f = new File("src/quiz/Istoria.txt");
				}
				else if(n.equals("Technologia")){
					f = new File("src/quiz/Technologia.txt");
				}
				else {
					f = new File("src/quiz/Texni.txt");
					
				}
				
				
				try {
					s = new Scanner(f);
				} catch (FileNotFoundException e) {

					e.printStackTrace();
				}
				//Instantiate a new Array of String type
				String  erwt [] = new String[200];
				
				//while it has next ..
				int j =0;
				int p=0;
				
				BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(f));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String line = null;
				int h=0;
				int i1=0;
				try {
					while((line=br.readLine())!=null ){
						erwt[j]=line;
						j++;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				int m=1;
				for(int k=0;k<60;k=k+6){
					if(erwt[p]==null){
						break;
					}
					er[k]=erwt[p];
					p=p+2;
					int l=k+1;
					
					StringTokenizer st =new StringTokenizer(erwt[m]);
					while (st.hasMoreElements()) {
						String token = st.nextElement().toString();
						er[l]=token;
						l++;
						}
					m=m+2;
					
					} 
				
				er[a]= er[a].replaceAll("_", " ");
				return er[a];
	}
	/*� �������� ������� ����������� �� ������� ��� �������� ��� ������ �������.������� ��������� n ��� ����� � ���������,
	 * ��������� d ��� ����� ���� ������� ��� ������� ������� ����� ��� �� 0 ����� �� 9 ��� ������� ���� ��� ������� ��� ���������� n.
	 */
	public static String setErwt(String n,double d) {
		GUI g=new GUI();
		
		if (g.choice==1){
			File f = new File("src/quiz/SaveCl.txt");
			try {
				s = new Scanner(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cate=s.next();
			cate=s.next();
			cate=s.next();
			cate=s.next();
			cate=s.next();
			
		}
		else{
			File f = new File("src/quiz/SaveBtt.txt");
			try {
				s = new Scanner(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cate=s.next();
			cate=s.next();
			cate=s.next();
			cate=s.next();
			cate=s.next();
			
		}
		if(cate.equals("noname")){
			if(n==null){
				n="a";
			}
			
		}
		else{
			n=cate;
		}
		
		if (n.equals("Athlitika")){
			f = new File("src/quiz/Athlitika.txt");
		}
		else if(n.equals("Epistimi")){
			f = new File("src/quiz/Epistimi.txt");
		}
		else if(n.equals("Fagita_Pota")){
			f = new File("src/quiz/Fagita_Pota.txt");
		}
		else if(n.equals("Games")){
			f = new File("src/quiz/Games.txt");
		}
		else if(n.equals("Geografia")){
			f = new File("src/quiz/Geografia.txt");
		}
		else if(n.equals("Glossa")){
			f = new File("src/quiz/Glossa.txt");
		}
		else if(n.equals("Istoria")){
			f = new File("src/quiz/Istoria.txt");
		}
		else if(n.equals("Technologia")){
			f = new File("src/quiz/Technologia.txt");
		}
		else {
			f = new File("src/quiz/Texni.txt");
			
		}
		 
		
		
	
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		String  erwt [] = new String[200];//������� � ������ �������� ��� ���������
		
		//while it has next ..
		int j =0;
		int p=0;
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String line = null;
		int h=0;
		int i1=0;
		try {
			while((line=br.readLine())!=null ){
				erwt[j]=line;
				j++;
				}
			
			} catch (IOException e) {
			
				e.printStackTrace();
			}	
		int m=1;
		for(int k=0;k<10;k++){
			
			er[k]=erwt[p];
			p=p+2;
			
			} 
		
		return er[(int) d];
}
		// ������� ��� ���������� ��� ������ ��� ������ ��������� ���� ����� ��� �������� ��� ��������. ������� 
		//�� ��������� ��� ������ ��� ��������� ��������.
		public static  int GetCorrect(int g){
			int cor=0;
			int x=0;
			int i;
			for(i=(g*6+1);i<(g*6+5);i++){
				if(er[i].equals(er[g*6+5])){
					x++;
					cor=x;
					break;
				}
				x++;
			}

			return cor;
		
			
		}
	
}
	
