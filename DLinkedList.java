package Double_LinkedList;

import java.util.Scanner;

public class DLinkedList {
    public static Node Create(Node head){
        Scanner sc = new Scanner(System.in);
        char ch;
        int nodeCount = 1;
        do{
            Node temp = null;
            Node node = new Node();
            System.out.print("Enter data :");
            node.data = sc.nextInt();
            if (head == null) {
                head = node;
            }
            else{
                temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = node;
                node.prev = temp;
            }
            System.out.println(nodeCount+" Node created  ");
            System.out.println("Would you like to create a new node (y/n) :");
            ch = sc.next().charAt(0);
            if (ch=='y'||ch=='Y') {
                nodeCount++;
            }
        }
        while(ch == 'y' || ch == 'Y');
        return head;
    }
    public static void Display(Node head){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+"-->");
            temp = temp.next;
        }
        System.out.println("null");

    }
    public static Node InsertAtBegin(Node head){
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserting data at the first");
        Node node = new Node();
        System.out.print("Enter the data to new node :");
        node.data = sc.nextInt();
        if (head == null) {
            head = node;
        }
        else{
            node.next = head;
            head = node;
        }
        return head;
    }
    public static Node InsertAtEnd(Node head){
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserting at end ");
        Node temp = null;
        Node node = new Node();
        System.out.print("Enter the data to the new node :");
        node.data = sc.nextInt();
        if (head == null) {
            head = node;
        }
        else{
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            node.prev = temp;
        }
        return head;

    }
    public static int size(Node head){
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    public static Node InsertAtAnyPos(Node head){
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserting at any position ");
        Node node = new Node();
        System.out.print("Enter the data :");
        node.data = sc.nextInt();
        System.out.print("Enter the position :");
        int pos = sc.nextInt();
        if (pos==0) {
            head = InsertAtBegin(head);
        }else if (pos == size(head)) {
            head = InsertAtEnd(head);
        }
        else{
            Node temp = head;
            for (int i = 1; i < pos-1; i++) {
                temp = temp.next;
            }
            node.next = temp.next;
            node.prev = temp;
            temp.next.prev = node;
            temp.next = node;
            
        }
        return head;

    }
    public static Node DeleteFromBegin(Node head){
        if (head == null) {
            System.out.println("Empty list");
            return head;
        }
        else{
            System.out.println("Deleting :"+head.data);
            head = head.next;
            head.prev = null;
            
        }
        return head;
    } 
    public static Node DeleteFromEnd(Node head){
        int length = size(head);
        Node temp = head;
        for (int i = 0; i < length-2; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
    public static Node DeleteFromAnyPos(Node head){
        Scanner sc = new Scanner(System.in);
        int length = size(head);
        Node temp = head;
        System.out.print("Enter the position :");
        int pos = sc.nextInt();
        if (pos == 0) {
            head = DeleteFromBegin(head);
            
        }
        else if (pos == length) {
            head = DeleteFromEnd(head);
        }
        else{
            for (int i = 1; i < pos-1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp;
        }
        return head;

    }
}
