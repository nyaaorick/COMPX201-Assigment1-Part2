import java.util.Random;

public class StrLinkedList {


    private Node head;  // The starting point of the list
    // Node class to represent each element in the list
    //Define an inner class called Node for nodes in your StrLinkedList. It
    //should have the following:
    // 内部类 Node，表示链表中的每个节点
    private class Node {
        int value;  // 存储彩票号码
        Node next;  // 指向下一个节点

        // Node 类的构造函数
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


    // 获取链表的长度（即节点的数量）
    //getLength() - returns (as an int) a count of the number of values (i.e. nodes) in
    //the linked list; zero if the list is empty.
    public int getLength() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;  // 移动到下一个节点
        }
        return length;
    }

    //hasValue(String s) - returns a boolean value that is true if the linked list
    //contains a node whose value is the same as s; false otherwise.
    // Check if the list contains a specific value
    // 检查链表是否包含指定的号码
    public boolean hasValue(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return true;  // 找到匹配的值
            }
            current = current.next;  // 移动到下一个节点
        }
        return false;  // 没有找到匹配的值
    }

    // Get the value at a specific index in the list
    //public String getValueAt(int i) {
    // if (i < 0 || i >= getLength()) {
           // throw new IndexOutOfBoundsException("Index out of bounds");
       // }

       // Node current = head;
       // for (int j = 0; j < i; j++) {
         //   current = current.next;  // Traverse the list to the index
       // }

       // return current.value;  // Return the value at the index
    //}

    // 向链表头部添加一个新的节点
    //add(String s) - adds to the head of the list a new node with the String value
    //s; then returns void.
    public void add(int value) {
        Node newNode = new Node(value);  // 创建新节点
        newNode.next = head;  // 新节点的 next 指向当前的头节点
        head = newNode;  // 更新头节点为新节点
    }

    // Remove the first node that contains a specific value
    //public void remove(String s) {
       // if (head == null) return;  // If the list is empty, do nothing
       // if (head.value.equals(s)) {  // If the head is the node to be removed
       //     head = head.next;  // Remove the head node by making head point to the next node
           // return;
      //  }
       // Node current = head;
       // while (current.next != null) {
          //  if (current.next.value.equals(s)) {
              //  current.next = current.next.next;  // Remove the node by skipping it
              //  return;
          //  }
          //  current = current.next;  // Move to the next node
      //  }
   // }

    // 随机生成 1 到 40 之间的所有彩票号码（不重复）
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
    // 随机选择 6 个中奖号码
    public static StrLinkedList pickWinningNumbers(StrLinkedList lotteryNumbers) {
        StrLinkedList winningNumbers = new StrLinkedList();
        Random rand = new Random();
        int count = 0;
        Node current = lotteryNumbers.head;
        while (current != null && count < 6) {
            // 随机选择 6 个号码
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


    // 计算彩票与中奖号码之间的匹配数
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

    // 根据匹配的号码数计算奖品金额
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
    //生成一张包含 6 个随机号码的彩票
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