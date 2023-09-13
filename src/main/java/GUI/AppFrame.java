/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Shivam
 */
// extends jframe class to add implementation according to our project 
// implement actionlistner to track which button was clicked and act accordingly
public class AppFrame extends JFrame implements ActionListener{
    JButton compressButton;
    JButton decompressButton;
    
    AppFrame(){
        this.setTitle("Compressor and Decompressor");
        this.setLayout(null);
        this.setSize(800, 500);
        this.getContentPane().setBackground(Color.BLACK);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        compressButton = new JButton("Select file to compress");
        compressButton.setBounds(110,200,200,50);
        compressButton.setBackground(Color.BLACK);
        compressButton.setForeground(Color.GREEN);
        compressButton.addActionListener(this);
        
        decompressButton = new JButton("Select file to decompress");
        decompressButton.setBounds(470,200,200,50);
        decompressButton.setBackground(Color.BLACK);
        decompressButton.setForeground(Color.GREEN);
        decompressButton.addActionListener(this);
        
        this.add(compressButton);
        this.add(decompressButton);
//        this.setSize(1000,500);
//        this.getContentPane().setBackground(Color.red);
//        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){ 
//override actionListner and is used to perform action on click under compressor and decompressor button
        if(e.getSource()==compressButton){
            JFileChooser filechooser = new JFileChooser("C:");
            int response = filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,e.toString());   
                } 
            }
        }
        if(e.getSource()==decompressButton){
            JFileChooser filechooser = new JFileChooser("C:");
            int response = filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    decompressor.method(file);
                }
                catch(Exception ee){
                     JOptionPane.showMessageDialog(null,e.toString());   
                } 
            }
        }
    }
}
