import java.util.Scanner;

public class DynamicArray {
    public static void main(String[] args){

        try{
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Ingrese la longitud del arreglo dinamico: ");
            int length = scanner.nextInt();

            MyDynamicArray<Integer> lista = new MyDynamicArray<>(length);
            
            System.out.println("Ingrese los valores: ");

            for(int i=0; i<length; i++){
                int elemento = scanner.nextInt();
                lista.pushBack(elemento);
            }

            for(int j=0; j<length; j++){
                System.out.println(lista.get(j));
            }

            System.out.println(lista.get(10));

            scanner.close();
        
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}



class MyDynamicArray<T> {

    private int size;
    private int capacity;
    private T[] array;

    public MyDynamicArray(){
        this(5);
    }

    public MyDynamicArray(int length){
        array = (T[]) new Object[length];
        size = 0;
        capacity = length;
    }

    public T get(int index) throws Exception{
        
        if(index < 0 || index >= size){
            throw new RuntimeException("---------- get invalido. Index fuera de rango ----------");
        }

        return array[index];
        
    }

    public void set(int index, T item) throws Exception{
        
        if(index < 0 || index >= size){
            throw new RuntimeException("---------- set invalido. Index fuera de rango ----------");
        }
        array[index] = item;
        
    } 

    public void pushBack(T item){

        if(size == capacity){
            T[] newArray = (T[]) new Object[capacity * 2];
            
            for(int i=0; i < size; i++){
                newArray[i] = array[i];
            }

            array = newArray;
            capacity = capacity*2;
            
        }

        array[size] = item;
        size++;
    }

    public void remove(int index) throws Exception{

        if(index < 0 || index >= size){
            throw new RuntimeException("---------- remove invalido. Index fuera de rango ----------");
        }

        for(int i = index; i < size-1; i++){
            array[i] = array[i+1];
        }

        size--;

    }

    public int size(){
        return size;
    }


}
