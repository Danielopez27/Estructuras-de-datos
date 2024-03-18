package Ejercicios;

import java.util.Scanner;

class PrintingTime {

    public static void main(String[] args){

        try {

            Scanner scanner = new Scanner(System.in);
    
            int minutes;
            int cases = scanner.nextInt();
            
            for(int i=0; i<cases; i++){
                int length = scanner.nextInt();
                int index = scanner.nextInt();
                minutes = 0;

                if(length != 0){

                    MyQueue queue = new MyQueue(length);
    
                    for (int j=0; j<length; j++) {
                        int item = scanner.nextInt();
                        queue.enqueue(item);
                    }
    
                    boolean printed = false;
    
                    int max = queue.max();
    
                    while (!printed){
                        
                        int toPrint = queue.dequeue();
    
                        if(toPrint == max){
                            
                            if(!queue.empty()){
                                max = queue.max();
                            }
                            
                            minutes++;
                            length--;
    
                            if(index==0){
                                printed = true;
                            }
    
                        }else{
                            queue.enqueue(toPrint);
                        }
    
                        index--;
                        if(index<0){
                            index=length-1;
                        }
    
                    }
                    
                }


                System.out.println(minutes);
            }


            scanner.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }
    
}





class MyQueue{
    
    private int length;
    private int count;
    private int top;
    private int rear;
    private int[] list;
    
    public MyQueue(){
        this(5);
    }

    public MyQueue(int length){
        this.length = length;
        count = 0;
        top = 0;
        rear = 0;
        list = new int[length];
    }

    public boolean full(){
        return count >= length;
    }

    public boolean empty(){
        return count <=0;
    }

    public void enqueue(int item) throws Exception {
        if(full()){
            throw new Exception("---------- .enqueue() invalido. Queue llena ----------");
        }
        
        list[rear]= item;
        rear = (rear+1) % length;
        count++;
    }

    public int dequeue() throws Exception {
        if(empty()){
            throw new Exception("---------- .dequeue() invalido. Queue vacia ----------");
        }

        int item;

        item = list[top];
        top = (top+1) % length;
        count--;

        return item;
    }

    public int max() throws Exception{
        if(empty()){
            throw new Exception("---------- .dequeue() invalido. Queue vacia ----------");
        }

        int max=0;
        int i = top;
        int cycle = 0;

        while(cycle == 0){
            if(max < list[i]){
                max = list[i];
            }

            i = (i+1)%length;

            if(i==rear){
                cycle++;
            }

        }

        return max;
    }


}