package algorithmbase.sorting;

import algorithmbase.AbstractSortAlgorithm;
import danieloikarainen.se.Constants;

public class EnhancedShellSort extends AbstractSortAlgorithm 
{

	public EnhancedShellSort(int pSizeOfArray, boolean pVerboseOutput) 
	{
		super(pSizeOfArray, pVerboseOutput);
		super.randomPopulateArray(Constants.MIN_INT_VALUE, Constants.MAX_INT_VALUE);
	}

	@Override
	public long sortArray() 
	{
		if (mVerboseOutPut) System.out.println("Start - (Shell)Sorting...");
		long beforeMeasureTime = System.nanoTime();
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
		if (mVerboseOutPut) System.out.println("Done - (Shell)Sorting...");
		long afterMeasureTime = System.nanoTime();
		
		return afterMeasureTime - beforeMeasureTime;
	}
}
