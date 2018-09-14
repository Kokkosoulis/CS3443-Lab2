//COSC 3443-1
//9/13/18

/**
 * CrewMember represents an individual consisting of a name, position, rank, and species
 * 
 * @author Alexander Kokkosoulis (ots068)
 */
public class CrewMember {
	private String name;
	private String position;
	private String rank;
	private String species;
	/**
	 * Default Constructor for CrewMember, Sets name, position, rank, and species to ""
	 */
	public CrewMember(){
		setName("");
		setPosition("");
		setRank("");
		setSpecies("");
	}
	/**
	 * Overloaded Constructor for CrewMember, Sets name, position, rank, and species to inputs provided
	 * @param n value to set name to
	 * @param p value to set position to
	 * @param r value to set rank to
	 * @param s value to set species to
	 */
	public CrewMember(String n, String p,String r,String s){
		setName(n);
		setPosition(p);
		setRank(r);
		setSpecies(s);
	}
	/**
	 * Sets CrewMember's name
	 * @param n Value to set name to
	 */
	public void setName(String n){
		name = n;
	}
	/**
	 * Sets CrewMember's position
	 * @param p Value to set position to
	 */
	public void setPosition(String p){
		position = p;
	}
	/**
	 * Sets CrewMember's rank
	 * @param r Value to set rank to
	 */
	public void setRank(String r){
		rank = r;
	}
	/**
	 * Sets CrewMember's Species
	 * @param s Value to set species to
	 */
	public void setSpecies(String s){
		species = s;
	}
	/**
	 * Returns CrewMember's Name
	 * @return name of CrewMember
	 */
	public String getName(){
		return name;
	}
	/**
	 * Returns CrewMember's position
	 * @return position of CrewMember
	 */
	public String getPosition(){
		return position;
	}
	/**
	 * Returns CrewMember's Rank
	 * @return rank of CrewMember
	 */
	public String getRank(){
		return rank;
	}
	/**
	 * Returns CrewMember's Species
	 * @return species of CrewMember
	 */
	public String getSpecies(){
		return species;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "- " + position + " "+ name + ", "+ rank + " ("+species+")";
	}
}