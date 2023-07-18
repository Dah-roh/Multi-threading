package org.example;

import java.util.*;

public class Algoro {

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        List<Integer> rotatedArray = new ArrayList<>(arr);
        for (int i = 0; i < arr.size(); i++) {
            int index = i<d?((d-i)>0?(arr.size()-(d-i)):(d-i)):(i-d);
            rotatedArray.set(index, arr.get(i));
        }
        return rotatedArray;
    }

    public static void main(String[] args) {
        System.out.println(rotateLeft(2, Arrays.asList(1,2,3,4,5)));
    }

}

