package com.datastructures.playlist.Playlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void insert() {
        LinkedList obj = new LinkedList();
        assertEquals("00 has been added to the playlist", obj.insert("00"));
    }

    @Test
    void play() {
        LinkedList obj = new LinkedList();
        obj.insert("00");
        obj.insert("01");
        assertEquals("00 is now playing", obj.play("00"));
    }

    @Test
    void playNext() {
        LinkedList obj = new LinkedList();
        obj.insert("00");
        obj.insert("01");
        obj.play("00");
        assertEquals("Now playing: 00", obj.playNext());
    }

    @Test
    void playPrev() {
        LinkedList obj = new LinkedList();
        obj.insert("00");
        obj.insert("01");
        obj.play("01");
        assertEquals("Now playing: 00", obj.playPrev());
    }

    @Test
    void printList() {
        LinkedList obj = new LinkedList();
        obj.insert("00");
        assertEquals("Song: [1]: 00\n", obj.printList());
    }
}