package sortingalgorithms;

import danieloikarainen.se.*;

public class MergeSort 
{
	static boolean verbose_output = false;
    public static void main(String[] args)
    {
    	if (verbose_output) System.out.println("Create int array with " + Constants.SIZEARRAY + " elements for Mergesorting...");
        MergeSort instanceofMergesort = new MergeSort(Constants.SIZEARRAY);
        if (verbose_output) System.out.println("...done!!!");
        if (verbose_output) System.out.println("Populate array with random int number...");        
        instanceofMergesort.randomPopulateArray(Constants.MIN_INT_VALUE, Constants.MAX_INT_VALUE);
        if (verbose_output) System.out.println("...done!!!");

        if (verbose_output) System.out.println(); 
        long beforeMeasureTime = System.nanoTime();
        
        //Recursive implementation
        //System.out.println("Start sorting(MergeSort, RECURSIVE)..."); 
        //instanceofMergesort.sortArrayRecursive();
        
        //Iterative Implementation
        if (verbose_output) System.out.println("Start sorting(MergeSort, ITERATIVE)...");
        instanceofMergesort.sortArrayIterative();
        
        
        long afterMeasureTime = System.nanoTime();
        long elapsedTime = afterMeasureTime - beforeMeasureTime;
        if (verbose_output) System.out.println("Finish sorting...(MergeSort, ITERATIVE)");
        
        System.out.println("The time elapsed after sorting(MergeSort, ITERATIVE) array is: " + elapsedTime + " nano Seconds");
        System.out.println("The time elapsed after sorting(MergeSort, ITERATIVE) array is: " + (elapsedTime/1000000000.d) + " Seconds");        
    }
    
    public MergeSort(int pSizeOfArray)
    {
        mSizeArray = pSizeOfArray;
        mNeedsSort = new int[mSizeArray];
                
    }  
    
    public void sortArrayIterative() 
    {
    	mergeSortIterative(mNeedsSort);
    }
    
    public void sortArrayRecursive() 
    {
    	sortRecursive(mNeedsSort, 0, mNeedsSort.length-1);
    	
    }
    
    private void merge(int arr[], int l, int m, int r) 
    {     	    	
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int[n1]; 
        int R[] = new int[n2]; 
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j = 0; j < n2; ++j) 
            R[j] = arr[m + 1 + j]; 
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else 
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
    
    private void sortRecursive(int arr[], int l, int r) 
    { 
        if (l < r) { 
            // Find the middle point 
            int m = (l + r) / 2; 
  
            // Sort first and second halves 
            sortRecursive(arr, l, m); 
            sortRecursive(arr, m + 1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
    
    //Return true if ok otherwise false
    public boolean randomPopulateArray(int pMinValue, int pMaxValue)
    {
        boolean success;
        if (pMaxValue < pMinValue)
            success = false;
        else
            success = true;
                
        int randomValue; 
        
        //Populate array with random value
        for (int i = 0; i < mSizeArray; ++i)
        {
            randomValue = (int )(Math.random() * pMaxValue + pMinValue);
            mNeedsSort[i] = randomValue;
        }
        
        return success;
    }
    
    
    public void printArray()
    {
        for (int i = 0; i < mSizeArray; ++i)
            System.out.println("mNeedsSort[" + i + "] is: " + mNeedsSort[i]);      
    }
    
    /* Added */
    public static void mergeSortIterative(int[] a) 
    {
    	int[] from = a, to = new int[a.length];
        for (int blockSize=1; blockSize<a.length; blockSize*=2) 
        {
           for (int start=0; start<a.length; start+=2*blockSize)
              mergeWithoutCopy(from, to, start, start+blockSize, start+2*blockSize);
            int[] temp = from;
            from = to;
            to = temp;
        }
         if (a != from)
           // copy back
           for (int k = 0; k < a.length; k++)
              a[k] = from[k];    	
    }
    
    private static void mergeWithoutCopy(int[] from, int[] to, int lo, int mid, int hi) 
    {
      if (mid > from.length) 
    	  mid = from.length;
      if (hi > from.length) 
    	  hi = from.length;
      int i = lo, j = mid;
      for (int k = lo; k < hi; k++) 
      {
         if (i == mid)
        	 to[k] = from[j++];
         else if (j == hi)
        	 to[k] = from[i++];
         else if (from[j] < from[i])
        	 to[k] = from[j++];
         else
        	 to[k] = from[i++];
      }
   }
           
    private final int mSizeArray;
    private int[] mNeedsSort;
}
