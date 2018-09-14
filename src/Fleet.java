//Alexander Kokkosoulis
//ots068
//COSC 3443-1
//9/13/18

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
	public void loadStarships(String f) throws IOException {
		File file = new File(f);
		Scanner scan = new Scanner(file);
		scan.useDelimiter(",|\\n");
		Starship s;
		while(scan.hasNext()) {
			s = new Starship();
			s.setName(scan.next());
			s.setRegistry(scan.next());
			s.setKlass(scan.next());
			ships.add(s);
		}
		scan.close();
	}
	public void loadCrew(String f) throws IOException  {
		File file = new File(f);
		Scanner scan = new Scanner(file);
		scan.useDelimiter(",|\\n");
		CrewMember c;
		String s;
		while(scan.hasNext()) {
			c = new CrewMember();
			c.setName(scan.next());
			c.setPosition(scan.next());
			c.setRank(scan.next());
			s = scan.next();
			c.setSpecies(scan.next());
			for (int i=0;i<ships.size();i++) {
				if (ships.get(i).getRegistry().equals(s)) {
					ships.get(i).addCrewMember(c);
				}
			}
		}
		scan.close();
	}
	public void reassign(String n,String r) {
		CrewMember c = new CrewMember();
		for (int i=0;i<ships.size();i++) {
			for (int j=0;j<ships.get(i).getCrewSize();j++) {
				if (n.equals(ships.get(i).getCrewMember(j).getName())) {
					c = ships.get(i).getCrewMember(j);
				}
			}
		}
		for (int i = 0; i<ships.size();i++) {
			ships.get(i).removeCrewMember(c);
		}
		for (int i = 0; i<ships.size();i++) {
			if (ships.get(i).getRegistry().equals(r)) {
				ships.get(i).addCrewMember(c);
			}
		}
	}
	public void save() throws IOException {
		String s = "";
		String c = "";
		for (int i=0;i<ships.size();i++) {
			s = s + ships.get(i).getName() + ',' + ships.get(i).getRegistry() + ',' + ships.get(i).getKlass() + "\n";
			for (int j=0;j<ships.get(i).getCrewSize();j++) {
				c = c + ships.get(i).getCrewMember(j).getName() + ',' + ships.get(i).getCrewMember(j).getPosition() + ',' + ships.get(i).getCrewMember(j).getRank() + ',' + ships.get(i).getRegistry() + ',' + ships.get(i).getCrewMember(j).getSpecies() + "\n"; 
			}
		}
		FileWriter fleet = new FileWriter( "data/fleet.csv" );
		fleet.write(s);
		fleet.close();
		FileWriter personnel = new FileWriter("data/personnel.csv" );
		personnel.write(c);
		personnel.close();
		//create a uml diagram (10pts)
		//create a javadoc (10pts)
		
		//create save method which overwrites provieded
		//files with current info in the same format as provided
		
	}
	public String toString(){
		String t = "------------------------------------------------------- \n" + name + "\n-------------------------------------------------------\n\n";
		for (int i = 0;i < ships.size(); i++){
			t = t + ships.get(i).toString() + "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - -\n";
		}
		return t;
	}
}