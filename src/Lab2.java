//Alexander Kokkosoulis
//ots068
//COSC 3443-1
//9/13/18

import java.io.IOException;

public class Lab2 {	
  	public static void main( String[] args ) {	
     	Fleet federation = new Fleet( "United Federation of Planets" );	

     	try{	

        	federation.loadStarships( "data/fleet.csv" );	
        	federation.loadCrew( "data/personnel.csv" );
     	}catch( IOException e ){	
        	System.out.println( "Error loading the file - please check its location." );	
        	e.printStackTrace();	
     	}	
     	System.out.println( federation );	
  	}	
}	