package Model;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String fullname ;
    private char[] password;

    public Usuario (String fullname,char[] password){

        this.fullname=fullname;
        this.password=password;

    }

    public void setFullname(String fullname){
        this.fullname=fullname;
    }

    public String getFullname(){
        return fullname;
    }

    public void setPassword(char[] password){
        this.password=password;
    }

    public char[] getPassword(){
        return password;
    }
    
    public String toString(){
        return "nombre : "+fullname+" password : "+password.toString();
    }
}
