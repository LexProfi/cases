package com.lex.twopointers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * Demo application to consider various algorithms for finding two numbers whose sum is equal to a given parameter
 */
@SpringBootApplication
public class TwoPointersApplication {

    public static void main(String[] args) {

        SpringApplication.run(TwoPointersApplication.class, args);

        int[] array = new int[]{-7, 0, 2, 3, 6, 8, 10, 15, 18, 20};

        System.out.println(Arrays.toString(twoSumEnumeration(array, 10)));
        System.out.println(Arrays.toString(twoSumHashSet(array, 10)));
        System.out.println(Arrays.toString(twoSumBinary(array, 10)));
        System.out.println(Arrays.toString(twoSumTwoPointers(array, 10)));

    }

    /**
     * Search in an array for a pair of numbers, the sum of which is equal to a given parameter using the brute force methodю
     * Time: O(n2)
     * Memory: O(1)
     */
    public static int[] twoSumEnumeration(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == k){
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return new int[0];
    }

    /**
     * Search in an array for a pair of numbers, the sum of which is equal to a given parameter using the brute force methodю
     * Time: O(n)
     * Memory: O(n)
     */
    public static int[]twoSumHashSet(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i =0; i < nums.length; i++ ){
           int numberToFind = k - nums[i];
           if (set.contains(numberToFind)) {
               return new int[]{numberToFind, nums[i]};
           }
           set.add(nums[i]);
        }
        return new int[0];
    }

    /**
     * Search in an array for a pair of numbers whose sum is closest to a given number using the method of Binary Search.
     * Time: O(n log n)
     * Memory: O(1)
     */
    public static int[] twoSumBinary(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int numberToFind = k - nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l <= r) {
                int mid = l + (r -l) / 2;
                if(nums[mid] == numberToFind){
                    return new int[]{nums[i], nums[mid]};
                }
                if (numberToFind < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return new int[0];
    }


    /**
     * Search in an array for a pair of numbers, the sum of which is equal to a given number, using the method of two pointers.
     * Time: O(n)
     * Memory: O(1)
     */
    public static int[] twoSumTwoPointers(int[] nums, int k) {
        int l =0;
        int r = nums.length;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if(sum == k) {
                return new int[]{nums[l],nums[r]};
            }
            if (sum < k) {
                l++;
            } else {
                r--;
            }
        }
        return new int[0];
    }
}
