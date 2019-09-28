/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import java.util.Scanner;

/**
 *
 * @author Hasby
 */
public class CreateRGBTable extends JFrame{
    String temp = "";
    public CreateRGBTable(int rgb[][], int h, int w, String m){
        initUI(rgb, h, w, m);
    }
    
    private void initUI(int rgb[][], int h, int w, String m){
        setTitle(m); 
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
        setLayout(null);
        setResizable(false);
        setSize(480, 350);
        setLocationRelativeTo(null);
        
        String column[] = new String[w+1];
        String data[][] = new String[h][w+1];
        
        column[0] = "Pixel";
        for(int i = 0; i < w; i++){
            column[i+1] = String.valueOf(i);
        }
        
        for(int i = 0; i<h;i++){
            data[i][0] = String.valueOf(i);
        }
        
        for(int i = 0; i <w; i++){
            for(int j = 0; j< h; j++){
                temp = String.valueOf(rgb[i*3][j]) + " ," + String.valueOf(rgb[i*3+1][j])+ " ," + String.valueOf(rgb[i*3+2][j]);
                data[j][i+1] = temp;
            }
        }
        
        JTable jt = new JTable(data, column);
        JScrollPane jtp = new JScrollPane();
        
        
        jtp.setBounds(10,10,460,300);           
        jtp.setViewportView(jt);
        jtp.getVerticalScrollBar();
        jtp.getHorizontalScrollBar();
        jt.setAutoResizeMode( JTable.AUTO_RESIZE_OFF);
        
        add(jtp);
        
        
    }
}
