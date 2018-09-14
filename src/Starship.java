//COSC 3443-1
//9/13/18
import java.util.*;

/**
 * Starship represents an individual ship, inhabited by CrewMembers 
 * 
 * @author Alexander Kokkosoulis (ots068)
 */
public class Starship {
	private String name;
	private String registry;
	private String klass;
	private ArrayList<CrewMember> crew = new ArrayList<CrewMember>();
	/**
	 * Default Constructor for Starship, sets all string variables to ""
	 */
	public Starship(){
		setName("");
		setRegistry("");
		setKlass("");
	}
	/**
	 * Overloaded constructor for Starship, sets name, registry and class based on input
	 * @param n value to set Starship name to
	 * @param r value to set Starship registry to
	 * @param c value to set Starship class to
	 */
	public Starship(String n, String r, String c){
		setName(n);
		setRegistry(r);
		setKlass(c);
	}
	/**
	 * Sets the name of the Starship
	 * @param n value to set Starship name to
	 */
	public void setName(String n){
		name = n;
	}
	/**
	 * Sets the registry of the Starship
	 * @param r value to set Starship registry to
	 */
	public void setRegistry(String r){
		registry = r;
	}
	/**
	 * sets the class of the Starship
	 * @param c value to set Starship class to
	 */
	public void setKlass(String c){
		klass = c;
	}
	/**
	 * returns the name of the Starship
	 * @return String name of Starship
	 */
	public String getName(){
		return name;
	}
	/**
	 * returns the registry of the Starship
	 * @return String registry of the Starship
	 */
	public String getRegistry(){
		return registry;
	}
	/**
	 * returns the class of the Starship
	 * @return String class of the Starship
	 */
	public String getKlass(){
		return klass;
	}
	/**
	 * adds one CrewMember to the crew ArrayList
	 * @param c CrewMember to add to crew
	 */
	public void addCrewMember(CrewMember c){
		crew.add(c);
	}
	/**
	 * Removes one CrewMember from the crew ArrayList
	 * @param c CrewMember to remove from crew
	 */
	public void removeCrewMember(CrewMember c) {
		for (int i=0;i<crew.size();i++) {
			if (crew.get(i).toString().equals(c.toString()));
		}
	}
	/**
	 * returns a CrewMember based on position in the crew ArrayList
	 * @param i position in the crew Arraylist
	 * @return CrewMember at specified position
	 */
	public CrewMember getCrewMember(int i) {
		return crew.get(i);
	}
	/**
	 * returns the total number of CrewMembers in the crew ArrayList
	 * @return int number of CrewMembers
	 */
	public int getCrewSize() {
		return crew.size();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String t = name +" ("+ registry + ")\n\n[Class: " + klass + "]\n";
		for (int i = 0;i < crew.size(); i++){
			t = t + crew.get(i).toString() + "\n";
		}
		return t;
	}
}