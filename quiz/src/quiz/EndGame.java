package quiz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
/* � ����� ���� �������� �� �������� �������� ��� ����������� �� ��������� ��� ��������� �� ��������. 
 */
public class EndGame extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	GUI g = new GUI();
	set s = new set();
	Classicframe f = new Classicframe();
	JButton okButton = new JButton("O�");
	Save sav=new Save();
	ScoresRW t= new ScoresRW();
	final JLabel label = new JLabel("����� �� ����� ��� ��� �� ��������� ���� ����� ��� ����!");
	boolean isQualified = false;
	JTextField nameinput;
	JLabel congrats = new JLabel();
	int erwt=0;
/* � ������������� ��� ������. ������� ��������� ��� ������� ��� � �������� ��� ������ ����� �����, �� ����, ��� ��� 
 * ��������� ��� ��������� ��� � ������� �������� �����, �� �������� � ������, � �� ���������.
 */
	public EndGame(boolean iscorrect,final int sc,int a) {
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(false);
		this.setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);
		okButton.setPreferredSize(new Dimension(430,30));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		nameinput = new JTextField();
		nameinput.setPreferredSize(new Dimension(200,40));
		contentPanel.add(nameinput,BorderLayout.CENTER);
		nameinput.setVisible(false);
		
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			contentPanel.add(label);
			label.setVisible(false);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		if(iscorrect){
				
				
	
			g.time.scoreg=sc;
			
					

				
		}
		else {
			setVisible(true);
			if(a==1){
				Label(2);
			}
			else if(a==2){
				Label(3);
			}
			else{
				Label(4);
			}
			try {
				sav.WriteNull();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			getContentPane().add(congrats, BorderLayout.NORTH);
			if(t.isQ(sc,g.choice)){
				nameinput.setVisible(true);
				label.setVisible(true);
				isQualified = true;
			}
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String scname = nameinput.getText();
					if(scname.isEmpty()){
						scname="noname";
					}
					scname = scname.replaceAll("\\s", "_");
					
					try {
						t.highScoreWr(sc,g.choice,isQualified, scname);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					g.backtomenu(g.init,g.panel, s.x, s.y);
					
					
					dispose();
				}
			});
			
			
		}
			
		}
	}
	// � �������� ������� ������� �� ����������� ��� �������� 
	//��� ���������� ��� �������� ��������, ������� �� ��� ��������� a.
	public void Label(int i){
	
		if(i==2){
			congrats.setText("����� ��������. ����� ����������!");
			g.backtomenu(g.init,g.panel, s.x, s.y);
		}
		else if(i==3){
			congrats.setText("� ������ ��� ��������!");
			g.backtomenu(g.init,g.panel, s.x, s.y);
		}
		else
			congrats.setText("����� ���������!");
			g.backtomenu(g.init,g.panel, s.x, s.y);
	}
	


}
