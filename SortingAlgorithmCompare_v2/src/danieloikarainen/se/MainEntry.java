package danieloikarainen.se;

import sortingalgorithms.Bubblesort;
import sortingalgorithms.HeapSort;
import sortingalgorithms.InsertionSort;
import sortingalgorithms.MergeSort;
import sortingalgorithms.QuickSort;
import sortingalgorithms.SelectionSort;
import sortingalgorithms.ShellSort;

import java.util.ArrayList;

import algorithmbase.AbstractSortAlgorithm;
import algorithmbase.sorting.EnhancedBubbledSort;
import algorithmbase.sorting.EnhancedQuickSort;
import algorithmbase.sorting.EnhancedShellSort;

public class MainEntry 
{
	public static void main(String[] args) 
	{	
		//Change this value for different numbers of elements to sort
		//danieloikarainen.se.Constants.SIZEARRAY
		
		//One thread
		runAlgorithmsSequentiallyIntArray(args);
		//Or multiple Threads
		//runAlgorithmsInThreadsIntArray(args);
		
		
		/*
		ArrayList<Double> timeRound = new ArrayList<>(5);
		
		AbstractSortAlgorithm instanceSorting;
		//Bubblesort
		for (int i = 0; i < 5; i++) 
		{
			instanceSorting = new EnhancedBubbledSort(Constants.SIZEARRAY_LARGE, false);
			double timeSort = (instanceSorting.sortArray()/1000000.0d);
			timeRound.add(timeSort);
		}
		
		for (int i = 0; i < timeRound.size(); i++)
			System.out.println("Time for round " + (i+1) + ": " + timeRound.get(i) + " miliseconds");
		
		double averageTime = 0;
		for (int i = 0; i < timeRound.size(); i++)
			averageTime += timeRound.get(i);
		averageTime /= timeRound.size();
		System.out.println("Average time is:" + averageTime);
		
		System.out.println("**********************************************");
		*/
		//Shellsort
		//instanceSorting = new EnhancedShellSort(Constants.SIZEARRAY_XL_LARGE, false);
		//System.out.println("Time for sorting: " + (instanceSorting.sortArray()/1000000.0d) + " milliseconds");
		
		System.out.println("**********************************************");
		
	}
	
	private static void printStatsRunningAlgo() 
	{
		System.out.println("QUICKSORT - MERGESORT - HEAPSORT - SHELLSORT - INSERTIONSORT - SELECTIONSORT - BUBBLESORT");
		System.out.println("Total Elements in array: " + Constants.SIZEARRAY);
		System.out.println();
	}
	
	private static void runAlgorithmsSequentiallyIntArray(String[] args)
	{
		System.out.println("All algorithms running sequentially - 7 in total");
		printStatsRunningAlgo() ;
		
		//QUICKSORT		
		QuickSort.main(args);
		System.out.println( "----------------------------------------------------------------------");
		System.out.println();
		
		//MERGESORT
		MergeSort.main(args);
		System.out.println( "----------------------------------------------------------------------");
		System.out.println();
		  
		//HEAPSORT
		HeapSort.main(args);
		System.out.println( "----------------------------------------------------------------------");
		System.out.println();						 													
		
		//SHELLSORT
		ShellSort.main(args);
		System.out.println( "----------------------------------------------------------------------");
		System.out.println();
		
		//INSERTIONSORT
		InsertionSort.main(args);
		System.out.println( "----------------------------------------------------------------------"); 
		System.out.println();
		
		//SELECTIONSORT		
		SelectionSort.main(args);
		System.out.println( "----------------------------------------------------------------------");
		System.out.println();
		
		//BUBBLESORT  
		Bubblesort.main(args);
		System.out.println("----------------------------------------------------------------------");
		System.out.println();
				
		System.out.println("Program finished!!!!");
	}
	
	private static void runAlgorithmsInThreadsIntArray(String[] args)
	{
		System.out.println("All algorithms running in seperate threads - 7 in total");
		printStatsRunningAlgo() ;
		new Thread(() -> 
		{						
			QuickSort.main(args);
			System.out.println( "----------------------------------------------------------------------");
			System.out.println();
		}).start();
		
		new Thread(() -> 
		{
			MergeSort.main(args);
			System.out.println( "----------------------------------------------------------------------");
			System.out.println();
		}).start();
		
		new Thread(() -> 
		{						
			HeapSort.main(args);
			System.out.println( "----------------------------------------------------------------------");
			System.out.println();
		}).start();
		
		new Thread(() -> 
		{						
			ShellSort.main(args);
			System.out.println( "----------------------------------------------------------------------");
			System.out.println();
		}).start();
		
		new Thread(() -> 
		{						
			InsertionSort.main(args);
			System.out.println( "----------------------------------------------------------------------");
			System.out.println();
		}).start();
		
		new Thread(() -> 
		{						
			SelectionSort.main(args);
			System.out.println( "----------------------------------------------------------------------");
			System.out.println();
		}).start();
		
		new Thread(() -> 
		{						
			Bubblesort.main(args);
			System.out.println( "----------------------------------------------------------------------");
			System.out.println();
		}).start();	
		
		//Maybe better join all thread ????
	}
}
