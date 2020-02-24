public class Node {
    Node prev;
    Node next;
    String data;

    Node(){
        this.prev = null;
        this.next = null;
    }

    Node(String data){
        this.prev = null;
        this.data = data;
        this.next = null;
    }


    public void setData(String data){
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }
}

