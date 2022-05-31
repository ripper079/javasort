package sortingalgorithms;

import danieloikarainen.se.*;

//Only works with primitive types of int
public class Bubblesort 
{
	static boolean verbose_output = false;
	public static void main(String[] args)
    {        
		if (verbose_output) System.out.println("Create int array with " + Constants.SIZEARRAY + " elements for Bublesorting...");
		Bubblesort instanceOfBubbleSort = new Bubblesort(Constants.SIZEARRAY);
		if (verbose_output) System.out.println("...done!!!");
		if (verbose_output) System.out.println("Populate array with random int number...");
        instanceOfBubbleSort.randomPopulateArray(Constants.MIN_INT_VALUE, Constants.MAX_INT_VALUE);
        if (verbose_output) System.out.println("...done!!!");
        
        if (verbose_output) System.out.println();
        if (verbose_output) System.out.println("Start sorting(BubbleSort)...");
        long beforeMeasureTime = System.nanoTime();
        instanceOfBubbleSort.sortArray();
        long afterMeasureTime = System.nanoTime();
        long elapsedTime = afterMeasureTime - beforeMeasureTime;
        if (verbose_output) System.out.println("Finish sorting...(BubbleSort)");
        
        System.out.println("The time elapsed after sorting(BubbleSort) array is: " + elapsedTime + " nano Seconds");
        System.out.println("The time elapsed after sorting(BubbleSort) array is: " + (elapsedTime/1000000000.d) + " Seconds");     
    }
				    	
    public Bubblesort(int pSizeOfArray)
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
        bubbleSortArray();
    }
    
    private void bubbleSortArray()
    {
        for (int i =0; i < (mSizeArray-1) ; ++i )
        {
            for (int j= (i+1); (j < mSizeArray); ++j)
            {
                if (mNeedsSort[i] > mNeedsSort[j])
                {
                    //Swap to right
                    int temp = mNeedsSort[i];
                    mNeedsSort[i] = mNeedsSort[j];
                    mNeedsSort[j] = temp;
                    
                }
            }
        }
    }
    
    private final int mSizeArray;
    private int[] mNeedsSort;
}
