package com.datastructures.quee.distributionofpropaganda.distributionofpropaganda;


public class Node {
    WorkerData data;
    Node nextNode;

    Node(){}

    Node(WorkerData val){
        this.data = val;
    }

    Node(WorkerData val, Node next){
        this.data = val;
        this.nextNode = next;
    }

    public void setData(WorkerData data) {
        this.data = data;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public WorkerData getData() {
        return data;
    }

    public Node getNextNode() {
        return nextNode;
    }
}