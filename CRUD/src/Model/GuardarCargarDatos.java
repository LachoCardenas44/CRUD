package Model;

import java.io.*;

import java.util.ArrayList;

public class GuardarCargarDatos {

    

    public static void Guardar (ArrayList<Usuario> usuarios) throws FileNotFoundException,IOException{
        
        File route = new File("CRUD/src/Archivos/UsersRecord.txt");
        FileOutputStream saveFile = new FileOutputStream(route);
        ObjectOutputStream saveData = new ObjectOutputStream(saveFile);
        int amount = usuarios.size();
        saveData.writeInt(amount);
    
    for(int i=0;i<amount;i++){
        saveData.writeObject(usuarios.get(i));
        
    }
    saveData.close();
}
    public static ArrayList<Usuario> Cargar() throws ClassNotFoundException,IOException {
        File route = new File("CRUD/src/Archivos/UsersRecord.txt");
        FileInputStream loadFile = new FileInputStream(route);
        ObjectInputStream loadData = new ObjectInputStream(loadFile);

        

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        int amount = loadData.readInt();

        for(int i = 0;i<amount;i++){
            Usuario newUser = (Usuario)loadData.readObject();
            usuarios.add(newUser);
        }
       
       loadData.close();
        return usuarios;

    }
}
