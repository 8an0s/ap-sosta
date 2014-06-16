package quiz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTabbedPane;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JComboBox;
/*Η παρακάτω κλάση δημιουργεί το παράθυρο διαλόγου Scores και να τοποθετήσει σωστά τις εγγραφές 
 * (που δέχεται απο την κλάση ScoresRW) στα πεδία τους */
public class scores extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	
	String modename  = "Ενάντια στον Χρόνο>";
	boolean m = true;

	JButton mode = new JButton(modename);
	
	JComboBox comboBox;
	int i;
	String Cat;
	int k = 0;
	
	
	JLabel label; JLabel lblScore;
	JLabel label_1; JLabel lblScore_1;
	JLabel label_2; JLabel lblScore_2;
	JLabel label_3; JLabel lblScore_3;
	JLabel label_4; JLabel lblScore_4;
	JLabel label_5; JLabel lblScore_5;
	JLabel label_6; JLabel lblScore_6;
	JLabel label_7; JLabel lblScore_7;
	JLabel label_8; JLabel lblScore_8;
	JLabel label_9; JLabel lblScore_9;
	ScoresRW item = new ScoresRW();
	String a = null;
	//Η παρακάτω μέθοδος αναλαμβάνει να δημιουργήσει το παράθυρο διαλόγου.
	public scores() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("High Scores");
		
		setBounds(100, 100, 619, 514);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(10, 2, 0, 0));
		final int no[] = new int[20];
		for(int i=0;i<20;i++) {
			no[i] = i;
		}
		
		{
			 label = new JLabel("1." + item.setWord(a, no[0]));
			contentPanel.add(label);
		}
		{
			
			 lblScore = new JLabel(item.setWord(a, no[1]));
			contentPanel.add(lblScore);
		}
		{
			label_1 = new JLabel("2." + item.setWord(a, no[2]));
			contentPanel.add(label_1);
		}
		{
			 lblScore_1 = new JLabel(item.setWord(a, no[3]));
			contentPanel.add(lblScore_1);
		}
		{
			 label_2 = new JLabel("3." + item.setWord(a, no[4]));
			contentPanel.add(label_2);
		}
		{
			 lblScore_2 = new JLabel(item.setWord(a, no[5]));
			contentPanel.add(lblScore_2);
		}
		{
			 label_3 = new JLabel("4." + item.setWord(a, no[6]));
			contentPanel.add(label_3);
		}
		{
			 lblScore_3 = new JLabel(item.setWord(a, no[7]));
			contentPanel.add(lblScore_3);
		}
		{
			 label_4 = new JLabel("5." + item.setWord(a, no[8]));
			contentPanel.add(label_4);
		}
		{
			lblScore_4 = new JLabel(item.setWord(a, no[9]));
			contentPanel.add(lblScore_4);
		}
		{
			 label_5 = new JLabel("6." + item.setWord(a, no[10]));
			contentPanel.add(label_5);
		}
		{
			 lblScore_5 = new JLabel(item.setWord(a, no[11]));
			contentPanel.add(lblScore_5);
		}
		{
			 label_6 = new JLabel("7." + item.setWord(a,no[12]));
			contentPanel.add(label_6);
		}
		{
			 lblScore_6 = new JLabel(item.setWord(a, no[13]));
			contentPanel.add(lblScore_6);
		}
		{
			 label_7 = new JLabel("8." + item.setWord(a, no[14]));
			contentPanel.add(label_7);
		}
		{
			 lblScore_7 = new JLabel(item.setWord(a, no[15]));
			contentPanel.add(lblScore_7);
		}
		{
			 label_8 = new JLabel("9." + item.setWord(a, no[16]));
			contentPanel.add(label_8);
		}
		{
			 lblScore_8 = new JLabel(item.setWord(a, no[17]));
			contentPanel.add(lblScore_8);
		}
		{
			 label_9 = new JLabel("10." + item.setWord(a, no[18]));
			contentPanel.add(label_9);
		}
		{
			 lblScore_9 = new JLabel(item.setWord(a, no[19]));
			contentPanel.add(lblScore_9);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		{
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			mode.setPreferredSize(new Dimension(300,10));
			mode.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(m) {
						modename = "< Κλασσικό";
						mode.setText(modename);
						m = false;
						item.changetobtt();
						changelabels(no,i);
						}
					else{
						modename = "Ενάντια στον Χρόνο >";
						mode.setText(modename);
						m = true;
						item.changetoclassic();
						changelabels(no,i);
						
						
					}
				}
			});
			{
				
				
				comboBox = new JComboBox();
				
				
				comboBox.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						comboBox = (JComboBox)e.getSource();
				        Cat = (String)comboBox.getSelectedItem();
						
				        if(Cat.equals("Αθλητικά")) i=0;
						else if(Cat.equals("Επιστήμη")) i=20;
						else if(Cat.equals("Φαγητά-Ποτά")) i=40;
						else if(Cat.equals("Ηλ.Παιχνίδια")) i=60;
						else if(Cat.equals("Γεωγραφία")) i=80;
						else if(Cat.equals("Γλώσσα")) i=100;
						else if(Cat.equals("Ιστορία")) i=120;
						else if(Cat.equals("Τεχνολογία")) i=140;
						else if(Cat.equals("Τέχνη")) i=160;
						


				        k=0;
				       	for(int j=i;j<i+20;j++) {
							no[k] = j;
							k++;
						}
				     
				       	changelabels(no,i);
				        
				        revalidate();
				        repaint();
					}
					
				});
				
				comboBox.addItem("Αθλητικά");
				comboBox.addItem("Επιστήμη");
				comboBox.addItem("Φαγητά-Ποτά");
				comboBox.addItem("Ηλ.Παιχνίδια");
				comboBox.addItem("Γεωγραφία");
				comboBox.addItem("Γλώσσα");
				comboBox.addItem("Ιστορία");
				comboBox.addItem("Τεχνολογία");
				comboBox.addItem("Τέχνη");
				menuBar.add(comboBox);
			}
			menuBar.add(mode);
			
		}
		
	}
	//Αυτή η μέθοδος αλλάζει το περιεχόμενο των labels που αφορούν τα ονόματα και τους πόντους των σκορ, σε περίπτωση
	//που ο παίκτης επιλέξει να δεί τα σκορ από άλλη κατηγορία.
	public void changelabels(int no[],int i) {
		
		item.setWord(Cat, no[0]);
		label.setText("1." + item.Taksinomisi(i,a,no[0]));
		label_1.setText("2." + item.Taksinomisi(i,a,no[2]));
		label_2.setText("3." + item.Taksinomisi(i,a,no[4]));
		label_3.setText("4." + item.Taksinomisi(i,a,no[6]));
		label_4.setText("5." + item.Taksinomisi(i,a,no[8]));
		label_5.setText("6." + item.Taksinomisi(i,a,no[10]));
		label_6.setText("7." + item.Taksinomisi(i,a,no[12]));
		label_7.setText("8." + item.Taksinomisi(i,a,no[14]));
		label_8.setText("9." + item.Taksinomisi(i,a,no[16]));
		label_9.setText("10." + item.Taksinomisi(i,a,no[18]));
		lblScore.setText(item.Taksinomisi(i,a,no[1]));
		lblScore_1.setText(item.Taksinomisi(i,a,no[3]));
		lblScore_2.setText(item.Taksinomisi(i,a,no[5]));
		lblScore_3.setText(item.Taksinomisi(i,a,no[7]));
		lblScore_4.setText(item.Taksinomisi(i,a,no[9]));
		lblScore_5.setText(item.Taksinomisi(i,a,no[11]));
		lblScore_6.setText(item.Taksinomisi(i,a,no[13]));
		lblScore_7.setText(item.Taksinomisi(i,a,no[15]));
		lblScore_8.setText(item.Taksinomisi(i,a,no[17]));
		lblScore_9.setText(item.Taksinomisi(i,a,no[19]));
		
	}
	

}

