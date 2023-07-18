package org.example.Threads;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//ergonomics
//        memory = 100gb Main= 120gb main = 70gb
//       thread1 = 50gb
//        exit
//        main 30gb
//        70gb

        //Do we know that our processes are being executed via a stack?
        String name = new String("DARO");
//        LIFO while queue work FIFO
        Stack<String> stringStack = new Stack<>();
        stringStack.push("taro");
        stringStack.push("daro");
        stringStack.pop();

        System.out.println(stringStack);
        if (name.equals("Taro")){
            System.out.println("YOU HAVE THE SAME NAME");
        }
        else {
            System.out.println("YOU BOTH HAVE DIFFERENT NAMES");
        }
    }
}
//JVM Execution process
//STACK[
//System.out.println("YOU BOTH HAVE DIFFERENT NAMES");
//isEqual =false
//System.out.println("YOU HAVE THE SAME NAME");
//isEqual = true
//name;
// ]
