package ct.fp.example1;

import java.util.Arrays;

/*
 This program takes an array of integers, weeds out numbers lesser than 5,
 eliminates duplicates and returns the sum of the numbers that remain
 */
public class ImperativeLoop {

    public static void main(String[] args) {

        int[] arr = { 1,2,3,4,5,6,7,8,9,1,3,4,5,6,7,8,3,4,7,8,9};

        // need sum of numbers greater than 4 (with duplicates eliminated)

        // first sort the array
        Arrays.sort(arr);

        System.out.println("arr = " + Arrays.toString(arr));

        // now filter numbers greater than 4 and eliminate duplicates
        int sum = 0; // running aggregate total
        int dup = 0; // to eliminate duplicates
        for (int i : arr) {
            if (i < 5 || (i == dup)) {
                continue;
            } else {
                sum += i;
                System.out.println("Adding " + i);
                dup = i;
            }
        }

        System.out.println("sum = " + sum);
    }
}
