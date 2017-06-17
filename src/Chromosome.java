
public class Chromosome 
{
	private GeneRung _geneRungs[];
	private int _numRungs;
	
	public Chromosome(int numRungs, GeneRung geneRungs[])
	{
		_geneRungs = geneRungs.clone();
		_numRungs = numRungs;
	}
	
	public GeneRung getRungs(int number)
	{
		return _geneRungs[number];
	}
	
	public GeneRung[] getRungs()
	{
		return _geneRungs;
	}
	
	public int getNumRungs()
	{
		return _numRungs;
	}
	
	public int[] getCounts(){
		int phyMod = MagicGene.values().length;
		int mindMod = phyMod + PhysicalGene.values().length;
		int numTypes = mindMod + MindGene.values().length;
		int[] ans = new int[numTypes - 2];
		for(GeneRung rung : _geneRungs){
			if(rung.getBaseOne().getCatagory() != GeneCatagory.Recessive)
				ans[rung.getBaseOne().getType().getID()]++;
			if(rung.getBaseTwo().getCatagory() != GeneCatagory.Recessive)
				ans[rung.getBaseTwo().getType().getID()]++;
		}
		
		return ans;
	}
	
	public void printLayout(){
		for(GeneRung rung : _geneRungs){
			System.out.println(rung.getBaseOne().getType() + " " + rung.getBaseTwo().getType());
		}
	}
	
	public int helper(GeneType type){
		return 0;
	}
	
}
