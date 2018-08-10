import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCases {

	@Test
	void test() {
		JsonParser parser = new JsonParser();
		
		//testing for the conversion of the latitude and longitude to the Radians.
		Double  latitude = 13.2411022;
		Double longitude =  78.27699;

		Double latitude_radians  =parser.converting_lat_toRadians(latitude);
		Double longitude_radians = parser.converting_lat_toRadians(longitude);
		
		assertEquals(0.2311008299830647,latitude_radians);//gives correct output
		assertEquals(1.36549851,longitude_radians);//gives correct output
		
		//2nd case for the negative output
		
		Double  latitude = 13.2411022;
		Double longitude =  78.27699;

		Double latitude_radians  =parser.converting_lat_toRadians(latitude);
		Double longitude_radians = parser.converting_lat_toRadians(longitude);
		
		assertEquals(0.2811008299,latitude_radians);//gives wrong output
		assertEquals(1.16549851,longitude_radians);//gives wrong output
		
		
		//The test case for  calculating the distance
		double lat1 =13.1229599 ;
		double lat2 = 13.008769;
		double  difference_lat=0.1141909;
		double  lon1= 77.2701202;
		double  lon2=77.1056711 ;
		double  difference_lon=0.1644491;
	double ss = parser. calculation_of_the_distance(0.1141909,13.1229599 ,13.008769,0.1644491);
	
	assertEquals(1171.726349188513,ss);//gives the correct output and hence positive case.
	assertEquals(111.726349188513,ss);//gives the wrong output and hence negative case.
	

	
	}

}
