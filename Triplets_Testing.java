package Test;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class Triplets_Testing {
	
	    public static int  printTriplet(int[] arr, int sum) {
	    	
	    	int flag=0;//dummy variable.
	    	
	    //Arrays are sorted in ascending order
	    Arrays.sort(arr);
	    
	    //hashing is used which is reducing the complexity of the program
	    Set<Integer> hashSet = new HashSet<>();
	    
	    
	    //length of the array
	    int n = arr.length;
	    
	    //loop to insert all the values in the hashSet(hashed array)
	    for(int i = 0; i < n; i++) {
	        hashSet.add(arr[i]);
	    }
	    
	    //initializing the variable
	    int left = 0, right = n-1, reqSum = 0;
	    
	    
	    while(left < right)
	    {
	       
	    	//Here the total sum is sutracted from the first and the last index and then this reqSum is
	    	//then checked if this left sum is present anywhere in thea array and if present then we got the third value
	    	//else it will keep traversing the loop.
	    	   reqSum = sum - (arr[left]+arr[right]);
	        
	        //checking the basic conditions
	        if(hashSet.contains(reqSum) 
	                && (reqSum != arr[left]
	                && reqSum != arr[right]
	                && arr[left]!=0 
	                && arr[right]!=0
	                && reqSum!=0))
	        	{
	        	 
	        	//if it satisfies all the condition then we print all the three values and get out of the loop.
	        		System.out.println("The three numbers are found");
	        		System.out.println(arr[left] + " " + arr[right] + " " + reqSum);
	        		flag=1;
	        		return 1;
	        	}
	        
	        if(arr[left]+arr[right] < sum) 
	        {
	        	left++;
	        } 
	        
	       else
	       {
	            right--;
	        }
	     }//while loop closed
	    
	    if(flag==0)
	    	{
	    	System.out.println("Sorry there are no 3 values available");
	    	
	    	//here 0 is returned showing the sum is not found
	    	return 0;
	    	}
	  //here 1 is returned showing the sum is  found
	    return 1;
	   

	       
	 }//method ends here

	   // private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	    	
	    	//Scanner  class to take the input.
	    	
	       Scanner sc= new Scanner(System.in);
	       
	       //the array is initialized with the range 50.
	       
	        int ar[] =new int[50];
	        
	        //Number of inputs
	        System.out.println("Enter the number of terms");
	        int n =sc.nextInt();
	        
	        System.out.println("Enter the values");
	        for(int i=0;i<n;i++)
	        {
	            int value = sc.nextInt();
	            ar[i] = value;
	        }
	        int sum;
	        
	        //total sum required
	        System.out.println("Enter the Sum required");
	        sum = sc.nextInt();
	        System.out.println(printTriplet(ar,sum));
	            
	    }
	}

//************OUTPUTS ***********\\ 
/*
*
Enter the number of terms
5
Enter the values
10 13 23 50 11
Enter the Sum required
73
The three numbers are found
10 50 13
1


Enter the number of terms
6
Enter the values
11 13 24 10 16 13
Enter the Sum required
38
Sorry there are no 3 values available
0*/
