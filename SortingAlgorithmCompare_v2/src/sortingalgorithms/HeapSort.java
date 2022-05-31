package sortingalgorithms;

import danieloikarainen.se.*;

public class HeapSort 
{
	static boolean verbose_output = false;
    public static void main(String[] args)
    {
    	if (verbose_output) System.out.println("Create int array with " + Constants.SIZEARRAY + " elements for Heapsorting...");
        HeapSort instanceofHeapsort = new HeapSort(Constants.SIZEARRAY);
        if (verbose_output) System.out.println("...done!!!");
        if (verbose_output) System.out.println("Populate array with random int number...");
        instanceofHeapsort.randomPopulateArray(Constants.MIN_INT_VALUE, Constants.MAX_INT_VALUE);
        if (verbose_output) System.out.println("...done!!!");
        
        if (verbose_output) System.out.println();
        if (verbose_output) System.out.println("Start sorting(HeapSort)...");        
        long beforeMeasureTime = System.nanoTime();
        instanceofHeapsort.sortArray();
        long afterMeasureTime = System.nanoTime();
        long elapsedTime = afterMeasureTime - beforeMeasureTime;
        if (verbose_output)  System.out.println("Finish sorting(HeapSort)...");
        
        System.out.println("The time elapsed after sorting(HeapSort) array is: " + elapsedTime + " nano Seconds");
        System.out.println("The time elapsed after sorting(HeapSort) array is: " + (elapsedTime/1000000000.d) + " Seconds");        
    }
    
    public HeapSort(int pSizeOfArray)
    {
        mSizeArray = pSizeOfArray;
        mNeedsSort = new int[mSizeArray];
        
        N = (mSizeArray -1);
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
    
    public void sortArray()
    {
        heapSortArray();
    }
    
    private void heapSortArray()
    {
        heapify();
        
        for (int i = N; i > 0; --i)
        {
            //Swap again                        
            int tempValue = mNeedsSort[0];
            mNeedsSort[0] = mNeedsSort[i];
            mNeedsSort[i] = tempValue;
            
            N--;
            maxHeap(0);
        }
    }
    
    //Build the heap
    private void heapify()
    {
        for (int i = N/2; i >= 0; --i)
            maxHeap(i);
    }
    
    //Swap largest element in heap
    private void maxHeap(int i)
    {
        int left = (2 * i);
        int right = (2 * i + 1);
        int max = i;
        
        if (left <= N && mNeedsSort[left] > mNeedsSort[i])
            max = left;
        if (right <= N && mNeedsSort[right] > mNeedsSort[max])
            max = right;
        
        if (max != i)
        {
            int tempValue = mNeedsSort[i];
            mNeedsSort[i] = mNeedsSort[max];
            mNeedsSort[max] = tempValue;
            
            maxHeap(max);
        }
    }
    
    
    private final int mSizeArray;
    private int[] mNeedsSort;
    
    private int N;
}
