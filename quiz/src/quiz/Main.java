package quiz;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.media.CannotRealizeException;
import javax.media.NoPlayerException;

/* �� ��������� ���������� ����� ����������. ���' ��� ����, ��� ���� ���������� � ���������� ��� update ��� ��������� 
 * ��� � ��������� logo ���� ���������� ���������. 
 * ��������, ��� �� �������������� �� ��������� ���������� � ����������� ��� Java Media Framework (JMF).
 */

public class Main {

	public static void main(String[] args) throws NoPlayerException, CannotRealizeException, MalformedURLException, IOException {
		GUI a = new GUI();
		a.createAndShowGUI();
		
	}
}