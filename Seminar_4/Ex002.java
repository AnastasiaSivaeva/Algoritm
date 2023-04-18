package Seminar_4;

public class Ex002 {
    public static void main(String[] args){
        RedBlackTree tree = new RedBlackTree();
        tree.add(5);
        tree.add(10);
        tree.add(12);
        tree.add(4);
        tree.add(1);
        tree.print();

    }
}

enum Color {
    RED,
    BLACK,
    NONE
}

class Node{
  public  int value;
  public Color color;
  public Node leftChild;
  public Node rightChild;

}

class RedBlackTree{
    Node root;
    public boolean add(int value){
        if(root != null){
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        }else{
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }
    
    public boolean addNode (Node node, int value){
        if(node.value == value){
            return false;
        } else{
            if (node.value > value){
                if(node.leftChild != null){
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else{
                    node.leftChild = new Node();
                    node.leftChild.color = Color.RED;
                    node.leftChild.value = value;
                    return true;
                }
            }else {
                if(node.rightChild != null){
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                }else{
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }
    
    public Node rebalance(Node node){
        Node result = node;
        boolean needRebalance;
        do{
            needRebalance = false;
            if(result.rightChild != null && result.rightChild.color == Color.RED && result.leftChild == null || result.leftChild.color == Color.BLACK){
                needRebalance = true;
                result = rightSwap(result);
            }
            if(result.leftChild != null && result.leftChild.color == Color.RED && result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED){
                needRebalance = true;
                result = leftSwap(result);
            }
            if(result.leftChild != null && result.leftChild.color == Color.RED && result.rightChild != null && result.rightChild.color == Color.RED){
                needRebalance = true;
                colorSwap(result);
            }
        }
        while(needRebalance);
        return result;
    }
    
    public Node rightSwap(Node node){
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }
    
    public Node leftSwap(Node node){
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }
    
    public void colorSwap(Node node){
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }

    public void print(){
        this.print();
    }

}

