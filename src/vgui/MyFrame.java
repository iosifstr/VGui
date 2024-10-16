/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vgui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class MyFrame extends JFrame implements ActionListener{
    // Κανω extend (κληρονομω) το JFrame γιατι θελω να φτιαξω ενα frame (παραθυρο)
    // για την εφαρμογη μου. Ειδ'αλλως θα μπορουσα απλα να φτιαξω ενα
    // JFrame και μετα να το αλλαζα οπως εβρισκα fit. 
    // Κανω implement τον ActionListener - Ο ActionListener ειναι μια
    // διεπαφη (interface). Τα interfaces ειναι μια σουμα μεθοδων
    // που απαξ και δεσμευτουμε να τις υλοποιησουμε , μεχρι και ο 
    // compiler θα μας εχει στη μπουκα. Χρησιμοποιουνται για να ειμαστε
    // σιγουροι πως υλοποιουμε ολες τις απαραιτητες μεθοδους για μια λειτουργικοτητα
    
    String[] filename = new String[1]; // Filename
    // Επειδη δεν μπορουμε να εχουμε pointers στην Java, δυναται να χρησιμοποιησουμε
    // πινακες, οι οποιοι στην Java εχουν την ιδιοτητα πως οπως αλλαξουν μεσα σε μια
    // συναρτηση (σε τοπικη εμβελεια δηλαδη), θα αλλαξουν και globally
   
    JLabel label1, label2, label3, label4; // Ετικετες
    JLabel label5; 
    JTextArea area; // Μεγαλο οοοου για γραψιμο
    JTextField tf1, tf2, tf3; // Μικρο για γραψιμο
    JButton but1, but2, but3; // μπι
    JMenu menu; JMenuBar bar; JMenuItem file; // Μενουδακι πανω πανω κατω απο τιτλο
    public MyFrame(){
        filename[0] = "a"; // Default τιμη για να ξερουμε αν εχει φορτωθει κατι
        
        // Step 1. Orizoume ta zhtoumena components sth basikh tous morfh
        but1 = new JButton("SAVE");
        but1.addActionListener(this);
        // Επειδη εχουμε κανει implement στην κλαση μας τον ActionListener ως διεπαφη
        // μπορουμε να αναφερθουμε στο ιδιο το αντικειμενο MyFrame να ακουει
        // τις υποπτες μας κινησεις
        but2 = new JButton("LOAD");
        but2.addActionListener(this);
        but3 = new JButton("CLEAR");
        but3.addActionListener(this);
        but2.addActionListener(this);
        but3.addActionListener(this);
        tf1 =  new JTextField(8); // pixels?
        tf2 =  new JTextField(8);
        tf3 =  new JTextField(8);
        
        label1 = new JLabel("SIGA:");
        label2 = new JLabel("SIGB:");
        label3 = new JLabel("SIGQ:");
        label4 = new JLabel("FN:");
        label5 = new JLabel("");
        
        area = new JTextArea();
        
        bar = new JMenuBar();
        menu = new JMenu("File");
        file = new JMenuItem("Choose File");
        menu.add(file);
        bar.add(menu);
        this.setJMenuBar(bar);
        file.addActionListener(this);
        // Προσθετω στο Menu το MenuItem, στο MenuBar το Menu, και κανω setJMenuBar
        // για να κολλησει στο παραθυρακι μου
        
        JPanel Panel1 = new JPanel(); // Boreio panel
        Panel1.setLayout(new FlowLayout(FlowLayout.LEFT)); // Ftiaxe layout
        // Ουσιαστικα μας λεει πως ειναι διαμορφωμενα τα στοιχεια, με αυτο για 
        // παραδειγμα μπορουμε να εχουμε left-aligned στοιχεια :) -
        // Οριζετο εξ αυτου ουσιαστικα η χωροδιαταξη του ολου παραθυρου μας
        Panel1.add(label1);
        Panel1.add(tf1);
        Panel1.add(label2);
        Panel1.add(tf2);
        Panel1.add(label3);
        Panel1.add(tf3);
        Panel1.add(label4);
        Panel1.add(label5);
        
        JPanel Panel2 = new JPanel();
        Panel2.add(but1);
        Panel2.add(but2);
        Panel2.add(but3);
        
        this.add(area, BorderLayout.CENTER);
        // Αυτος ο διαχειριστης χωροδιαταξης χωριζει το αγαπημενο μας παραθυρο
        // BOREIA NOTIA ANATOLIKA DYTIKA & kentro ο,τι απομεινει :)
        this.add(Panel1, BorderLayout.NORTH);
        this.add(Panel2, BorderLayout.SOUTH);
        
        // DIAMORFWSH PARATHYROU
        this.setSize(800, 600);
        this.setTitle("VHDL TB_MAIN_BODY_GEN");
        this.setLocationRelativeTo(null); // Αυτο λεει πως θα κανουν spawn in
        // στο κεντρο
        
        this.setVisible(true);
        // Edw mporoume na kanoume windowadapter gia na xrhsh mono exit
        // Κανονικα θελουμε WindowListener, αλλη μια διεπαφη. Αυτη η διεπαφη
        // ομως, οταν θελουμε να χρησιμοποιησουμε ας πουμε 1-2 μεθοδους
        // αυτη μας αναγκαζει να υλοποιησουμε ποσες και ποσες. Αυτος ο κακος
        // λογος δεοντων ενεργειων και χρησιμοτητας την καθιστα fat interface
        // γιατι το παιρνει λιγο καπιταλα το θεμα
        this.addWindowListener(new 
        WindowAdapter(){
            // Προκειμενου να το κανουμε ομως αυτο που θελουμε, μπορουμε
            // να χρησιμοποιησουμε ενα WindowAdapter του οποιου μπορουμε να
            // κανουμε override (να αλλαξουμε δηλαδη στη παιδι WindowAdapter
            // μεθοδους της WindowListener) οσες και οποιες μεθοδους θελουμε
            // χωρις να γραφουμε το Χριστο και τη μανα του
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0); // ριπ προγραμμα :(
            }
        });
    }
    void save(){
        BufferedWriter outwards = null; 
        // Η Java εχει κολλημα με το αν πας να γραψεις σε ή αν διαβασεις
        // απο αρχειο. Εδω , ο ΝετΦασολια σου λεει να εκχωρησει την τιμη
        // null στον BufferedWriter μας ετσι ωστε να υπαρχει ως μεταβλητη
        // γενικα
        try {
            Scanner scanner; 
            int ch = 0;
            // Η μεταβλητη ch ειναι ουσιαστικα η επιλογη που θα κανουμε απο το JOptionPane
            // που προκειτο να χρησιμοποιησουμε και θα παιξει ρολο ΜΟΝΟ αν εχουμε φορτωσει
            // ηδη καποιο αρχειο στη μνημη.
            if(filename[0] != "a")
               ch = JOptionPane.showConfirmDialog(null, "Do you want to save to the chosen file?", "Warning", JOptionPane.YES_NO_OPTION);
            // Το JOptionPane ουσιαστικα μπορει να μας βγαλει τα κλασικα pop-up παραθυρακια του τυπου
            // "Yes-No" , "Yes-No-Cancel", "OK", και παει λεγοντας. Μπορουμε επειτα, εκχωρωντας ενα
            // JOptionPane σε μια ακεραια μεταβλητη να λαβουμε την τιμη που αντιστοιχει στην επιλογη
            // του χρηστη και να παιξουμε με αυτην οπως θελουμε
            String text = area.getText(); // Ο σκαννερ δεν δεχεται JTextArea οποτε μετατρεπουμε τα
            // υπαρχοντα περιεχομενα του area (του JTextArea μας δηλαδη) σε String για να παιξει
            // μπαλα ο σκαννερ
            if(filename[0].equals("a") || ch == JOptionPane.NO_OPTION){
                System.out.println("START");
                StringBuilder line = new StringBuilder();
                // Ο StringBuilder μας επιτρεπει να κανουμε ακραιες συνδεσεις μεταξυ διαφορων
                // αλφαριθμητικων με τη χρηση της μεθοδου append(-string-), η οποια μαλιστα
                // μπορει να χρησιμοποιηθει αλυσιδωτα π.χ. line.append("A").append("B").append("C")
                line.append(label1.getText()).append("<=").
                        append(tf1.getText()+";")
                        .append(" " + label2.getText()).
                        append("<=").append(" ")
                        .append(tf2.getText() + "; ").
                        append(label3.getText()).
                        append("<=")
                        .append(tf3.getText()+";!\n")
                        ;
                area.append(line.toString()); // Τo JTextArea εχει την μεθοδο append που
                // οπως υποδηλωνει και το ονομα , 
            }
            if(filename[0] != "a" && ch == JOptionPane.YES_OPTION){            
                scanner = new Scanner(text);
                outwards = new BufferedWriter(new FileWriter(filename[0]));
                FileWriter poutwards = new FileWriter(filename[0]);
                while(scanner.hasNext()){
                    String line12 = scanner.nextLine();
                    System.out.println(line12);
                    outwards.write(line12 + '\n');
                    outwards.flush();
                }
                outwards.close();

            }
        } catch (IOException ex) {
            Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.out.println("");
        }
    }
    // Gia na kanoume ton xava mas me apothikeysh arxeiwn, ua prepei na aksiopoihsoume
    // ton JFileChooser!
    
    void chooseFile(String[] filename){
        JFileChooser choose = new JFileChooser();
        int retVal = choose.showOpenDialog(this); // showOpenDialog = anoikse parathyri gia anazhthsh arxeiou
        // showSaveDialog = parathyri apothykeyshsh
        if(retVal == JFileChooser.APPROVE_OPTION){
        filename[0] = choose.getSelectedFile().getAbsolutePath();
        System.out.println(filename[0]);
        label5.setText(choose.getSelectedFile().getName());
        }
        // tsimpa to file pou dialekse o xrhsths
        // kai pare to onoma tou file
    } 
    void clear(){
        area.setText("");
    }
    void load(){
        if(filename[0].equals("a")){
            System.out.println("Tough luck...");
        } 
        else{
        
            try {
                Scanner scanner = new Scanner(new FileReader(filename[0]));
                clear();
                String hi;
                StringBuilder liner = new StringBuilder(); // ua to baloume olo mazi meta opote an theloume
                // souma bazoume StringBuilder
                while(scanner.hasNext()){
                    hi = scanner.nextLine();
                    liner.append(hi+'\n');
                }
                area.setText(liner.toString());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(file)){
         System.out.println("File has been pressed");
         chooseFile(filename);
         System.out.println("GATI: " + filename[0]);
    }  
    if(e.getSource().equals(but1)){
        save();
    }
    if(e.getSource().equals(but2)){
        load();
    }
    if(e.getSource().equals(but3)){
        clear();
    }
    // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
   
   
}
