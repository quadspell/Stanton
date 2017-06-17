
public enum MindGene implements GeneType {
	//mind 6
	Intelligence(9),
	Charisma(10),
	Memory(11),
	Perception(12),
	Reflex(13),
	Empathy(14),
	Junk(0);
	
	private int ID;
	private MindGene(int ID){
		this.ID = ID;
	}
	
	public int getID(){
		return ID;
	}
}
