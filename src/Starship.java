//Alexander Kokkosoulis
//ots068
//COSC 3443-1
//[[date]]

import java.util.*;

public class Starship {
	private String name;
	private String registry;
	private String klass;
	private ArrayList<CrewMember> crew = new ArrayList<CrewMember>();
	public Starship(){
		setName("");
		setRegistry("");
		setKlass("");
	}
	public Starship(String n, String r, String c){
		setName(n);
		setRegistry(r);
		setKlass(c);
	}
	public void setName(String n){
		name = n;
	}
	public void setRegistry(String r){
		registry = r;
	}
	public void setKlass(String c){
		klass = c;
	}
	public String getName(){
		return name;
	}
	public String getRegistry(){
		return registry;
	}
	public String getKlass(){
		return klass;
	}
	public void addCrewMember(CrewMember c){
		crew.add(c);
	}
	public void removeCrewMember(CrewMember c) {
		for (int i=0;i<crew.size();i++) {
			if (crew.get(i).toString().equals(c.toString()));
		}
	}
	public CrewMember getCrewMember(int i) {
		return crew.get(i);
	}
	public String toString(){
		String t = name +" ("+ registry + ")\n\n[Class: " + klass + "]\n";
		for (int i = 0;i < crew.size(); i++){
			t = t + crew.get(i).toString() + "\n";
		}
		return t;
	}
}