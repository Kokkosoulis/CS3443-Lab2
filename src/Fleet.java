//Alexander Kokkosoulis
//ots068
//COSC 3443-1
//[[date]]

//change ships array to arraylist
// add loadStarships and loadCrew methods
// create object from either type and add them to the fleet
// "loadStarships(..) and loadCrew(..). Both methods will take in a file name and throw an IOException. These object methods will load the data in the given file into the appropriate objects (starships are added to the fleet, and crew members are added to starships). "
//create reassign method, takes crewmember name and starship registry and removes the crewmember from their current ship and adds them to the specified one
//create save method which overwrites proviededfiles with current info in the same format as provided

import java.util.*;

public class Fleet {
	private String name;
	private ArrayList<Starship> ships = new ArrayList<Starship>();
	public Fleet(){
		setName("");
	}
	public Fleet(String n){
		setName(n);
	}
	public void setName(String n){
		name = n;
	}
	public String getName(){
		return name;
	}
	public void addStarship(Starship s){
		ships.add(s);
	}
	public void loadStarships(String f){
		
	}
	public void loadCrew(String f) {
		
	}
	public void reassign(String n,String r) {
		CrewMember c;
		for (int i = 0; i<ships.size();i++) {
			//ships[i].removeCrewMember(n);
		}
		for (int i = 0; i<ships.size();i++) {
			if (ships.get(i).getRegistry().equals(r)) {
				ships.get(i).addCrewMember(c);
			}
		}
		//for loop ship arraylist .size
		// ship[i].removecrewmember c
		//for ship.size
		//	if ship[i].getregistry =r
		//		ship[i].addcrewmemberc
	}
	public void save() {
		
	}
	public String toString(){
		String t = "------------------------------------------------------- \n" + name + "\n-------------------------------------------------------\n\n";
		for (int i = 0;i < ships.size(); i++){
			t = t + ships.get(i).toString() + "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - -\n";
		}
		return t;
	}
}