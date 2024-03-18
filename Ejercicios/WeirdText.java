package Ejercicios;

import java.util.Scanner;

/**
 * WeirdText
 */
public class WeirdText {

    public  static void main(String[] args){

        try {
            
            Scanner scanner = new Scanner(System.in);

            String line = "";
            String reference = "";
            MySinglyLinkedList linkedList = new MySinglyLinkedList();

            while (line.compareTo("EOF") != 0) {
                
                line = scanner.nextLine();
                boolean end = true;

                while (line.contains("[") || line.contains("]")) {
                    
                    if(line.indexOf("[") != -1 && line.indexOf("]") != -1){
                        
                        if(line.indexOf("[") < line.indexOf("]")){
                        
                            reference = line.substring(0, line.indexOf("["));
                            line = line.substring(line.indexOf("[") + 1);         // TODO:puede salirse el index
    
                            if(end == true){
                                linkedList.pushBack(reference);
                            }else{
                                linkedList.pushFront(reference);
                            }
    
                            end = false;
    
                        }
    
                        if(line.indexOf("]") < line.indexOf("[")){
    
                            reference = line.substring(0, line.indexOf("]"));
                            line = line.substring(line.indexOf("]") + 1);       // TODO:puede salirse el index
    
                            if(end == true){
                                linkedList.pushBack(reference);
                            }else{
                                linkedList.pushFront(reference);
                            }
    
                            end = true;
    
                        }

                    }else{

                        if(line.contains("[")){

                            reference = line.substring(0, line.indexOf("["));
                            line = line.substring(line.indexOf("[") + 1);           // TODO:puede salirse el index
    
                            if(end == true){
                                linkedList.pushBack(reference);
                            }else{
                                linkedList.pushFront(reference);
                            }
    
                            end = false;

                        }else{

                            reference = line.substring(0, line.indexOf("]"));
                            line = line.substring(line.indexOf("]") + 1);           // TODO:puede salirse el index
    
                            if(end == true){
                                linkedList.pushBack(reference);
                            }else{
                                linkedList.pushFront(reference);
                            }
    
                            end = true;

                        }

                    }
    
                }

                if(line.compareTo("EOF") != 0){

                    if(end == true){
                        linkedList.pushBack(line);
                    }else{
                        linkedList.pushFront(line);
                    }
                }

    
            }



            StringBuilder weirdText = new StringBuilder();

            weirdText = linkedList.weirdText();

            System.out.println(weirdText.toString());


    
            scanner.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
    
}






class MySinglyLinkedList{

    private Node head;
    private Node tail;

    static class Node{
        private String key;
        private Node next;

        public Node(String item){
            this.key = item;
            this.next = null;
        }

    }

    public MySinglyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void pushFront(String key){
        Node node = new Node(key);

        node.next=head;
        head = node;

        if(tail==null){
            tail=node;
        }
    }

    public void pushBack(String key){
        Node node = new Node(key);

        if(tail == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }

    }

    public boolean empty(){
        return head == null;
    }

    public StringBuilder weirdText(){
        
        StringBuilder solution = new StringBuilder();
        
        Node node = new Node(null);

        node = head;

        while (node != null) {
            solution.append(node.key);
            node = node.next;
        }

        return solution;
    }


}