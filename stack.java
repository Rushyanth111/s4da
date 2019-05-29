import java.util.Scanner;

class Stack {
    private int arr[], top, size;

    public Stack(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    public void push(int i) {
        if (top == size - 1) {
            System.out.println("Stack is full");
            return;
        }
        arr[++top] = i;
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Element Popped is: " + arr[top--]);
    }

    public void display() {
        if (top == -1) {
            System.out.print("Empty\n");
            return;
        }
        System.out.print("\nStack: ");
        for (int i = top; i >= 0; i--)
            System.out.print(arr[i] + " ");
    }
}