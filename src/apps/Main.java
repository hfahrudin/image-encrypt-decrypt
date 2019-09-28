//Main.java
//
package apps;

import java.awt.Color; 
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException; 
import javax.swing.WindowConstants;
import javax.swing.plaf.metal.DefaultMetalTheme; 
import javax.swing.plaf.metal.MetalLookAndFeel; 
import javax.swing.plaf.metal.OceanTheme;

/**
*
* @author ACER
*/
public class Main extends JFrame{
    final static String LOOKANDFEEL = "System"; 
    final static String THEME = "Ocean";
    JButton enk = new JButton("Enkripsi");
    JButton dek = new JButton("Dekripsi"); 
    JLabel judul = new JLabel("Aplikasi Enkripsi Dan Dekripsi Gambar");
    JLabel judul2 = new JLabel("Dengan Algoritma Hybrid Vigenere Dan RSA");
    JLabel nama = new JLabel("Radifan Darari");
    JLabel nim = new JLabel("081511233096");

    public Main(){
        setTitle("Enkripsi Dan Dekripsi Gambar");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(400,220); 
        setLocationRelativeTo(null); 
        
        judul.setBounds(30,10,500,30);
        judul.setFont(new java.awt.Font("Tahoma", 0, 18));
        
        judul2.setBounds(10, 30, 500, 30);
        judul2.setFont(new java.awt.Font("Tahoma", 0, 18));
        
        nama.setBounds(130, 60, 100, 30);
        nama.setFont(new java.awt.Font("Tahoma", 0, 15));
        
        nim.setBounds(130, 80, 100, 30);
        nim.setFont(new java.awt.Font("Tahoma", 0, 15));
        
        enk.setBounds(70,115,100,30); 
        dek.setBounds(190,115,100,30); 
        enk.setFocusable(false);
        dek.setFocusable(false);
        enk.setFont(new java.awt.Font("Tahoma", 0, 16));
        dek.setFont(new java.awt.Font("Tahoma", 0, 16)); 

        add(judul);
        add(judul2);
        add(nama);
        add(nim);
        add(enk);
        add(dek);

        enk.addActionListener((java.awt.event.ActionEvent evt) -> { 
            EnkripFrame ef = new EnkripFrame(this); 
            ef.setVisible(true);
            this.setVisible(false);
        });
        dek.addActionListener((java.awt.event.ActionEvent evt) -> { 
            DekripFrame df = new DekripFrame(this); 
            df.setVisible(true);
            this.setVisible(false);
        });
    }

    public static void initLookAndFeel() { 
        String lookAndFeel;
        if (LOOKANDFEEL != null) {
            if (LOOKANDFEEL.equals("Metal")) {
                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
            } else if (LOOKANDFEEL.equals("System")) {
                lookAndFeel = UIManager.getSystemLookAndFeelClassName();
            } else if (LOOKANDFEEL.equals("Motif")) {
                lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
            } else if (LOOKANDFEEL.equals("GTK")) {
                 lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
            } else {
                System.err.println("Unexpected value of LOOKANDFEEL specified: " + LOOKANDFEEL);
            lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
            }

            try {
                UIManager.setLookAndFeel(lookAndFeel);
                if (LOOKANDFEEL.equals("Metal")) {
                    if (THEME.equals("DefaultMetal")) { 
                        MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
                    }else if (THEME.equals("Ocean")) { 
                        MetalLookAndFeel.setCurrentTheme(new OceanTheme());
                    }else{
                        UIManager.setLookAndFeel(new MetalLookAndFeel());
                    }
                }
            }catch (ClassNotFoundException e) {
                System.err.println("Couldn't find class for specified look and feel:"
                + lookAndFeel);
                System.err.println("Did you include the L&F library in the class path?");
                System.err.println("Using the default look and feel.");
            } catch (UnsupportedLookAndFeelException e) { 
                System.err.println("Can't use the specified look and feel (" + lookAndFeel + ") on this platform."); 
                System.err.println("Using the default look and feel.");
            } catch (IllegalAccessException | InstantiationException e) { 
                System.err.println("Couldn't get specified look and feel (" + lookAndFeel + "), for some reason."); 
                System.err.println("Using the default look and feel.");
            }
        }
    }


    public static void main(String[] args) { 
        initLookAndFeel();
        new Main().setVisible(true);
    }
}
