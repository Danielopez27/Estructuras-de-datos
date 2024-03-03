import java.util.*;

public class Stack{

    public static void main(String[] args){
        
        try{
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese la longitud de la pila: ");
            int length = scanner.nextInt();

            MyStack<String> pila = new MyStack<>(length);
            
            System.out.println("Ingrese elementos para al pila: ");
            
            String word;

            
            while(!pila.full()){
                word = scanner.next();
                pila.push(word);
            }
            
            for(int j=0; j<length; j++){
                System.out.println(pila.pop());
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        



    }

}




class MyStack<T>{

    private static final int defaultNumber = 5; 
    private int top;
    private T[] list;


    public MyStack(){
        this(defaultNumber);
    }

    public MyStack(int length){
        top=0;
        list = (T[])new Object[length];
    }
        
    public boolean empty(){
        return top == 0;
    }

    public boolean full(){
        return top >= list.length;
    }

    public T pop() throws Exception{
        if(empty()){
            throw new Exception("Stack vacia");
        }

        top--;
        return list[top];
    }

    public void push(T item) throws Exception{
        if(full()){
            throw new Exception("Stack llena");
        }
        
        list[top] = item;
        top++;
    }

    

}