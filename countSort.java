
O(n+k) // length of the array and the max value of the element

class CountingSort
{
    void sort(char arr[])
    {
 
        // The output character array that will have sorted arr
        char output[] = new char[arr.length;];
 
        // characters and initialize count array as 0
        int count[] = new int[256];
        for (int i=0; i<256; i++)
            count[i] = 0;
 
        // store count of each character
        for (int i=0; i<arr.length;; i++)
            count[arr[i]] = count[arr[i]]+1;
 
        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i=1; i<=255; i++)
            count[i] += count[i-1];
 
        // Build the output character array
        for (int i = arr.length-1; i>0; i--)
        {
            output[count[arr[i]]] = arr[i];
            count[arr[i]] = count[arr[i]]-1; 
        }
 
        //copy 
        for (int i = 0; i<n; i++)
            arr[i] = output[i];
    }
}


class Radix{
    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixsort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);
 
        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

     static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
}
   