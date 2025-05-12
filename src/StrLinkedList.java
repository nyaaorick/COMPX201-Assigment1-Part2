import java.util.Random;

public class StrLinkedList {
    private Node head;  
    private class Node {
        int value; 
        Node next;  

        // Node
        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }


    // Constructor for the linked list
    public StrLinkedList() {
        head = null;  // Initially, the list is empty
    }


    //isEmpty() - returns boolean true if the linked list is empty.
    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;  // If head is null, the list is empty
    }


    //getLength() - returns (as an int) a count of the number of values (i.e. nodes) in
    //the linked list; zero if the list is empty.
    public int getLength() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;  
        }
        return length;
    }

    //hasValue(String s) - returns a boolean value that is true if the linked list
    //contains a node whose value is the same as s; false otherwise.
    // Check if the list contains a specific value
    public boolean hasValue(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return true; 
            }
            current = current.next; 
        }
        return false; 
    }


    //add(String s) - adds to the head of the list a new node with the String value
    //s; then returns void.
    public void add(int value) {
        Node newNode = new Node(value);
        newNode.next = head;  
        head = newNode;  
    }

    //random from 1 - 40 numbers
    //hold a list of all possible lottery numbers (numbers “1” to “40”)
    public static StrLinkedList generateLotteryNumbers() {
        StrLinkedList lotteryNumbers = new StrLinkedList();
        Random rand = new Random();
        while (lotteryNumbers.getLength() < 40) {
            int randomNum = rand.nextInt(40) + 1;  // 生成 1 到 40 之间的随机数
            if (!lotteryNumbers.hasValue(randomNum)) {
                lotteryNumbers.add(randomNum);  // 如果没有重复号码，加入链表
            }
        }
        return lotteryNumbers;
    }

    //randomly select six of these numbers as the “winning numbers”
    public static StrLinkedList pickWinningNumbers(StrLinkedList lotteryNumbers) {
        StrLinkedList winningNumbers = new StrLinkedList();
        Random rand = new Random();
        int count = 0;
        Node current = lotteryNumbers.head;
        while (current != null && count < 6) {
            // randomly select a number from the lottery numbers
            int randomIndex = rand.nextInt(lotteryNumbers.getLength());
            Node temp = lotteryNumbers.head;
            for (int i = 0; i < randomIndex; i++) {
                temp = temp.next;
            }
            if (!winningNumbers.hasValue(temp.value)) {
                winningNumbers.add(temp.value);
                count++;
            }
            current = current.next;
        }
        return winningNumbers;
    }


    // calculate the number of matches between a ticket and winning numbers
    public static int calculateMatches(StrLinkedList ticket, StrLinkedList winningNumbers) {
        int matches = 0;
        Node ticketNode = ticket.head;
        while (ticketNode != null) {
            if (winningNumbers.hasValue(ticketNode.value)) {
                matches++;
            }
            ticketNode = ticketNode.next;
        }
        return matches;
    }

    //Prize pool
    public static double calculatePrize(int matches) {
        switch (matches) {
            case 2: return 10.00;
            case 3: return 100.00;
            case 4: return 1000.00;
            case 5: return 10000.00;
            case 6: return 100000.00;
            default: return 0.00;
        }
    }


    //generate ticket, for 100 times
    public static StrLinkedList generateTicket(StrLinkedList lotteryNumbers) {
        StrLinkedList ticket = new StrLinkedList();
        Random rand = new Random();
        while (ticket.getLength() < 6) {
            int randomIndex = rand.nextInt(lotteryNumbers.getLength());
            Node temp = lotteryNumbers.head;
            for (int i = 0; i < randomIndex; i++) {
                temp = temp.next;
            }
            if (!ticket.hasValue(temp.value)) {
                ticket.add(temp.value);
            }
        }
        return ticket;
    }


    // Print the values in the list
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) {
                System.out.print("->");  // Print "->" between values
            }
            current = current.next;  // Move to the next node
        }
        System.out.println();  // Move to the next line after printing the list
    }
}