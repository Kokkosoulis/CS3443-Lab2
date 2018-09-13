//Alexander Kokkosoulis
//ots068
//COSC 3443-1
//[[date]]


public class CrewMember {
	private String name;
	private String position;
	private String rank;
	private String species;
	public CrewMember(){
		setName("");
		setPosition("");
		setRank("");
		setSpecies("");
	}
	public CrewMember(String n, String p,String r,String s){
		setName(n);
		setPosition(p);
		setRank(r);
		setSpecies(s);
	}
	public void setName(String n){
		name = n;
	}
	public void setPosition(String p){
		position = p;
	}
	public void setRank(String r){
		rank = r;
	}
	public void setSpecies(String s){
		species = s;
	}
	public String getName(){
		return name;
	}
	public String getPosition(){
		return position;
	}
	public String getRank(){
		return rank;
	}
	public String getSpecies(){
		return species;
	}
	public String toString(){
		return "- " + position + " "+ name + ", "+ rank + " ("+species+")";
	}
}