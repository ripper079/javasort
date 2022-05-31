package danieloikarainen.se;

public class Constants 
{
	//Used for how many elements in array
    public static final int SIZEARRAY = 300000;//On my computer it takes almost 3 minutes, careful when changing this value 
    
    public static final int SIZEARRAY_SMALL = 100;
    public static final int SIZEARRAY_MEDIUM = 1000;
    public static final int SIZEARRAY_LARGE = 10000;
    public static final int SIZEARRAY_XL_LARGE = 100000;
    
    //Used to populate the array with random values
    //DON'T make MIN_INT_VALUE => MAX_INT_VALUE
    public static final int MIN_INT_VALUE = 5;
    public static final int MAX_INT_VALUE = 5000000;
}
