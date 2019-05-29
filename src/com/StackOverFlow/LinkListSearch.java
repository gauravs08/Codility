package com.StackOverFlow;

//https://stackoverflow.com/questions/55461249/i-am-getting-error-in-the-below-code-to-find-specific-number-in-the-java-linkedl/55462368#55462368
import java.util.*;

public class LinkListSearch {
	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int n) {
			data = n;
			next = null;
		}

	}

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		head = null;
		if (n > 0) {
			head = new Node(s.nextInt());
			Node temp = head;
			for (int i = 1; i < n; i++) {
				temp.next = new Node(s.nextInt());
				temp = temp.next;
			}
		}
		int m = s.nextInt();
		//if search position n > length of linkedlist 
		if (m > n) {
			System.out.println("Not Possible");
		} else {
			mthNodeFromEnd(m);
		}
	}

	// Method to find mth element from the end in the LinkedList
	static void mthNodeFromEnd(int m) {

		int count = 1;
		Node current = head;
		while (current.next != null) {

			current = current.next;

			count++;
		}
		//
		current = head;
		int n = count - m + 1;
		for (int i = 1; i < n; i++) {

			current = current.next;

		}

		System.out.println(current.data);

	}
}