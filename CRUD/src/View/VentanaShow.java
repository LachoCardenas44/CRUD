package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import Model.GuardarCargarDatos;
import Model.Usuario;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import java.awt.*;


public class VentanaShow extends JFrame  {
    private Image image;
    private ShowingPanel panel;
    public VentanaShow(){
        


        setBounds(200, 100, 400, 400);

        setResizable(false);

        setTitle("Ku Klux Klan Showing Window");

        setDefaultCloseOperation(HIDE_ON_CLOSE);

        panel = new ShowingPanel();

        add(panel);
        
        setVisible(true);

        try{
            image = ImageIO.read(new File("CRUD/Emblem.png")); 
        }catch(IOException e){
            System.out.println("La imagen no se encuentra");
        }
        setIconImage(image);
      
    
}
public void CerrarFrame(){
     dispose();
    }
    private class ShowingPanel extends JPanel implements  ActionListener{
    
    
        private JTable table;
        private JScrollPane ScrollPanel;
        private JLabel user ;
        private JButton back;
        private VentanaShow n ;
        ArrayList<Usuario> users = new ArrayList<>(){};
        
        
        public ShowingPanel() {
           
            initComponents();
           
        }
    
        public void initComponents() {
    
    
            try{
                users = GuardarCargarDatos.Cargar();
            }catch(FileNotFoundException g1){
                 users = new ArrayList<>();
                System.out.println("No hay usuarios logeados");
            }catch(IOException g2){
                 users = new ArrayList<>();
                System.out.println(g2.getMessage());
            }catch(ClassNotFoundException g3){
                 users = new ArrayList<>();
                System.out.println(g3.getMessage());
            }
    
            user = new JLabel();
            ScrollPanel = new JScrollPane();
            back = new JButton();
    
            setLayout(null);
            setBackground(new Color(102, 102, 102));
            setForeground(new Color(153, 153, 153));
            setToolTipText("");
            setFont(new Font("Mathematica6", 3, 36));
            setRequestFocusEnabled(false);
    
            user.setFont(new java.awt.Font("Mathematica6", 3, 24)); 
            user.setForeground(new java.awt.Color(204, 0, 0));
            user.setText("USERS");
            user.setBounds(150, 10, 110, 25);
            add(user);
    
    
    
    
            table = new JTable();
                table.setModel(new DefaultTableModel(new String[]{"NAMES"},users.size()){
                    public boolean isCellEditable(int row,int column){
                        return false;
                    }
                });
            String [] names = new String[users.size()];
                for(int j = 0; j<names.length;j++){
                    names[j]=users.get(j).getFullname();
                    
                }
            
            for(int i=0;i<users.size();i++){
                
                table.setValueAt(names[i], i, 0);
               
            }
            
    
           
            back.setForeground(Color.RED);
            back.setBackground(Color.GRAY);
            back.setBounds(320, 320, 60, 40);
            back.setFont(new Font("Mathematica6", 3, 8));
            back.setText("BACK");
            back.addActionListener(this);
            
            ScrollPanel.setViewportView(table);
            ScrollPanel.setBounds(320, 500, 5, 5);;
    
    
            table.setVisible(true);
            table.setBackground(Color.RED.darker().darker());
            table.setForeground(Color.WHITE.darker());
            table.setBounds(80, 40, 235, 310);
    
            add(back);
            add(ScrollPanel);
            add(table);
            add(user);       
            
        
    }
    
       
        public void actionPerformed(ActionEvent e) {
         
            CerrarFrame();
               
        }
    
    
        
        
    }

}
