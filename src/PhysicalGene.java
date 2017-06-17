
public enum PhysicalGene implements GeneType {
	//physical 8
		Agility(1),
		HP(2),
		Defense(3),
		Attack(4),
		Looks(5),
		Speed(6),
		Endurance(7),
		Strength(8),
		Junk(0);
		
	private int ID;
	private PhysicalGene(int ID){
		this.ID = ID;
	}
	
	public int getID(){
		return ID;
	}
}
