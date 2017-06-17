
public enum MagicGene implements GeneType {
	//magic 7
	Fire(15),
	Water(16),
	Earth(17),
	Air(18),
	Mana(19),
	Divine(20),
	Life(21),
	Junk(0);
	
	private int ID;
	private MagicGene(int ID){
		this.ID = ID;
	}
	
	public int getID(){
		return ID;
	}
}
