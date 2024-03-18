import java.util.Scanner;

import java.lang.Math;


class BinarySerchTree{
    
    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(System.in);
    
            System.out.println("Ingrese longitud de arbol: ");
            int length = scanner.nextInt();
            
            MyBinarySerchTree<Integer> arbol = new MyBinarySerchTree<>();

            for(int i = 0; i<length; i++){
                int item = scanner.nextInt();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}








class MyBinarySerchTree<T>{

    private Node<T> tree;


    private class Node<T>{
        private T key;
        private Node<T> left;
        private Node<T> right;

        public Node(T key){
            this.key = key;
            this.left = null;
            this.right = null;
        }

    }

    public MyBinarySerchTree(){
        this.tree = null;
    }

    public int heigth(Node<T> tree){
        if(tree.left == null && tree.right == null){
            return 1;
        }
        if(tree == null){
            return 0;
        }

        return 1 + Math.max(heigth(tree.left), heigth(tree.right));
    }

    public int size(Node<T> tree){
        if(tree.left == null && tree.right == null){
            return 1;
        }
        if(tree == null){
            return 0;
        }

        return 1 + size(tree.left) + size(tree.right);

    }

    public void inOrderTraversal(Node<T> tree){
        if(tree.left == null && tree.right == null){
            return ;
        }
        if(tree == null){
            return ;
        }

        inOrderTraversal(tree.left);
        System.out.println(tree.key);
        inOrderTraversal(tree.right);

    }

    public void preOrderTraversal(Node<T> tree){
        if(tree.left == null && tree.right == null){
            return ;
        }
        if(tree == null){
            return ;
        }

        System.out.println(tree.key);
        inOrderTraversal(tree.left);
        inOrderTraversal(tree.right);

    }

    public void postOrderTraversal(Node<T> tree){
        if(tree.left == null && tree.right == null){
            return ;
        }
        if(tree == null){
            return ;
        }

        inOrderTraversal(tree.left);
        inOrderTraversal(tree.right);
        System.out.println(tree.key);

    }

    public void levelTraversal(Node<T> tree){
        if(tree.left == null && tree.right == null){
            return ;
        }
        if(tree == null){
            return ;
        }

        Node<T> node = new Node<>(null);
        MyQueue<T> cola = new MyQueue<>();  

        while(!cola.empty()){
            
            try {
                node.key = cola.dequeue();
    
                System.out.println(node.key);
    
                if(node.left != null){
                    cola.enqueue(node.left.key);
                }
                if(node.right != null){
                    cola.enqueue(node.right.key);
                }
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


        }

    }


}
