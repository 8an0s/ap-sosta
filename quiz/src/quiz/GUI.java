package quiz;
 
import java.awt.*;

import javax.media.*;

import java.net.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

/* H κλάση GUI υλοποιεί όλα τα γραφικά του αρχικού μενού και καθορίζει το μέγεθος του frame του μενού και του κάθε είδους 
 * παιχιδιού. Επιπλέον, αναλαμβάνει να αναπαράγει την μουσική του παιχνιδιού.
 */
public class GUI {
	public static timer time = new timer();
	public static JPanel panel = new JPanel();
	public static JFrame init = new JFrame("quiz");
	private static final JLabel lblLogo = new JLabel("");
	static int choice;
	static File soundf=new File("src/quiz/soundtrack.wav");
	public static AudioInputStream stream;
	public static AudioFormat format;
	public static DataLine.Info info;
	public static Clip clip;
   
	/* Η μέθοδος αυτή δημιουργεί και διαμορφώνει το κύριο παράθυρο, τοποθετεί τα περιεχόμενα
	 *  του κυρίου μενού, και αναπαράγει τη μουσικη.
	 */
    public static void createAndShowGUI() throws NoPlayerException, CannotRealizeException, MalformedURLException, IOException {
    	
    	try {
    	    for (LookAndFeelInfo info1 : UIManager.getInstalledLookAndFeels()) {
    	        if ("Nimbus".equals(info1.getName())) {
    	            UIManager.setLookAndFeel(info1.getClassName());
    	            break;
    	        }
    	    }
    	} catch (Exception e) {

    	}
    	final set settingswindow = new set();
    	final scores scorewindow = new scores();
        
        init.getContentPane().setBackground(SystemColor.inactiveCaption);
        init.setTitle("ΑΠΑΝΤΗΣΕ ΣΩΣΤΑ");
        init.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init.pack();
        init.setVisible(true);
        init.repaint();
        
     
		final CategoriesPick startclassic = new CategoriesPick();
        init.setSize(800,600);
        final JPanel cpcp = startclassic.contentPane;


        Container contentPane = init.getContentPane();
        contentPane.setLayout(new FlowLayout());       
 
        panel = new JPanel();
        panel.setBackground(UIManager.getColor("Tree.selectionBackground"));
        panel.setLayout(null);
        panel.setSize(800, 600);
        init.getContentPane().add(panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{438, 0};
        gbl_panel.rowHeights = new int[]{245, 39, 39, 39, 39, 0, 39, 0};
        gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);
        lblLogo.setIcon(new ImageIcon("src/quiz/logo.png"));
        GridBagConstraints gbc_lblLogo = new GridBagConstraints();
        gbc_lblLogo.fill = GridBagConstraints.BOTH;
        gbc_lblLogo.insets = new Insets(0, 0, 5, 0);
        gbc_lblLogo.gridx = 0;
        gbc_lblLogo.gridy = 0;
        panel.add(lblLogo, gbc_lblLogo);
        
        JButton btnClassic = new JButton("ΚΛΑΣΣΙΚΟ");
        btnClassic.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        btnClassic.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent arg0) {
        		Scanner scan = null;
        		File f = new File("src/quiz/SaveCl.txt");
        		try {
    				scan = new Scanner(f);
    			} catch (FileNotFoundException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
        		int a=scan.nextInt();
    			a=scan.nextInt();
    			a=scan.nextInt();
    			a=scan.nextInt();
    			String cat=scan.next();
        		if(cat.equals("noname")){
        			init.getContentPane().removeAll();
        			init.getContentPane().setLayout(new BorderLayout());
        			init.getContentPane().add(cpcp, BorderLayout.CENTER);
        			init.revalidate();
        			init.repaint();
        			choice = 1;
        		}
        		else{
        			choice=1;
        			final Classicframe startclassic = new Classicframe();
            		final JPanel classiccp = startclassic.contentPane;
            		
            		 init.getContentPane().removeAll();
            		 init.getContentPane().setLayout(new BorderLayout());
            		 init.getContentPane().add(classiccp, BorderLayout.CENTER);
            		 init.revalidate();
            		 init.repaint();
            		 time.start();
        		}
        			
        	}
        });
        GridBagConstraints gbc_btnClassic = new GridBagConstraints();
        gbc_btnClassic.fill = GridBagConstraints.BOTH;
        gbc_btnClassic.insets = new Insets(0, 0, 5, 0);
        gbc_btnClassic.gridx = 0;
        gbc_btnClassic.gridy = 1;
        panel.add(btnClassic, gbc_btnClassic);
        JButton Start2 = new JButton("ΕΝΑΝΤΙΑ ΣΤΟ ΧΡΟΝΟ");
        Start2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Scanner scan = null;
        		File f = new File("src/quiz/SaveBtt.txt");
        		try {
    				scan = new Scanner(f);
    			} catch (FileNotFoundException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
        		int a=scan.nextInt();
    			a=scan.nextInt();
    			a=scan.nextInt();
    			a=scan.nextInt();
    			String cat=scan.next();
        		if(cat.equals("noname")){
        			init.getContentPane().removeAll();
        			init.getContentPane().setLayout(new BorderLayout());
        			init.getContentPane().add(cpcp, BorderLayout.CENTER);
        			init.revalidate();
        			init.repaint();
        			choice = 2;
        		}
        		else{
        			choice=2;
        			final Classicframe startclassic = new Classicframe();
            		final JPanel classiccp = startclassic.contentPane;
            		
            		 init.getContentPane().removeAll();
            		 init.getContentPane().setLayout(new BorderLayout());
            		 init.getContentPane().add(classiccp, BorderLayout.CENTER);
            		 init.revalidate();
            		 init.repaint();
            		 time.start();
            		 }
        	}
        	
        });
        GridBagConstraints gbc_Start2 = new GridBagConstraints();
        gbc_Start2.fill = GridBagConstraints.BOTH;
        gbc_Start2.insets = new Insets(0, 0, 5, 0);
        gbc_Start2.gridx = 0;
        gbc_Start2.gridy = 2;
        panel.add(Start2, gbc_Start2);
        JButton highscores = new JButton("ΣΚΟΡ");
        highscores.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		scorewindow.setVisible(true);
        	}
        });
        
        JButton Settings = new JButton("ΕΠΙΛΟΓΕΣ");
        Settings.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        Settings.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		settingswindow.setVisible(true);
        	}
        });
       
        GridBagConstraints gbc_highscores = new GridBagConstraints();
        gbc_highscores.fill = GridBagConstraints.BOTH;
        gbc_highscores.insets = new Insets(0, 0, 5, 0);
        gbc_highscores.gridx = 0;
        gbc_highscores.gridy = 3;
        panel.add(highscores, gbc_highscores);
        GridBagConstraints gbc_Settings = new GridBagConstraints();
        gbc_Settings.fill = GridBagConstraints.BOTH;
        gbc_Settings.insets = new Insets(0, 0, 5, 0);
        gbc_Settings.gridx = 0;
        gbc_Settings.gridy = 4;
        panel.add(Settings, gbc_Settings);
        JButton Exit = new JButton("ΕΞΟΔΟΣ");
        Exit.setPreferredSize(new Dimension(438, 34));
        Exit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        Exit.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		System.exit(0);
        	}
        });
        
        JButton button = new JButton("ΟΔΗΓΙΕΣ");
        button.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		final JDialog instructions = new JDialog();
        		instructions.setVisible(true);
        		instructions.setSize(800,600);
        		instructions.setTitle("Οδηγίες");
        		JLabel instbox = new JLabel();
        		JLabel instruct = new JLabel("ΟΔΗΓΙΕΣ");
        		instructions.add(instruct,BorderLayout.NORTH);
        		instruct.setFont(new Font("Tahoma", Font.PLAIN, 36));
        		instruct.setPreferredSize(new Dimension(800,75));
        		instruct.setHorizontalAlignment(SwingConstants.CENTER);
        		instbox.setSize(800,570);
        		instbox.setBackground(SystemColor.inactiveCaption);
        		readInstructions(instbox);
        		instructions.add(instbox);
        		instbox.setHorizontalAlignment(SwingConstants.CENTER);
        		instbox.setVerticalAlignment(SwingConstants.NORTH);
        		JButton okb = new JButton("Οκ");
        		okb.addMouseListener(new MouseAdapter(){
        			public void mouseClicked(MouseEvent arg0){
        				instructions.dispose();
        			}
        		});
        		instructions.add(okb, BorderLayout.SOUTH);
        	}
        });
        button.setPreferredSize(new Dimension(438, 34));
        GridBagConstraints gbc_button = new GridBagConstraints();
        gbc_button.fill = GridBagConstraints.BOTH;
        gbc_button.insets = new Insets(0, 0, 5, 0);
        gbc_button.gridx = 0;
        gbc_button.gridy = 5;
        panel.add(button, gbc_button);
        
        GridBagConstraints gbc_Exit = new GridBagConstraints();
        gbc_Exit.fill = GridBagConstraints.BOTH;
        gbc_Exit.gridx = 0;
        gbc_Exit.gridy = 6;
        panel.add(Exit, gbc_Exit);
        
        settingswindow.rdbtnSound.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0){
        		if(settingswindow.play) {
        			settingswindow.play = false; 
        			 clip.close();
        			
        			}
        		else{
        			settingswindow.play = true;
        			try {
        				try {
							stream = AudioSystem.getAudioInputStream(soundf);
						} catch (UnsupportedAudioFileException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
        	            format = stream.getFormat();
        	            info = new DataLine.Info(Clip.class, format);
        	            clip = (Clip) AudioSystem.getLine(info);
        	            clip.open(stream);
        	            clip.loop(Clip.LOOP_CONTINUOUSLY);
					} catch (LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		}
        			
        		
        	}
        });
        settingswindow.rdbtnLowx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				if(settingswindow.x == 800){
					settingswindow.x=1024;
					settingswindow.y=768;
					init.setSize(settingswindow.x,settingswindow.y);
		    		 init.revalidate();
					
				}
				else{
					settingswindow.x=800;
					settingswindow.y=600;
					init.setSize(settingswindow.x,settingswindow.y);
		    		 init.revalidate();
				}
				
			
			}
		});
        
        init.repaint();
        init.revalidate();
        try {
            stream = AudioSystem.getAudioInputStream(soundf);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch (Exception e) {
            //whatevers
        }
        
        
       
      
       
    }
    /*Η παρακάτω μέθοδος επιστρέφει το κύριο μενού στην αρχική του κατάσταση, όπως αυτή ορίζεται στην παραπάνω μέθοδο.
     * Με άλλα λόγια, επιστρέφει στο αρχικό μενού. 
     */
	public void backtomenu(JFrame frame, JPanel panel, int x, int y) {
	
	 frame.getContentPane().removeAll();
	 frame.getContentPane().setLayout(new FlowLayout());
	 frame.getContentPane().add(panel, null);
	 panel.setSize(x,y);
	 frame.repaint();
	 frame.revalidate();
	 time.time.stop();
	}
	/* Η παρακάτω μέθοδος αλλάζει τα περιεχόμενα του κυρίου παραθύρου με αυτά του επιλεγμένου είδους παιχνιδιού.
	 * Η παράμετρος x ορίζει το επιλεγμένο είδος παιχνιδιού.
	 */
	public void startgame(int x) {
	if(x==1) {
		final Classicframe startclassic = new Classicframe();
		final JPanel classiccp = startclassic.contentPane;
	 init.getContentPane().removeAll();
	 init.getContentPane().setLayout(new BorderLayout());
	 init.getContentPane().add(classiccp, BorderLayout.CENTER);
	 init.revalidate();
	 init.repaint();

	 time.start();
	}
	else if(x==2){
		final BeatTheTimeframe startbtt = new BeatTheTimeframe();
		final JPanel bttcp = startbtt.contentPane;
	 init.getContentPane().removeAll();
	 init.getContentPane().setLayout(new BorderLayout());
	 init.getContentPane().add(bttcp, BorderLayout.CENTER);
	 init.revalidate();
	 init.repaint();
	 
	 time.start();
	}

}
	// Μέθοδος που δημιουργεί παράθυρο διαλόγου που αφορά τις οδηγίες, και τοποθετεί το περιεχόμενο του αρχείου στο 
	//οποίο περιέχονται αυτές.
	
	public static void readInstructions(JLabel instbox) {
	
	File inst = new File("src/quiz/instructions.txt");
	Scanner s = null;
	try {
		s = new Scanner(inst);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	instbox.setText(s.useDelimiter("\\Z").next());
	
	
}
}
   



    


	
	




 

