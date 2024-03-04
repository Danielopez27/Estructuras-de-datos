import java.util.*;

class Queue{
    public static void main(String[] args){
        try{
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese la longitud de la cola: ");
            int length = scanner.nextInt();

            MyQueue<String> cola = new MyQueue<>(length);

            System.out.println("Ingrese los elementos de la queue: ");

            while(!cola.full()){
                String word = scanner.next();
                cola.enqueue(word);
            }

            while(!cola.empty()) {
                System.out.println(cola.dequeue());
            }



            scanner.close();

        
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}


class MyQueue<T>{
    
    private int length;
    private int count;
    private int top;
    private int rear;
    private T[] list;
    
    public MyQueue(){
        this(5);
    }

    public MyQueue(int length){
        this.length = length;
        count = 0;
        top = 0;
        rear = 0;
        list = (T[])new Object[length];
    }

    public boolean full(){
        return count >= length;
    }

    public boolean empty(){
        return count <=0;
    }

    public void enqueue(T item) throws Exception {
        if(full()){
            throw new Exception("Queue llena.");
        }
        
        list[rear]= item;
        rear = (rear+1) % length;
        count++;
    }

    public T dequeue() throws Exception {
        if(empty()){
            throw new Exception("Queue vacia.");
        }

        T item = null;

        item = list[top];
        top = (top+1) % length;
        count--;

        return item;
    }

}