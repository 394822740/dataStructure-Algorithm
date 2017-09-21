package de.vogella.algorithms.sort.mergesort;

public class Mergesort {
    private int[] numbers;
    private int[] helper;
    private int number;

    public void sort(int[] values) {
        this.numbers = values;
        number = values.length;
        this.helper = new int[number];
        mergesort(0, number - 1);
    }

    private void mergesort(int low, int high) {

        
        //base case - knowing a solution OR sub-solution has been found. 
        if(low >= high){
            return;
        }
        
        //find the middle point to divide the problem 
        int middle = low + (high - low) / 2;

        // divide the left half
        mergesort(low, middle);
        //divide the right half
        mergesort(middle + 1, high);
        // conquer and combine the boht part 
        merge(low, middle, high);
    }

    private void merge(int low, int middle, int high) {
        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;   // index of the left array 
        int j = middle + 1; // index of the right array
        int k = low; // sub-solution array index 
    
        //merge two sorted list template (below)
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
                k++;
            } else {
                numbers[k] = helper[j];
                j++;
                k++
            }
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            i++;
            k++;
        }
        // Since we are sorting in-place any leftover elements from the right side
        // are already at the right position.

    }
}