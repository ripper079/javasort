package algorithmbase.sorting;

import algorithmbase.*;
import danieloikarainen.se.Constants;

public class EnhancedBubbledSort extends AbstractSortAlgorithm 
{
	public EnhancedBubbledSort(int pSizeOfArray, boolean pVerboseOutput) {
		super(pSizeOfArray, pVerboseOutput);
		 
		super.randomPopulateArray(Constants.MIN_INT_VALUE, Constants.MAX_INT_VALUE);
	}

	@Override
	public long sortArray() 
	{
		if (mVerboseOutPut) System.out.println("Start - (Bubble)Sorting...");
		long beforeMeasureTime = System.nanoTime();		
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
		if (mVerboseOutPut) System.out.println("Done - (Bubble)Sorting...");
		long afterMeasureTime = System.nanoTime();
		return afterMeasureTime - beforeMeasureTime;
	}
		
}
