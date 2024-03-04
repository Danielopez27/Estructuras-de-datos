import java.util.*;

class SinglyLinkedList{
    
    public static void main(String[] args){
        
        try{
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Ingrese la longitud del la lista enlazada: ");
            int length = scanner.nextInt();
        
            

            scanner.close();
    
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }

}



class MySinglyLinkedList<T>{

    private Node<T> head;
    private Node<T> tail;

    static class Node<T>{
        private T key;
        private Node<T> next;

        public Node(T item){
            this.key = item;
            this.next = null;
        }

    }

    public MySinglyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void pushFront(T key){
        Node<T> node = new Node<>(key);

        node.next=head;
        head = node;

        if(tail==null){
            tail=node;
        }
    }

    public T topFront(){
        return head.key;
    }

    public void popFront() throws Exception{
        try{

            if(head==null){
                throw new Exception("popFront invalido. Lista vacia.");
            }else{
                head = head.next;   //Averiguar si es necesario borrar el nodo.
            }

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void pushBack(T key){
        Node<T> node = new Node<>(key);

        if(tail == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }

    }

    public T topBack(){
        return tail.key;
    }

    public void popBack() throws Exception{
        
        try {

            if(head == null){
                throw new Exception("popBack invalido. Lista vacia");
            }
            if(head == tail){
                head = null;
                tail = null;
            }else{

                Node<T> temp = new Node<>(null);
                temp = head;

                while(temp.next.next != null) {
                    temp = temp.next;
                }

                temp.next = null;
                tail = temp;

            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Boolean Find(T key){
        boolean notFind = true;
        Node<T> node = new Node<>(null);
        
        node = head;

        while(notFind) {
            if(node.key == key){
                notFind=false;
            }
        }

        return !notFind;
    }

    public void erase(T key){
        
    }


}
