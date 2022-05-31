package algorithmbase;

import danieloikarainen.se.Constants;

public abstract class AbstractSortAlgorithm 
{
	public AbstractSortAlgorithm(int pSizeOfArray, boolean pVerboseOutput) 
	{				
		mSizeArray = pSizeOfArray;
		mVerboseOutPut = pVerboseOutput;
		
		if (mVerboseOutPut) System.out.println("Create int array with " + pSizeOfArray + " elements...");
        mNeedsSort = new int[mSizeArray];
        if (mVerboseOutPut) System.out.println("done...");          
	}
		
		
	//Abstract methods - Derived object determines behavior
    public abstract long sortArray();
	
	//Return true if array is successfully populated
    public boolean randomPopulateArray(int pMinValue, int pMaxValue)
    {
        boolean success;
        if (pMaxValue < pMinValue)
            success = false;
        else
            success = true;
                
        int randomValue; 
        if (success) 
        {
        	if (mVerboseOutPut) System.out.println("Populating array with random int numbers...");
        	//Populate array with random value
            for (int i = 0; i < mSizeArray; ++i)
            {
                randomValue = (int )(Math.random() * pMaxValue + pMinValue);
                mNeedsSort[i] = randomValue;            
            }
            if (mVerboseOutPut) System.out.println("done...");
        }                
        return success;
    }
    
    public void printArray()
    {
        for (int i = 0; i < mSizeArray; ++i)
            System.out.println("mNeedsSort[" + i + "] is: " + mNeedsSort[i]);      
    }
    
    public int getCountElement() 
    {
    	return mSizeArray;
    }
	    
    protected final int mSizeArray;
    protected int[] mNeedsSort;
    
    protected boolean mVerboseOutPut;
}
