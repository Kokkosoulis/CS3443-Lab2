//COSC 3443-1
//9/13/18
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Fleet represents a unique conglomerate of ships 
 * 
 * @author Alexander Kokkosoulis (ots068)
 */
public class Fleet {
	private String name;
	private ArrayList<Starship> ships = new ArrayList<Starship>();
	
	/**
	 * Default Constructor for Fleet, sets name to ""
	 */
	public Fleet(){
		setName("");
	}
	/**
	 * Overloaded Constructor for Fleet, sets name to n
	 * @param n Name to set for the Fleet
	 */
	public Fleet(String n){
		setName(n);
	}
	/**
	 * sets the name of the Fleet
	 * @param n Name to set for the Fleet
	 */
	public void setName(String n){
		name = n;
	}
	/**
	 * Returns the name of the Fleet
	 * @return String name of the Fleet
	 */
	public String getName(){
		return name;
	}
	/**
	 * adds one starship to the ships array
	 * @param s Starship to add to ships
	 */
	public void addStarship(Starship s){
		ships.add(s);
	}
	/**
	 * reads the contents of a file and saves them to a the fleet as Starships
	 * @param f location of file to be read in
	 * @throws IOException in the case of the file being unopenable
	 */
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
	/**
	 * reads the contents of a file and saves them to a the fleet as CrewMembers on specified Starships
	 * @param f location of file to be read in
	 * @throws IOException in the case of the file being unopenable
	 */
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
	/**
	 * assigns a CrewMember found by name to a starship found by registry
	 * @param n name of CrewMember to be reassigned
	 * @param r registry of ship to be assigned to
	 */
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
	/**
	 * saves the contents of the fleet to two files
	 * @throws IOException in the case that either of the two destination files dont exist
	 */
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
		
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String t = "------------------------------------------------------- \n" + name + "\n-------------------------------------------------------\n\n";
		for (int i = 0;i < ships.size(); i++){
			t = t + ships.get(i).toString() + "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - -\n";
		}
		return t;
	}
}