package sortingalgorithms;

import danieloikarainen.se.*;

public class InsertionSort 
{
	static boolean verbose_output = false;
    public static void main(String[] args)
    {
    	if (verbose_output) System.out.println("Create int array with " + Constants.SIZEARRAY + " elements for InsertionSort...");
        InsertionSort instanceofInsertionsort = new InsertionSort(Constants.SIZEARRAY);
        if (verbose_output) System.out.println("...done!!!");
        if (verbose_output) System.out.println("Populate array with random int number...");
        instanceofInsertionsort.randomPopulateArray(Constants.MIN_INT_VALUE, Constants.MAX_INT_VALUE);        
        if (verbose_output) System.out.println("...done!!!");
        
        if (verbose_output) System.out.println();
        if (verbose_output) System.out.println("Start sorting(InsertionSort)...");        
        long beforeMeasureTime = System.nanoTime();
        instanceofInsertionsort.sortArray();
        long afterMeasureTime = System.nanoTime();
        long elapsedTime = afterMeasureTime - beforeMeasureTime;
        if (verbose_output) System.out.println("Finish sorting...(InsertionSort)");
        
        System.out.println("The time elapsed after sorting(InsertionSort) array is: " + elapsedTime + " nano Seconds");
        System.out.println("The time elapsed after sorting(InsertionSort) array is: " + (elapsedTime/1000000000.d) + " Seconds");
    }
    
    public InsertionSort(int pSizeOfArray)
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
        insertionSortArray();
    }
    
    private void insertionSortArray()
    {
        for (int i = 1; i < mSizeArray; ++i)
        {
            int tempValue = mNeedsSort[i];
            int j;
            for (j = (i-1); j >= 0  && tempValue < mNeedsSort[j] ; --j)            
                mNeedsSort[j+1] = mNeedsSort[j];                        
            mNeedsSort[j+1] = tempValue;            
        }
    }
    
    private final int mSizeArray;
    private int[] mNeedsSort;
}