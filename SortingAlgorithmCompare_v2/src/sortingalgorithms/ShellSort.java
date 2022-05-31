package sortingalgorithms;

import danieloikarainen.se.*;

public class ShellSort 
{
	static boolean verbose_output = false;
    public static void main(String[] args)
    {
    	if (verbose_output) System.out.println("Create int array with " + Constants.SIZEARRAY + " elements for Shellsorting...");
        ShellSort instanceofShellsort = new ShellSort(Constants.SIZEARRAY);
        if (verbose_output) System.out.println("...done!!!");
        if (verbose_output) System.out.println("Populate array with random int number...");
        instanceofShellsort.randomPopulateArray(Constants.MIN_INT_VALUE, Constants.MAX_INT_VALUE);        
        if (verbose_output) System.out.println("...done!!!");

        if (verbose_output) System.out.println();
        if (verbose_output) System.out.println("Start sorting(ShellSort)...");        
        long beforeMeasureTime = System.nanoTime();
        instanceofShellsort.shellSortArray();
        long afterMeasureTime = System.nanoTime();
        long elapsedTime = afterMeasureTime - beforeMeasureTime;
        if (verbose_output) System.out.println("Finish sorting(ShellSort)...");
        
        System.out.println("The time elapsed after sorting(ShellSort) array is: " + elapsedTime + " nano Seconds");
        System.out.println("The time elapsed after sorting(ShellSort) array is: " + (elapsedTime/1000000000.d) + " Seconds");
    }
    
    
    public ShellSort(int pSizeOfArray)
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
        shellSortArray();
    }
        
    private void shellSortArray()
    {
       for (int increment = (mSizeArray / 2); increment > 0; increment /= 2)
       {
           for (int i = increment; i < mSizeArray; ++i)
           {
               int tempValue = mNeedsSort[i];
               int j;
               for (j = i; j >= increment; j -=increment)
               {
                   if (tempValue < mNeedsSort[j-increment])
                        mNeedsSort[j] = mNeedsSort[j-increment];                   
                   else
                       break;
               }
               mNeedsSort[j] = tempValue; 
           }
       }
    }
           
    private final int mSizeArray;
    private int[] mNeedsSort;
}
