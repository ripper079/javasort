package sortingalgorithms;

import danieloikarainen.se.*;

public class SelectionSort 
{
	static boolean verbose_output = false;
    public static void main(String[] args)
    {
    	if (verbose_output) System.out.println("Create int array with " + Constants.SIZEARRAY + " elements for SelectionSorting...");
    	SelectionSort instanceofSelectionsort = new SelectionSort(Constants.SIZEARRAY);
    	if (verbose_output) System.out.println("...done!!!");
    	if (verbose_output) System.out.println("Populate array with random int number...");
        instanceofSelectionsort.randomPopulateArray(Constants.MIN_INT_VALUE, Constants.MAX_INT_VALUE);
        if (verbose_output) System.out.println("...done!!!");

        if (verbose_output) System.out.println();        
        if (verbose_output) System.out.println("Start sorting(SelectionSort)...");        
        long beforeMeasureTime = System.nanoTime();
        instanceofSelectionsort.sortArray();
        long afterMeasureTime = System.nanoTime();
        long elapsedTime = afterMeasureTime - beforeMeasureTime;
        if (verbose_output) System.out.println("Finish sorting...(SelectionSort)");
        
        System.out.println("The time elapsed after sorting(SelectionSort) array is: " + elapsedTime + " nano Seconds");
        System.out.println("The time elapsed after sorting(SelectionSort) array is: " + (elapsedTime/1000000000.d) + " Seconds");
    }
    
    public SelectionSort(int pSizeOfArray)
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
        selectionSortArray();
    }
    
    private void selectionSortArray()
    {
        int i, j;  
        int minIndex; 
        int tempValue;  
  
        for (i = 0; i < (mSizeArray-1); i++)  
        {  
            minIndex = i;  
            for (j = (i+1); j < mSizeArray; j++)  
            {  
                if (mNeedsSort[j] < mNeedsSort[minIndex])  
                    minIndex = j;  
            }
            
            //Swap values
            tempValue = mNeedsSort[i];  
            mNeedsSort[i] = mNeedsSort[minIndex];  
            mNeedsSort[minIndex] = tempValue;  
        } 
    }
    
    private final int mSizeArray;
    private int[] mNeedsSort;
}