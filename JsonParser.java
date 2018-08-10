
import org.json.*;
import org.json.simple.parser.JSONParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;
import java.lang.*;
import java.io.*;



import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;


public class JsonParser {
    
  
    static ArrayList<PersonItem> invited_friends= new ArrayList<PersonItem>();
    static ArrayList<PersonItem> not_invited_friends= new ArrayList<PersonItem>();
    static ArrayList<PersonItem> list1=new ArrayList<PersonItem>();
    static JSONParser parser ;
   
    public static void main(String args[]) {
    	
    	//For parsing the JSON.
         parser = new JSONParser();
         
    
        try{ Objectparsing(); }
        
        catch(Exception e){ e.printStackTrace(); }
        
        //invited_friends
        invited_friends();
        
        //not_invited_friends
        not_invited_friends();
      
    System.out.println("The Friends who are in the range of 100KMS are ");
    
    for(int i=0;i<invited_friends.size();i++)
    {
        
        System.out.print(invited_friends.get(i).name +" ");
        System.out.print(invited_friends.get(i).user_id +" ");
        System.out.print(invited_friends.get(i).latitude +" ");
        System.out.print(invited_friends.get(i).lonitude +" ");
        System.out.println(" ,DISTANCE IS = " + invited_friends.get(i).distance +" ");
        
    }
    
    
    System.out.println("\n\nThe Friends who are  not in the range of 100KMS and are not invited  ");
    for(int i=0;i<not_invited_friends.size();i++)
    {
    
    	System.out.print(not_invited_friends.get(i).name +" ");
    	System.out.print(not_invited_friends.get(i).user_id +" ");
    	System.out.print(not_invited_friends.get(i).latitude +" ");
    	System.out.print(not_invited_friends.get(i).lonitude +" ");
    	System.out.println("  ,DISTANCE IS = " + not_invited_friends.get(i).distance +" ");
    
    }
}//main method ends
    
public static void Objectparsing() throws FileNotFoundException, IOException, ParseException
{
	Object obj = parser.parse(new FileReader("Jsonfile.json"));
    JSONArray jsonObject = (JSONArray) obj;
   
    for(int i =0;i<32;i++)
    {
        JSONObject item = (JSONObject) jsonObject.get(i);
        String name =(String) item.get("name");
        String lat = (String )item.get("latitude");
        String lon = (String)item.get("longitude");
        long id = (long)item.get("user_id");
        
        PersonItem personItem= new PersonItem(name,lat,lon,id);
        list1.add(personItem);
      
    }
    //given latitude and longitude
    Double lat2 =12.9611159;
    Double lon2 =77.6362214;
    
    lat2 =converting_lat_toRadians(lat2);
    lon2 =converting_lon_toRadians(lon2);
    
    
    
    int l = list1.size();
    
    for(int i=0;i<l;i++)
    {
        Double lat1 = getting_latitude(i);
        Double lon1 =getting_longitude(i);
        
        lat1 = converting_lat_toRadians(lat1);
        lon1 =converting_lon_toRadians(lon1);
        
        double difference_lon = lon2 - lon1; 
        double difference_lat = lat2 - lat1;
        
        //using the formula.
        double distance =calculation_of_the_distance( difference_lat, lat1, lat2, difference_lon);
         
         //method which keeps the information of those friends who are invite and are in the range of 100Kms.
        calculating_the_distance(distance,i);
    }
  
}
//calculating the latitude
public  static Double getting_latitude(int i)
	{
 
                //System.out.println(list1.get(i).name);
                String lat = list1.get(i).latitude;
                Double  lat1 = Double.parseDouble(lat);
     return lat1;
	}   

//calculating the longitude    
public static  Double getting_longitude(int i)
	{
                String longi = list1.get(i).lonitude;
                Double  lon1 = Double.parseDouble(longi);
     return lon1;
    
	}

//converting the latitude to radians
public static Double converting_lat_toRadians(Double lat2)
    {
        lat2 = Math.toRadians(lat2);
        
       // System.out.println(lat2);
        
        return lat2;
    }

 //converting the longitude to radians 
public static Double converting_lon_toRadians(Double lon2)
    {
            lon2 = Math.toRadians(lon2);
         return lon2;
    }

//calculating the distance between the latitudes and longitudes using the formula
public static double  calculation_of_the_distance(double difference_lat,double lat1,double lat2,double difference_lon)
{
	 double a = Math.pow(Math.sin(difference_lat / 2), 2) + Math.cos(lat1) * Math.cos(lat2)
             * Math.pow(Math.sin(difference_lon / 2),2);
     
	 double c = 2 * Math.asin(Math.sqrt(a));

	 //Radius of the earth 
	 double radius = 6371;
	 double distance  =radius*c;
 
 return distance;
 
}
//calculating the distance between the given data and the friends location and if less than 100 
// putting the same in different Arraylist to invite them.
public static void calculating_the_distance(Double distance,int i)
	{
	
	
	
     if(distance<=100)
                 {
                         String name =(String)  list1.get(i).name;
                         String lati = (String ) list1.get(i).latitude;
                         String lon = (String) list1.get(i).lonitude;
                         long id = (long) list1.get(i).user_id;
                        
                        PersonItem person =  new PersonItem(name,lati,lon,id,distance);
                        invited_friends.add(person);
                }

     else
                 {
                         String name =(String)  list1.get(i).name;
                         String lati = (String ) list1.get(i).latitude;
                         String lon = (String) list1.get(i).lonitude;
                         long id = (long) list1.get(i).user_id;
                        
                        PersonItem person =  new PersonItem(name,lati,lon,id,distance);
                        not_invited_friends.add(person);
                }
	}

//invited_friends
public static void invited_friends()
{
	  //sorting the PersonItem on the basis of user_id .
    class Sortbyroll implements Comparator<PersonItem>
    {
        public int compare(PersonItem a, PersonItem b)
        {
            return (int) (a.user_id - b.user_id);
        }

    }
    
//sorting  function used here.
Collections.sort(invited_friends, new Sortbyroll());   
}

//not_invited_friends
public static void not_invited_friends()
{
	 class Sortbyroll1 implements Comparator<PersonItem>
	    {
	        public int compare(PersonItem a, PersonItem b)
	        {
	            return (int) (a.user_id - b.user_id);
	        }

	    }
	    
	//sorting  function used here.
	Collections.sort(not_invited_friends, new Sortbyroll1());
}


}//class ends


//output
/*
 The Friends who are in the range of 100KMS are 
Ian 4 13.2411022 77.238335  ,DISTANCE IS = 53.161349697383876 
Nora 5 13.1302756 77.2397222  ,DISTANCE IS = 46.88894185833014 
Theresa 6 13.1229599 77.2701202  ,DISTANCE IS = 43.55066151846466 
Georgina 10 12.240382 77.972413  ,DISTANCE IS = 88.05496818333745 
Richard 11 13.008769 77.1056711  ,DISTANCE IS = 57.72964164658059 
Chris 12 12.986375 77.043701  ,DISTANCE IS = 64.26480291997055 
Michael 15 12.966 77.463  ,DISTANCE IS = 18.77828059115435 
Ian 16 12.366037 78.179118  ,DISTANCE IS = 88.5859736791806 
David 25 12.833502 78.122366  ,DISTANCE IS = 54.57024856881082 
Alan 31 13.1489345 77.8422408  ,DISTANCE IS = 30.56426320779474 
Lisa 39 13.0033946 77.3877505  ,DISTANCE IS = 27.32987841081551 


The Friends who are  not in the range of 100KMS and are not invited  
Alice 1 11.92893 78.27699   ,DISTANCE IS = 134.21516365357343 
Ian 2 11.8856167 78.4240911   ,DISTANCE IS = 147.04189090209707 
Jack 3 12.3191841 78.5072391   ,DISTANCE IS = 118.43223818016337 
Frank 7 13.4692815 -9.436036   ,DISTANCE IS = 9365.223531002577 
Eoin 8 14.0894797 77.18671   ,DISTANCE IS = 134.55072657121264 
Jack 9 12.2559432 76.1048927   ,DISTANCE IS = 183.7396470014124 
Olive 13 13 76   ,DISTANCE IS = 177.34270530574926 
Helen 14 11.999447 -9.742744   ,DISTANCE IS = 9431.96122233646 
Patricia 17 14.180238 -5.920898   ,DISTANCE IS = 8977.543796490403 
Bob 18 12.228056 76.915833   ,DISTANCE IS = 112.94107764995155 
Enid 19 55.033 78.112   ,DISTANCE IS = 4678.36314726356 
Enid 20 13.121111 -9.831111   ,DISTANCE IS = 9415.111135889154 
David 21 11.802 -9.442   ,DISTANCE IS = 9404.59800382023 
Charlie 22 14.374208 78.371639   ,DISTANCE IS = 176.0760647683372 
Eoin 23 14.080556 77.361944   ,DISTANCE IS = 127.95919922148792 
Rose 24 14.133333 77.433333   ,DISTANCE IS = 132.1768775680275 
Stephen 26 13.038056 76.613889   ,DISTANCE IS = 111.09462442885558 
Enid 27 14.1225 78.143333   ,DISTANCE IS = 140.29369783566008 
Charlie 28 13.807778 76.714444   ,DISTANCE IS = 137.13371823622575 
Oliver 29 13.74412 76.11167   ,DISTANCE IS = 186.5074584995188 
Nick 30 13.761389 76.2875   ,DISTANCE IS = 170.9043788302323 
*/
