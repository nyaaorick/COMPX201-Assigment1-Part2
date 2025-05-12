# COMPX201-Assigment1-Part2: Lottery Game Simulation

## Description

This project implements a basic singly linked list data structure (`StrLinkedList`) in Java and builds a simple lottery game simulation on top of it. The main purpose is to demonstrate the basic operations of a linked list (such as adding, searching, getting length, etc.) in a practical (albeit simplified) application scenario.

The program simulates the following lottery game flow:
1.  Generate a pool of all possible lottery numbers (1 to 40).
2.  Randomly select 6 numbers from the pool as the winning numbers.
3.  Generate a ticket for the user containing 6 random numbers.
4.  Compare the user's ticket with the winning numbers to calculate the number of matches.
5.  Determine the prize money based on the number of matches.

This project serves as a good starting point for learning and understanding the concepts of singly linked lists and their practical applications.

## Features

**Linked List (`StrLinkedList`) Functionality:**
* **Node**: An inner class representing each element (train car) in the linked list, containing an integer value (lottery number) and a reference to the next node.
* **Constructor**: Initializes an empty linked list.
* `isEmpty()`: Checks if the linked list is empty.
* `getLength()`: Returns the number of nodes in the linked list.
* `hasValue(int value)`: Checks if the linked list contains a node with a specific value.
* `add(int value)`: Adds a new node to the head of the list.
* `print()`: Prints all values in the linked list.

**Lottery Game Simulation Functionality:**
* `generateLotteryNumbers()`: Generates a linked list containing unique numbers from 1 to 40 as the lottery number pool.
* `pickWinningNumbers(StrLinkedList lotteryNumbers)`: Randomly selects 6 unique numbers from the given number pool as winning numbers and returns them in a new linked list.
* `generateTicket(StrLinkedList lotteryNumbers)`: Randomly selects 6 unique numbers from the given number pool for a lottery ticket and returns them in a new linked list.
* `calculateMatches(StrLinkedList ticket, StrLinkedList winningNumbers)`: Calculates the number of matching numbers between a lottery ticket and the winning numbers.
* `calculatePrize(int matches)`: Returns the corresponding prize amount based on the number of matches.

## How to Compile and Run

1.  **Save the code**: Save the provided Java code into a file named `StrLinkedList.java`.
2.  **Compile**: Open a command line or terminal, navigate to the directory where you saved the file, and run the following command:
    ```bash
    javac StrLinkedList.java
    ```
    If the compilation is successful, this will generate `StrLinkedList.class` and `StrLinkedList$Node.class` files.

3.  **Run**:
    * The provided code includes a `main` method within the `StrLinkedList.java` file to demonstrate its functionalities. After compiling, you can run the program using:
        ```bash
        java StrLinkedList
        ```
    * The `main` method will:
        1.  Generate the lottery number pool and print a portion of it.
        2.  Pick and print the winning numbers.
        3.  Generate and print a user's ticket.
        4.  Calculate and print the number of matches for the user's ticket.
        5.  Calculate and print the prize amount.
        6.  Simulate generating and checking 5 additional tickets.

## Code Structure

* **`StrLinkedList.java`**: Contains the main linked list implementation and the lottery game logic.
    * **`private class Node`**: Defines the data structure for nodes in the linked list. Each node stores an integer value and a reference to the next node.
    * **Basic Linked List Operations**: `StrLinkedList()`, `isEmpty()`, `getLength()`, `hasValue(int)`, `add(int)`, `print()`. These methods provide the fundamental capabilities for managing and interacting with the linked list.
    * **Static Lottery Game Methods**:
        * `generateLotteryNumbers()`: Constructs a linked list containing all possible numbers.
        * `pickWinningNumbers()`: Selects winning numbers from the number pool.
        * `generateTicket()`: Generates a lottery ticket for the user.
        * `calculateMatches()`: Compares two sets of numbers and counts matches.
        * `calculatePrize()`: Determines the prize based on the number of matches.

## Author
20233006416