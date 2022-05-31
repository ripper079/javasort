package sortingalgorithms;

import danieloikarainen.se.*;

public class QuickSort 
{
	static boolean verbose_output = false;
    public static void main(String[] args)
    {
    	if (verbose_output) System.out.println("Create int array with " + Constants.SIZEARRAY + " elements for Quicksorting...");
        QuickSort instanceofQuicksort = new QuickSort(Constants.SIZEARRAY);
        if (verbose_output) System.out.println("...done!!!");
        if (verbose_output) System.out.println("Populate array with random int number...");
        instanceofQuicksort.randomPopulateArray(Constants.MIN_INT_VALUE, Constants.MAX_INT_VALUE);
        if (verbose_output) System.out.println("...done!!!");

        if (verbose_output) System.out.println();
        if (verbose_output) System.out.println("Start sorting(QuickSort)...");        
        long beforeMeasureTime = System.nanoTime();
        instanceofQuicksort.sortArray();
        long afterMeasureTime = System.nanoTime();
        long elapsedTime = afterMeasureTime - beforeMeasureTime;
        if (verbose_output) System.out.println("Finish sorting(QuickSort)...");
        
        System.out.println("The time elapsed after sorting(QuickSort) array is: " + elapsedTime + " nano Second(s)");
        System.out.println("The time elapsed after sorting(QuickSort) array is: " + (elapsedTime/1000000000.d) + " Second(s)");

    }
    
    public QuickSort(int pSizeOfArray)
    {
        mSizeArray = pSizeOfArray;
        mNeedsSort = new int[mSizeArray];                
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
        quickSortArray(0, (mNeedsSort.length-1));
    }
    
    //low = Starting index, usually 0
    //high = elements in array minus 1 (mNeedsSort.length-1)
    private void quickSortArray(int low, int high)
    {
        if (low < high)
        {
            int partionIndex = partition(low, high);
            
            quickSortArray(low, (partionIndex-1));
            quickSortArray((partionIndex+1), high);
        }
    }
    
    private int partition(int low, int high)
    {
        int pivot = mNeedsSort[high];
        //Index of smaller element
        int i = (low-1);
        
        for (int j = low; j <= (high-1); ++j)
        {
            if (mNeedsSort[j] <= pivot)
            {
                ++i;
                
                //swap elements
                int tempValue = mNeedsSort[i];
                mNeedsSort[i] = mNeedsSort[j];
                mNeedsSort[j] = tempValue;
            }
        }
        //Swap elements
        int tempValue = mNeedsSort[i+1];
        mNeedsSort[i+1] = mNeedsSort[high];
        mNeedsSort[high] = tempValue;
        
        return (i+1);        
    }
    
    private final int mSizeArray;
    private int[] mNeedsSort;
    
    public static final int SIZEARRAY = 100000000;
}
