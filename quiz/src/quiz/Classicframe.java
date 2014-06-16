package quiz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.SystemColor;

import javax.swing.border.TitledBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

/* Η παρακάτω κλάση τοποθετεί στο κύριο παράθυρο τα περιεχόμενα του κλασσικού είδους παιχνιδιού, και χειρίζεται
 * με μεθόδους όλες τις επιμέρους λειτουργιες που χρειάζονται ώστε να λειτουργήσουν τα είδη παιχνιδιού.Επιπλέον,
 * αναπαράγει ήχο κάθε φορά που επιλέγεται μια απάντηση, διαφορετικό ανάλογα με το αν ειναι σωστή ή οχι.
 * Τέλος, υλοποιεί την λειτουργία φόρτωσης του αποθηκευμένου παιχνιδιού, εφόσον υπάρχει.
 */
public class Classicframe extends JFrame {
	int hcounter=0;
	Helps h = new Helps();
	Save s=new Save();
	int x=0;
	int sc=0;
	int j=1;
	boolean istrue = false;
	boolean firsttime = true;
	boolean iscorrect= false;
	public static String cat=null;
	JButton btnH_2;
	JButton btnH;
	JButton btnH_1;
	GUI gui = new GUI();
	String category;
	public JPanel contentPane;
	static set settingswindow = new set();
	public JButton button;
	JButton btnAnswer;
	JButton btnAnswer_1;
	JButton btnAnswer_2;
	JButton btnAnswer_3;
	int k=0;
	boolean isq;
	private static int a;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Classicframe frame = new Classicframe();
					frame.setVisible(true);
					frame.setSize(settingswindow.x,settingswindow.y);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	JLabel lblNewLabel_1;
	final Erwtiseis item=new Erwtiseis();
	JLabel lblNewLabel;
	String ap1,ap2,ap3,ap4,ap5;
	
	int questions[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0};
	static File correct=new File("src/quiz/correct.wav");
	static File fault=new File("src/quiz/fault.wav");
	public static AudioInputStream stream;
	public static AudioFormat format;
	public static DataLine.Info info;
	public static Clip clip;
	// Ο κατασκευαστής της κλάσης. Δημιουργεί τα αντικείμενα που απαιτούνται.
	public Classicframe() {
		
		double a=0;
		Scanner scan = null;
		if (gui.choice==1){
			
			File f = new File("src/quiz/SaveCl.txt");
			try {
				scan = new Scanner(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			hcounter=scan.nextInt();
			hcounter=scan.nextInt();
			hcounter=scan.nextInt();
			hcounter=scan.nextInt();
			String category=scan.next();
			sc=scan.nextInt();
			questions[14]=scan.nextInt();
			
			j=scan.nextInt();
			for(int i=0;i<13;i++){
				questions[i]=scan.nextInt();
			}
			
			if(category.equals("noname")){
				lblNewLabel = new JLabel(item.setErwt(cat,a=Math.random()*10));
				k=(int)a;
				x=k;
				questions[0]=x;		
			}
			else{
				int as = questions[14];
				a = (double)questions[as];
				cat=category;
				lblNewLabel = new JLabel(item.setErwt(cat,a));
				x=questions[as];
			}
		}
		
		else{
			
			File f = new File("src/quiz/SaveBtt.txt");
			try {
				scan = new Scanner(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			hcounter=scan.nextInt();
			hcounter=scan.nextInt();
			hcounter=scan.nextInt();
			hcounter=scan.nextInt();
			String category=scan.next();
			sc=scan.nextInt();
			gui.time.counter=scan.nextInt();
			
			
			questions[14]=scan.nextInt();
			j=scan.nextInt();
			for(int i=0;i<13;i++){
				questions[i]=scan.nextInt();
			}
			
			
			
			if(category.equals("noname")){
				lblNewLabel = new JLabel(item.setErwt(cat,a=Math.random()*10));
				k=(int)a;
				x=k;
				questions[0]=x;	
				
			}
			else{
				int as = questions[14];
				a = (double)questions[as];
				cat=category;
				lblNewLabel = new JLabel(item.setErwt(cat,a));
				x=questions[as];
			}
		}

		
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(settingswindow.x,settingswindow.y);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{13, 37, 145, 0, 61, 167, 0, 115, 115, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{59, 54, 46, 0, 0, 149, 38, -39, 53, 54, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		button = new JButton("<");
		button.setPreferredSize(new Dimension(50, 30));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				backdialog bd = new backdialog();
       		 
			}
		});

		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.WEST;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 1;
		contentPane.add(button, gbc_button);
		
		JButton button_1 = new JButton("||");
		button_1.setPreferredSize(new Dimension(50, 30));
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				gui.time.pause();
				disablebtns(istrue);
				if(istrue) istrue = false;
				else istrue = true;}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 2;
		gbc_button_1.gridy = 1;
		contentPane.add(button_1, gbc_button_1);
		
		JButton btnSave = new JButton("Αποθήκευση και έξοδος");
		btnSave.setPreferredSize(new Dimension(200, 30));
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					s.Write(cat, sc, gui.time.counter,h.noofhelps[0],h.noofhelps[1],h.noofhelps[2],questions,questions[14],hcounter,j);
					gui.backtomenu(gui.init, gui.panel, settingswindow.x, settingswindow.y);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 5;
		gbc_btnSave.gridy = 1;
		contentPane.add(btnSave, gbc_btnSave);
		
		lblNewLabel_1 = new JLabel("Σκορ: " + Integer.toString(sc));
		
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.gridheight = 2;
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.gridx = 8;
				gbc_lblNewLabel_1.gridy = 3;
				contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBorder(new TitledBorder(null, cat, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridwidth = 8;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 5;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 2;
		gbc_lblNewLabel.gridwidth = 7;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setBackground(SystemColor.activeCaption);
		
		JLabel lblTimer = timer.timerlabel;
		

		GridBagConstraints gbc_lblTimer = new GridBagConstraints();
		gbc_lblTimer.insets = new Insets(0, 0, 5, 5);
		gbc_lblTimer.gridx = 8;
		gbc_lblTimer.gridy = 8;
		contentPane.add(lblTimer, gbc_lblTimer);
		
		btnH = new JButton("("+h.noofhelps[0]+")");
		btnH.setIcon(new ImageIcon("src/quiz/h1.png"));
		btnH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(h.noofhelps[0]<1){
					btnH.setEnabled(false);
					btnH.setText("(0)");
				}
				else{
					
					erasefield(2);
					h.noofhelps[0]--;
					try {
						s.Write(cat, sc, gui.time.counter,h.noofhelps[0],h.noofhelps[1],h.noofhelps[2],questions,questions[14],hcounter,j);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					btnH.setText("(" + h.noofhelps[0] + ")");
					btnH.setVisible(false);
				}
					
			}
		});
		GridBagConstraints gbc_btnH = new GridBagConstraints();
		gbc_btnH.anchor = GridBagConstraints.SOUTH;
		gbc_btnH.insets = new Insets(0, 0, 5, 5);
		gbc_btnH.gridx = 8;
		gbc_btnH.gridy = 9;
		contentPane.add(btnH, gbc_btnH);
		
		
		ap1=item.setEr(cat, x*6+1);
		ap2=item.setEr(cat, x*6+2);
		ap3=item.setEr(cat, x*6+3);
		ap4=item.setEr(cat, x*6+4);
		ap5=item.setEr(cat, x*6+5);
		
		btnH_1 = new JButton("("+h.noofhelps[1]+")");
		btnH_1.setIcon(new ImageIcon("src/quiz/h2.png"));
		btnH_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(h.noofhelps[1]<1){
					btnH_1.setEnabled(false);
					btnH_1.setText("(0)");
				}
				else {
					h.noofhelps[1]--;
					Next();
					try {
						s.Write(cat, sc, gui.time.counter,h.noofhelps[0],h.noofhelps[1],h.noofhelps[2],questions,questions[14],hcounter,j);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					btnH_1.setVisible(false);
					btnH_1.setText("(" + h.noofhelps[1] + ")");
				}
				}
		});
		btnAnswer = new JButton("Α) "+item.setEr(cat,x*6+1));
		btnAnswer.setPreferredSize(new Dimension(200, 30));
		btnAnswer.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				iscorrect=false;
				if(ap1.equals(ap5)){
					try {
			            stream = AudioSystem.getAudioInputStream(correct);
			            format = stream.getFormat();
			            info = new DataLine.Info(Clip.class, format);
			            clip = (Clip) AudioSystem.getLine(info);
			            clip.open(stream);
			            clip.start();
			            
			            
			        }
			        catch (Exception e) {
			            //whatevers
			        }
					iscorrect = true;
					sc=sc+j*1000+j*10*gui.time.counter;
					j++;
					if(gui.choice == 1){
					EndGame end = new EndGame(iscorrect,sc,0);}
					Next();
				}
				else{
					try {
			            stream = AudioSystem.getAudioInputStream(fault);
			            format = stream.getFormat();
			            info = new DataLine.Info(Clip.class, format);
			            clip = (Clip) AudioSystem.getLine(info);
			            clip.open(stream);
			            clip.start();
			        }
			        catch (Exception e) {
			            //whatevers
			        }
					iscorrect = false;
					j++;
					if(gui.choice == 1) {
						EndGame end = new EndGame(iscorrect,sc,1);
					
				}
					else
						Next();
					
					
				}
			}
		});
		GridBagConstraints gbc_btnAnswer = new GridBagConstraints();
		gbc_btnAnswer.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnswer.gridx = 2;
		gbc_btnAnswer.gridy = 10;
		contentPane.add(btnAnswer, gbc_btnAnswer);
		
		btnAnswer_1 = new JButton("Β) "+item.setEr(cat,x*6+2));
		btnAnswer_1.setPreferredSize(new Dimension(200, 30));
		btnAnswer_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				iscorrect=false;
				
				if(ap2.equals(ap5)){
					try {
			            stream = AudioSystem.getAudioInputStream(correct);
			            format = stream.getFormat();
			            info = new DataLine.Info(Clip.class, format);
			            clip = (Clip) AudioSystem.getLine(info);
			            clip.open(stream);
			            clip.start();
			        }
			        catch (Exception e) {
			            //whatevers
			        }
					iscorrect = true;
					sc=sc+j*1000+j*10*gui.time.counter;
					
					j++;
					if(gui.choice == 1){
						EndGame end = new EndGame(iscorrect,sc,0);}
					Next();
				}
				else{
					try {
			            stream = AudioSystem.getAudioInputStream(fault);
			            format = stream.getFormat();
			            info = new DataLine.Info(Clip.class, format);
			            clip = (Clip) AudioSystem.getLine(info);
			            clip.open(stream);
			            clip.start();
			        }
			        catch (Exception e) {
			            //whatevers
			        }
					iscorrect = false;
					if(gui.choice == 1) {
						EndGame end = new EndGame(iscorrect,sc,1);
				}
					else
						Next();
					
				}
			}
		});
		GridBagConstraints gbc_btnAnswer_1 = new GridBagConstraints();
		gbc_btnAnswer_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnswer_1.gridx = 5;
		gbc_btnAnswer_1.gridy = 10;
		contentPane.add(btnAnswer_1, gbc_btnAnswer_1);
		GridBagConstraints gbc_btnH_1 = new GridBagConstraints();
		gbc_btnH_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnH_1.gridx = 8;
		gbc_btnH_1.gridy = 10;
		contentPane.add(btnH_1, gbc_btnH_1);
		
		btnH_2 = new JButton("("+h.noofhelps[2]+")");
		btnH_2.setIcon(new ImageIcon("src/quiz/h3.png"));
		btnH_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(h.noofhelps[2]<1){
					btnH_2.setEnabled(false);
					btnH_2.setText("(0)");
				}
				else{
					erasefield(3);
					h.noofhelps[2]--;
					try {
						s.Write(cat, sc, gui.time.counter,h.noofhelps[0],h.noofhelps[1],h.noofhelps[2],questions,questions[14],hcounter,j);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					btnH_2.setText("(" + h.noofhelps[2] + ")");
					btnH_2.setVisible(false);
				}
			}
		});
		
		btnAnswer_2 = new JButton("Γ) "+item.setEr(cat,x*6+3));
		btnAnswer_2.setPreferredSize(new Dimension(200, 30));
		btnAnswer_2.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				iscorrect=false;
				if(ap3.equals(ap5)){
					try {
			            stream = AudioSystem.getAudioInputStream(correct);
			            format = stream.getFormat();
			            info = new DataLine.Info(Clip.class, format);
			            clip = (Clip) AudioSystem.getLine(info);
			            clip.open(stream);
			            clip.start();
			        }
			        catch (Exception e) {
			            //whatevers
			        }
					iscorrect = true;
					sc=sc+j*1000+j*10*gui.time.counter;
					
					j++;
					if(gui.choice == 1){
						EndGame end = new EndGame(iscorrect,sc,0);}
					Next();
				}
				else{
					try {
			            stream = AudioSystem.getAudioInputStream(fault);
			            format = stream.getFormat();
			            info = new DataLine.Info(Clip.class, format);
			            clip = (Clip) AudioSystem.getLine(info);
			            clip.open(stream);
			            clip.start();
			        }
			        catch (Exception e) {
			            //whatevers
			        }
					iscorrect = false;
					if(gui.choice == 1) {
						EndGame end = new EndGame(iscorrect,sc,1);
				}
					else
						Next();
					}
			}
		});
		GridBagConstraints gbc_btnAnswer_2 = new GridBagConstraints();
		gbc_btnAnswer_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnswer_2.gridx = 2;
		gbc_btnAnswer_2.gridy = 11;
		contentPane.add(btnAnswer_2, gbc_btnAnswer_2);
		
		btnAnswer_3 = new JButton("Δ) "+item.setEr(cat,x*6+4));
		btnAnswer_3.setPreferredSize(new Dimension(200, 30));
		btnAnswer_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				iscorrect=false;
				if(ap4.equals(ap5)){
					try {
			            stream = AudioSystem.getAudioInputStream(correct);
			            format = stream.getFormat();
			            info = new DataLine.Info(Clip.class, format);
			            clip = (Clip) AudioSystem.getLine(info);
			            clip.open(stream);
			            clip.start();
			        }
			        catch (Exception e) {
			            //whatevers
			        }
					iscorrect = true;
					sc=sc+j*1000+j*10*gui.time.counter;
					j++;
					if(gui.choice == 1){
						EndGame end = new EndGame(iscorrect,sc,0);}
					Next();
				}
				else{
					try {
			            stream = AudioSystem.getAudioInputStream(fault);
			            format = stream.getFormat();
			            info = new DataLine.Info(Clip.class, format);
			            clip = (Clip) AudioSystem.getLine(info);
			            clip.open(stream);
			            clip.start();
			        }
			        catch (Exception e) {
			            //whatevers
			        }
					iscorrect = false;
					if(gui.choice == 1) {
						EndGame end = new EndGame(iscorrect,sc,1);
						disablebtns(iscorrect);
				}
					else
						Next();
					
				}
			}
		});
		GridBagConstraints gbc_btnAnswer_3 = new GridBagConstraints();
		gbc_btnAnswer_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnswer_3.gridx = 5;
		gbc_btnAnswer_3.gridy = 11;
		contentPane.add(btnAnswer_3, gbc_btnAnswer_3);
		GridBagConstraints gbc_btnH_2 = new GridBagConstraints();
		gbc_btnH_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnH_2.gridx = 8;
		gbc_btnH_2.gridy = 11;
		contentPane.add(btnH_2, gbc_btnH_2);
		
		
	}
	// Μέθοδος που δέχεται την κατηγορία που επέλεξε ο παίκτης.
	public void GetCat(String a){
		
		cat=a;
				
		
	}
	
	/* Η παρακάτω μέθοδος καλείται όταν επιλεγεί κάποια βοήθεια, ώστε να διαγράψει τις λανθασμένες απαντήσεων. 
	 * Ο αριθμός των απαντήσεων που διαγράφονται ποικίλει ανάλογα με τη βοήθεια.
	 */
	public void erasefield(int noOfFields) {
		if(noOfFields==2) {
			if(ap1.equals(ap5)) {
				btnAnswer_1.setVisible(false);
				btnAnswer_2.setVisible(false);
				repaint();
				revalidate();
			}
			else if(ap2.equals(ap5)){
				btnAnswer.setVisible(false);
				btnAnswer_2.setVisible(false);
				repaint();
				revalidate();
				}
			else if(ap3.equals(ap5)){
				btnAnswer_1.setVisible(false);
				btnAnswer_3.setVisible(false);
				repaint();
				revalidate();
				}
			else{
				btnAnswer_1.setVisible(false);
				btnAnswer.setVisible(false);
				repaint();
				revalidate();
				}			
		}
		else if(noOfFields==3) {
			
			if(ap1.equals(ap5)) {
				btnAnswer_1.setVisible(false);
				btnAnswer_2.setVisible(false);
				btnAnswer_3.setVisible(false);
				repaint();
				revalidate();
			}
			else if(ap2.equals(ap5)){
				btnAnswer.setVisible(false);
				btnAnswer_2.setVisible(false);
				btnAnswer_3.setVisible(false);
				repaint();
				revalidate();
				}
			else if(ap3.equals(ap5)){
				btnAnswer_1.setVisible(false);
				btnAnswer_3.setVisible(false);
				btnAnswer.setVisible(false);
				repaint();
				revalidate();
				}
			else{
				btnAnswer_1.setVisible(false);
				btnAnswer.setVisible(false);
				btnAnswer_2.setVisible(false);
				repaint();
				revalidate();
				}	
			
			
		}
	}
	
	/* Μέθοδος που εμφανίζει την επόμενη ερώτηση, αλλάζοντας το πεδίο που εμφανίζεται η ερώτηση και τα κουμπιά που
	 * περιέχουν τις απαντήσεις.
	 */
	public void Next(){
		btnAnswer.setVisible(true);
		btnAnswer_1.setVisible(true);
		btnAnswer_2.setVisible(true);
		btnAnswer_3.setVisible(true);
		String erwtisi;
		x=0;
		hcounter++;
		
		try {
			s.Write(cat, sc, gui.time.counter,h.noofhelps[0],h.noofhelps[1],h.noofhelps[2],questions,questions[14],hcounter,j);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(iscorrect){
		if(hcounter == 5){
			h.noofhelps[0]++;
			btnH.setText("(" + h.noofhelps[0] + ")");
		}
		else if(hcounter==10){
			h.noofhelps[1]++;
			btnH_1.setText("(" + h.noofhelps[1] + ")");
		}
		else if(hcounter==15){
			h.noofhelps[2]++; 
			hcounter=0;
			btnH_2.setText("(" + h.noofhelps[2] + ")");}
			try {
				s.Write(cat, sc, gui.time.counter,h.noofhelps[0],h.noofhelps[1],h.noofhelps[2],questions,questions[14],hcounter,j);
			} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
		}
		
		double a;
		erwtisi=item.setErwt(cat,a=Math.random()*10);
		x=(int)a;
		for(int i=0; i<10; i++) {
			if(questions[14]>8) {
				EndGame e = new EndGame(false, sc, 4);
				break;
			}
			if(questions[i] == x||x==questions[0]){
				erwtisi=item.setErwt(cat,a=Math.random()*10);
				x=(int)a;
				i=0;
				}
				
		}
		
		questions[14]++;
		int curpos = questions[14];
		questions[curpos] = x;
		
		lblNewLabel_1.setText("Σκορ: " + Integer.toString(sc));
		
		
		lblNewLabel.setText(erwtisi);
		ap1=item.setEr(cat,x*6+1);
		btnAnswer.setText("Α) "+ap1);
		ap2=item.setEr(cat,x*6+2);
		btnAnswer_1.setText("Β) "+ap2);
		ap3=item.setEr(cat,x*6+3);
		btnAnswer_2.setText("Γ) "+ap3);
		ap4=item.setEr(cat,x*6+4);
		btnAnswer_3.setText("Δ) "+ap4);
		ap5=item.setEr(cat,x*6+5);
		btnH.setVisible(true);
		btnH_1.setVisible(true);
		btnH_2.setVisible(true);
		if(h.noofhelps[0]>0)btnH.setEnabled(true);
		if(h.noofhelps[1]>0)btnH_1.setEnabled(true);
		if(h.noofhelps[2]>0)btnH_2.setEnabled(true);
		
		repaint();
		revalidate();
		if(gui.choice == 1){
			gui.time.time.stop();
			gui.time.start();
		
		JLabel lblTimer = gui.time.timerlabel;
		GridBagConstraints gbc_lblTimer = new GridBagConstraints();
		gbc_lblTimer.insets = new Insets(0, 0, 5, 5);
		gbc_lblTimer.gridx = 8;
		gbc_lblTimer.gridy = 8;
		contentPane.add(lblTimer, gbc_lblTimer);
		}
		else if(gui.choice == 2) {
			
			gui.time.time.stop();
			
			if(iscorrect) {
			gui.time.addtime();
			}
			gui.time.time.start();
		JLabel lblTimer = gui.time.timerlabel;
		
		GridBagConstraints gbc_lblTimer = new GridBagConstraints();
		gbc_lblTimer.insets = new Insets(0, 0, 5, 5);
		gbc_lblTimer.gridx = 8;
		gbc_lblTimer.gridy = 8;
		contentPane.add(lblTimer, gbc_lblTimer);
		}
		
	}
	
	/* Η μέθοδος αυτή αλλάζει την ορατότητα των απαντήσεων και της ερώτησης σε περίπτωση που πατηθεί το πλήκτρο
	 * παυσης.
	 */
	public void disablebtns(boolean istrue) {
		btnAnswer.setVisible(istrue);
		btnAnswer_1.setVisible(istrue);
		btnAnswer_2.setVisible(istrue);
		btnAnswer_3.setVisible(istrue);
		lblNewLabel.setVisible(istrue);
		btnH.setVisible(istrue);
		btnH_1.setVisible(istrue);
		btnH_2.setVisible(istrue);
		
	}
	


		
		
		
		
		
		
	
	
	
	
}
