package com.mad.lib;

import java.util.Random;

public class MyClass {
    public static void main(String... args) {
        Random random = new Random(System.currentTimeMillis());

        MyLinkedList myLinkedList = new MyLinkedList();
        for (int i = 0; i < 10; i++) {
            myLinkedList.add(random.nextInt(20));
        }

        printPointer(myLinkedList.getHead());

        MyLinkedList[] lists = getLists(myLinkedList.getHead());

        printPointer(lists[0].getHead());
        printPointer(lists[1].getHead());

    }

    public static MyLinkedList[] getLists(Pointer pointer) {
        MyLinkedList[] output = new MyLinkedList[]{new MyLinkedList(), new MyLinkedList()};
        while (pointer != null) {
            if (pointer.getValue() % 2 != 0) {
                output[0].add(pointer.value);
            } else {
                output[1].add(pointer.value);
            }
            pointer = pointer.next;
        }

        return output;
    }

    public static void printPointer(Pointer pointer) {
        System.out.println("Pointer data : ");
        System.out.println("-------------------------------------------");
        while (pointer != null) {
            System.out.print(pointer.value + " ");
            pointer = pointer.next;
        }
        System.out.println();
        System.out.println("-------------------------------------------");
    }

    public static class MyLinkedList {
        private Pointer head;
        private Pointer tail;

        public void add(int value) {
            if (head == null) {
                head = new Pointer(value);
                return;
            }
            Pointer tmp = tail;
            tail = new Pointer(value);
            if (tmp == null) {
                head.setNext(tail);
            } else {
                tmp.setNext(tail);
            }
        }

        public Pointer getHead() {
            return head;
        }
    }

    public static class Pointer {
        private int value;
        private Pointer next;

        public Pointer(int value) {
            this.value = value;
        }

        public Pointer(int value, Pointer next) {
            this(value);
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public Pointer getNext() {
            return next;
        }

        public void setNext(Pointer next) {
            this.next = next;
        }
    }
}
