package View;

import Model.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class VentanaLogin extends JFrame{

    private Image image;
    public VentanaLogin(){

        setBounds(400, 200, 400, 370);

        setResizable(true);

        setTitle("White > Black");

        PanelLogin plogin = new PanelLogin();
        
        add(plogin);

        setDefaultCloseOperation(HIDE_ON_CLOSE);

        setVisible(true);

        try{
            image = ImageIO.read(new File("CRUD/Emblem.png")); 
        }catch(IOException e){
            System.out.println("La imagen no se encuentra");
        }

       setIconImage(image);

    }
    private class PanelLogin extends JPanel implements ActionListener{

    
        private JButton done;
        private JLabel name;
        private JLabel password;
        private JTextField namefield;
        private JPasswordField passwordfield;
        private String nombre ;
        private char[] contrasenna;
        private Image image;
        ArrayList <Usuario> usuarios;
        public PanelLogin (){
            
            onitComponents();
    
        }
    
        public void onitComponents(){
    
            name = new JLabel();
            namefield = new JTextField();
            password = new JLabel();
            passwordfield = new JPasswordField();
            done = new JButton();
    
            
            setLayout(null);
    
            name.setFont(new java.awt.Font("Mathematica6", 1, 24)); 
            name.setForeground(new java.awt.Color(204, 0, 0));
            name.setText("Full Name");
            add(name);
            name.setBounds(140, 20, 110, 25);
    
            namefield.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); 
            namefield.setForeground(new java.awt.Color(204, 0, 0));
            namefield.setToolTipText("");
            add(namefield);
            namefield.setBounds(40, 60, 310, 26);
    
    
            password.setFont(new java.awt.Font("Mathematica6", 1, 24));
            password.setForeground(new java.awt.Color(204, 0, 0));
            password.setText("Password");
            add(password);
            password.setBounds(140, 120, 120, 25);
    
            passwordfield.setFont(new java.awt.Font("Segoe UI", 0, 18));
            passwordfield.setForeground(new java.awt.Color(153, 0, 0));
            passwordfield.setToolTipText("");
            add(passwordfield);
            passwordfield.setBounds(40, 170, 310, 31);
    
            done.setBackground(new java.awt.Color(102, 102, 102));
            done.setFont(new java.awt.Font("Mathematica6", 3, 24)); 
            done.setForeground(new java.awt.Color(255, 0, 0));
            done.setText("DONE");
            done.setToolTipText("");
            done.setBorder(BorderFactory.createLineBorder(new Color(204, 0, 0), 4));
            add(done);
            done.setBounds(110, 253, 170, 30);
            done.addActionListener(this);
            
    
        }
    
    
        
        public void actionPerformed(ActionEvent e) {
            try{
                usuarios = GuardarCargarDatos.Cargar();
          }catch(ClassNotFoundException g1){
             usuarios = new ArrayList<Usuario>();
              System.out.println(g1.getMessage());
          }catch(IOException g2){
            usuarios = new ArrayList<Usuario>();
            System.out.println(g2.getMessage());
          }
            
             Usuario usuario = new Usuario(namefield.getText(), passwordfield.getPassword());
             if(usuario.getFullname().isEmpty()){

             }else{
                usuarios.add(usuario);
            try{
                GuardarCargarDatos.Guardar(usuarios);
    
            }catch(IOException o){
                System.out.println(o.getMessage());
            }

             }
            
           
            CerrarFrame();
            
        }
            
        
        
        public String getNombre (){
            return nombre;
        }
    
        public char[] getContrasenna (){
            return contrasenna;
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            try{
                image = ImageIO.read(new File("CRUD/src/Archivos/kkk2.jpg")); 
            }catch(IOException e){
                System.out.println("La imagen no se encuentra");
            }
            
            g.drawImage(image, 0, 0, null);
            
        }
     
    }
    public void CerrarFrame(){
        dispose();
       }

}
