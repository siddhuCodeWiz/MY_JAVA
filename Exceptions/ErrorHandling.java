package Exceptions;

public class ErrorHandling {
    public static void main(String[] args) {
        
    }
    public int divide(int num, int denom){
        if(denom==0){
            throw new ArithmeticException("Divide by zero exception");
        }
        else{
            return num/denom;
        }
    }
}
