package Seminar_3;


public class Ex001 {
    public static void main(String[] args){
        MyList li = new MyList();
        li.add(10);
        li.add(4);
        li.add(7);
        li.add(125);
        li.add(6);
        li.print();
        System.out.println("__________");
        li.revert();
        li.print();
    }
}   

class Node{
    public int value;
    public Node next;
    public Node previous;
}
 
class MyList{
    Node head;
    Node tail;
    public void push( int value){
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previous = node;
        head = node;
    }
    
    public Integer peek(){
        Integer result = null;
        if(tail != null){
            result = tail.value;
            tail.previous.next = null;
            tail = tail.previous;
    
        }
        return result;
    }

    public void add(int value){
        Node node = new Node();
        node.value = value;
        if(head == null){
            head = node;
            tail = node;
        } else{
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }
    
    public void revert(){
        Node currentNode = head;
        while (currentNode != null){
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if(previous == null){
                tail = currentNode;
            }
            if(next == null){
                head = currentNode;
            }
            currentNode = next;
    
        }
    
    }

    public void print(){
        this.print(this.head);
    }

    private void print(Node current){
        if(current != null){
            System.out.println(current.value);
            print(current.next);
        }
    }
}
