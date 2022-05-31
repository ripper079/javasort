package algorithmbase.sorting;

import algorithmbase.AbstractSortAlgorithm;
import danieloikarainen.se.Constants;

public class EnhancedQuickSort extends AbstractSortAlgorithm 
{
	public EnhancedQuickSort(int pSizeOfArray, boolean pVerboseOutput) {
		super(pSizeOfArray, pVerboseOutput);
		 
		super.randomPopulateArray(Constants.MIN_INT_VALUE, Constants.MAX_INT_VALUE);
	}

	@Override
	public long sortArray() 
	{
		if (mVerboseOutPut) System.out.println("Start - (Quicksorting)Sorting...");
		long beforeMeasureTime = System.nanoTime();
		
		quickSortArray(0, (mNeedsSort.length-1));
		
		if (mVerboseOutPut) System.out.println("Done - (Quicksorting)Sorting...");
		long afterMeasureTime = System.nanoTime();
		return afterMeasureTime - beforeMeasureTime;
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
}
