package quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*� �������� ����� ����������� �� ������������� ��� �������� �� ��������� ��� ����� ������� 
 * � �������� ��� ������� Save. �� ����������� ���������, �������� ��� ������ ��� �������� ��� �� ������
 * ��� ����� ��� ����� ���� ���� ������.
 */
public class Helps {
	
	
	Erwtiseis e=new Erwtiseis();
	int[] noofhelps={0,0,0};
	GUI g=new GUI();
	private Scanner s;
	/*� �������� ������� ����������� �� ��������� ���� ������ noofhelps ��� ������ ��� �������� ��� ���� � �������, 
	 * ����������� ��� �� ������. 
	 */
	public Helps()  {
		
		if (g.choice==1){
			File f = new File("src/quiz/SaveCl.txt");
			try {
				s = new Scanner(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			noofhelps[0]=s.nextInt();
			noofhelps[1]=s.nextInt();
			noofhelps[2]=s.nextInt();
			
		}
		else{
			File f = new File("src/quiz/SaveBtt.txt");
			try {
				s = new Scanner(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			noofhelps[0]=s.nextInt();
			noofhelps[1]=s.nextInt();
			noofhelps[2]=s.nextInt();
			
		}
		
		
	}
	/*� �������� ������� ����������� �� ������� ���� Classicframe ��� ������ 
	 * ��� ������ ���������, ��� �������� noofq ��� ������� �� ��������� 
	 */
	public int gethelp(int noofq) {
		int correct=0;
		
		Classicframe fr = new Classicframe();
			correct=e.GetCorrect(noofq);
		    return correct;
	}

}
