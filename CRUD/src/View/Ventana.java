package View;

import javax.swing.*;
import Model.Usuario;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;





public class Ventana extends JFrame{
    
    
    private Image image;
   

    public Ventana(){

        
        setBounds(200, 100, 700, 400);

        setResizable(false);

        setTitle("Ku Klux Klan Login Window");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Panel panel = new Panel();

        add(panel);
        
        setVisible(true);

        
        try{
            image = ImageIO.read(new File("CRUD/Emblem.png")); 
        }catch(IOException e){
            System.out.println("La imagen no se encuentra");
        }

       setIconImage(image);


        



    }
    
        
    private class Panel extends JPanel implements ActionListener{

        private JTextArea intro;
        private JButton login;
        private JButton showUsers;
        private JButton cerrar;
        private JTextArea titulo;
        private Image image;
        
    
        public Panel (){
    
            initComponents();
    
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            try{
                image = ImageIO.read(new File("CRUD/src/Archivos/kkk1.jpg")); 
            }catch(IOException e){
                System.out.println("La imagen no se encuentra");
            }
            
            g.drawImage(image, 0, 0, null);
            
        }
    
        public void initComponents() {
    
    
    
           
    
            
            cerrar = new JButton();
            titulo = new JTextArea();
            showUsers = new JButton();
            intro = new JTextArea();
            login = new JButton();
    
            setBackground(new Color(102, 102, 102));
            setForeground(new Color(153, 153, 153));
            setToolTipText("");
            setFont(new Font("Mathematica6", 3, 36));
            setRequestFocusEnabled(false);
    
            titulo.setBackground(new Color(51, 51, 51).darker());
            titulo.setColumns(20);
            titulo.setFont(new Font("Mathematica6", 3, 24)); 
            titulo.setForeground(new Color(204, 0, 0));
            titulo.setRows(5);
            titulo.setText("WELCOME TO THE KU KLUX KLAN LOGIN WINDOW \n\n     YOUR MAKING A GOOD THING BY JOINING US");
            titulo.setAutoscrolls(false);
            titulo.setBorder(BorderFactory.createLineBorder(new Color(204, 153, 0), 3)); 
            titulo.setSelectionColor(new Color(51, 51, 51));
            titulo.setEditable(false);
    
            
            intro.setEditable(false);
            intro.setBounds(92, 164, 174, 600);
            intro.setAlignmentX((float) 0.5);
            intro.setAlignmentY((float) 0.5);
            intro.setBackground(new Color(51, 51, 51).darker());
            intro.setColumns(20);
            intro.setFont(new Font("Mathematica6", 3, 18)); 
            intro.setForeground(new Color(204, 0, 0));
            intro.setRows(5);
            intro.setText("                                                    Black lifes matter ?\n                                                    Are they a plague ?\n                                Do they need to be eliminated from Earth ?\n              \n               If you are reading this is because you are having this questions too \n                        JOIN US and lets find a solution to Earth corruption\n       ");
            intro.setBorder(BorderFactory.createLineBorder(new Color(204, 153, 0), 2));
            
    
            login.setBackground(new Color(51, 51, 51));
            login.setFont(new Font("Mathematica6", 3, 48)); 
            login.setForeground(new Color(204, 0, 0));
            login.setText("LOGIN");
            login.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(204, 153, 0)));
            login.addActionListener(this);
    
            showUsers.setBackground(new Color(51, 51, 51));
            showUsers.setFont(new Font("Mathematica6", 3, 48)); 
            showUsers.setForeground(new Color(204, 0, 0));
            showUsers.setText("Show Users");
            showUsers.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(204, 153, 0)));
            showUsers.addActionListener(this);

            cerrar.setBackground(new Color(51, 51, 51));
            cerrar.setFont(new Font("Mathematica6", 3, 48)); 
            cerrar.setForeground(new Color(204, 0, 0));
            cerrar.setText("Close");
            cerrar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(204, 153, 0)));
            cerrar.addActionListener(this);
            
            add(titulo);
            add(intro);
            add(showUsers);
            add(login);
            add(cerrar);
        
        }
    
    
        public void actionPerformed(ActionEvent e) {
    
           if(e.getSource()==login){
            VentanaLogin vlogin = new VentanaLogin();    
            
           }else if(e.getSource()==showUsers){
            VentanaShow vshow = new VentanaShow();
            
           }else{

            dispose();

           }
               
                
            
        } 
        
        
    
            
        }
       
        
        
    
    
    
}
