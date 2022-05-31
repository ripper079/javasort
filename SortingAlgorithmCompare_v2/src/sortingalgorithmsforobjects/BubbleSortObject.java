package sortingalgorithmsforobjects;

import java.util.GregorianCalendar;

import danieloikarainen.se.Employee;

public class BubbleSortObject
{
	public static final int sizeOfArrayForObjects = 5;
	
	public static void main(String[] args)
    {
		System.out.println("XXXXXXXXXXXXXX");
		new BubbleSortObject(BubbleSortObject.sizeOfArrayForObjects);
    }
	
	public BubbleSortObject(int pSizeOfArray)
	{
		mSizeArray = pSizeOfArray;
		//Allocates space for array,DOESNt Create employees object yet
		mNeedsSort = new Employee[mSizeArray];
		
		//Populate the array
		mNeedsSort[0] = new Employee("Daniel", "Oikarainen", new GregorianCalendar(2000, GregorianCalendar.MAY, 15));
		mNeedsSort[1] = new Employee("Niranchaya", "Oikarainen", new GregorianCalendar(2015, GregorianCalendar.JANUARY, 25));		
		mNeedsSort[2] = new Employee("Dennis", "Oikarainen", new GregorianCalendar(2007, GregorianCalendar.DECEMBER, 5));
		mNeedsSort[3] = new Employee("Teresa", "Enontekiö", new GregorianCalendar(1985, GregorianCalendar.JANUARY, 17));
		mNeedsSort[4] = new Employee("Bill", "Gates", new GregorianCalendar(1990, GregorianCalendar.JUNE, 2));		
		
		System.out.println("Before Sorting");
		for (int i = 0; i < BubbleSortObject.sizeOfArrayForObjects; ++i)
			System.out.println(mNeedsSort[i]);
		System.out.println("After Sorting");
		sortArray();
		for (int i = 0; i < BubbleSortObject.sizeOfArrayForObjects; ++i)
			System.out.println(mNeedsSort[i]);
		
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
                if (mNeedsSort[i].isLarger(mNeedsSort[j]))
                {
                    //Swap to right
                    Employee temp = mNeedsSort[i].clone();
                    mNeedsSort[i] = mNeedsSort[j];
                    mNeedsSort[j] = temp;
                    
                }
            }
        }
    }

	
	private final int mSizeArray;	
    private Employee[] mNeedsSort;
}
