package Ejercicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Scanner;

/**
 * WeirdText
 */
class WeirdText {

    public  static void main(String[] args){

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            //Scanner scanner = new Scanner(System.in);

            String line = "";

            MySinglyLinkedList linkedList = new MySinglyLinkedList();

            while (line.compareTo("EOF") != 0) {
                
                //line = scanner.nextLine();
                line = reader.readLine();

                boolean end = true;

                StringBuilder weirdText = new StringBuilder();


                for(int i=0; i<line.length(); i++){

                    if(line.charAt(i) == '[' || line.charAt(i) == ']'){

                        if(line.charAt(i) == '['){

                            if(end == true){
                                linkedList.pushBack(weirdText);
                            }else{
                                linkedList.pushFront(weirdText);
                            }
            
                            end = false;
    
                            weirdText.delete(0, weirdText.length());
    
                        }
                        if(line.charAt(i) == ']'){
    
                            if(end == true){
                                linkedList.pushBack(weirdText);
                            }else{
                                linkedList.pushFront(weirdText);
                            }
            
                            end = true;
    
                            weirdText.delete(0, weirdText.length());
    
                        }

                    }else{

                        weirdText.append(line.charAt(i));

                    }

                }

                if(line.compareTo("EOF") != 0){

                    if(end == true){
                        linkedList.pushBack(weirdText);
                    }else{
                        linkedList.pushFront(weirdText);
                    }
                }

    
            }



            StringBuilder weirdText = new StringBuilder();

            weirdText = linkedList.weirdText();

            System.out.println(weirdText.toString());


    
            //scanner.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }


    }
    
}






class MySinglyLinkedList{

    private Node head;
    private Node tail;

    static class Node{
        private String key;
        private Node next;

        public Node(StringBuilder item){
            this.key = item.toString();
            this.next = null;
        }

        public Node(String item){
            this.key = item;
            this.next = null;
        }

    }

    public MySinglyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void pushFront(StringBuilder key){
        Node node = new Node(key);

        node.next=head;
        head = node;

        if(tail==null){
            tail=node;
        }
    }

    public void pushBack(StringBuilder key){
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
        
        Node node = new Node("");

        node = head;

        while (node != null) {
            solution.append(node.key);
            node = node.next;
        }

        return solution;
    }


}