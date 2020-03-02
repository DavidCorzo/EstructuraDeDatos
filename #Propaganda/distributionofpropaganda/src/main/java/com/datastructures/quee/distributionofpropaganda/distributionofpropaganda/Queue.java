package com.datastructures.quee.distributionofpropaganda.distributionofpropaganda;

public class Queue {
    Node root;
    Node first_content;
    int size;

    Queue(){
        this.root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node getRoot() {
        return root;
    }

    public Node add(WorkerData data){
        Node newNode = new Node(data,this.root);
        this.root = newNode;
        this.size++;
        if (this.size == 1) {
            this.first_content = newNode;
        }
        return newNode;
    }

    public String dequeue_clear() {
        this.root = null;
        this.root.nextNode = null;
        return "removed succesfully;";
    }

    public String print(){
        Node current = this.root;
        String s = new String("");
        while (current.getNextNode() != null) {
            s = s + getData(current.data) + "\n";
            current = current.getNextNode();
        }
        return s;
    }

    public String getData(WorkerData obj) {
        return  "\nName: " + obj.getName() +
                "\nEntity: " + obj.getEntity_anounced() +
                "\nSocial Security: " +  obj.getSocial_security() +
                "\nDays Worked: " + obj.getTotal_days_worked();
    }

    public boolean removed(WorkerData obj) {
        Node thisNode = this.root;
        Node prevNode = null;

        while (thisNode != null) {
            if (thisNode.equals(obj)) {
                prevNode.setNextNode(thisNode.getNextNode());
                this.setSize(this.getSize()-1);
                return true;
            }
            prevNode = thisNode;
            thisNode = thisNode.getNextNode();
        }
        return false;
    }

    public Node find (String name) {
        Node thisNode = this.root;
        while (thisNode != null){
            if (thisNode.getData().getName().equals(name)) {
                return thisNode;
            }
        }
        return null;
    }
}