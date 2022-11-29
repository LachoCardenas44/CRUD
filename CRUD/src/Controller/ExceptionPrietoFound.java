package Controller;

public class ExceptionPrietoFound extends Exception{

    public ExceptionPrietoFound(){
        super("Cadena De Caracteres Invalida");
    }
    public ExceptionPrietoFound(String message){

        super(message);
    
}
}