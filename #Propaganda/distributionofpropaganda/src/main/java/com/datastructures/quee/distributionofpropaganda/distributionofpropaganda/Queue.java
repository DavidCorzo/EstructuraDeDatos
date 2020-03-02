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

    public boolean removed(String name) {
        Node thisNode = this.root;
        Node prevNode = null;

        boolean chckeck = false;
        while (thisNode.getNextNode() != null) {
            if (thisNode.getData().getName().equals(name)) {
                prevNode.setNextNode(thisNode.getNextNode());
                this.setSize(this.getSize()-1);
                chckeck = true;
            }
            System.out.println(chckeck);
            prevNode = thisNode;
            thisNode = thisNode.getNextNode();
        }
        return chckeck;
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
