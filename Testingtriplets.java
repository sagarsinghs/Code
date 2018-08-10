package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import testing.JunitTesting;

class Testingtriplets {

	@Test
	void test() {
		
		Triplets_Testing test = new Triplets_Testing();
		
		int ar[]= {2,4,11,1,4};
		int sum =11;
		 System.out.println("The output for the 1st test case is ");
		int output =test.printTriplet(ar,sum);
		assertEquals(1,output);
		
		
		
	}

}
//OUTPUTS

/*
ar ={6,3,4,5,1};
The output for the 1st test case is 
The three numbers are found
2 5 4


ar[]= {2,4,11,1,4};
The output for the 1st test case is 
Sorry there are no 3 values available
*/