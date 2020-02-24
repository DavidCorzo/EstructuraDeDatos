package com.datastructures.playlist.Playlist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class LinkedList {
    static LinkedList Master = new LinkedList();
    Node head; // the first element
    static Node now_playing = new Node();

    static class Node {
        String data;
        Node next;
        Node prev;

        Node() {
            this.prev = null;
            this.next = null;
        }

        Node(String data) {
            this.prev = null;
            this.data = data;
            this.next = null;
        }

        public String getData() {
            return data;
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    public static String insert(@RequestParam String data) {
        Node newNode = new Node(data);

        if (Master.head == null) {
            Master.head = newNode;
        } else {
            Node last = Master.head; // empezamos desde el head
            while (last.next != null) {
                last = last.next; // encontramos el último elemento
            }
            newNode.prev = last; // el nuevo nodo es anexado a el data de last
            last.next = newNode; // el puntero de next en last apunto al nuevo nodo
            newNode.next = null; // redundante pero entendible

        }
        return newNode.getData() + " has been added to the playlist";
    }

    @RequestMapping("/play")
    @ResponseBody
    public static String play(@RequestParam String song) {
        Node current = Master.head; // start at the beggining

        boolean founded = false;
        while (current != null) {
            if (current.data.equals(song)) {
                now_playing = current;
                founded = true;
                System.out.println(song);
                break;
            }
            current = current.next;
        }

        String s = new String("");
        if (founded) { // means it's in the list
            s = s + now_playing.data + " is now playing";
        } else {
            s = "Song not found.";
        }

        return s;
    }


    @RequestMapping("/next")
    @ResponseBody
    public static String playNext() {
        String s = new String("");

        if (now_playing == null) {
            now_playing = Master.head;
            s = "List is empty";
        } else {
            now_playing = now_playing.next;
            if (now_playing == null) {
                s = "No next song is available";
            } else {
                s = "Now playing: " + now_playing.data;
            }
        }
        return s;
    }

    @RequestMapping("/previous")
    @ResponseBody
    public static String playPrev() {
        String s = new String("");
        if (now_playing == null) {
            now_playing = Master.head;
            s = "Playlist is empty";
        } else {
            now_playing = now_playing.prev;
            if (now_playing == null) {
                s = "No more songs";
            } else {
                s = "Now playing: " + now_playing.data;
            }
        }
        return s;
    }

    @RequestMapping("/print")
    @ResponseBody
    public static String printList() {
        Node current = Master.head;
        String s = "";

        int counter = 1;
        while (current != null) {
            s = s + "Song: [" + counter + "]: " + current.getData() + "\n";
//            System.out.println(s);
            current = current.next;
            counter ++;
        }
        if (counter == 1) {
            s = "Playlist is empty";
        }
        return s;
    }
}