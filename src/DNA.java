
public class DNA 
{
	private Chromosome _chromosomes[];
	private int _numChromosomes;
	
	public DNA(int numChromosomes, Chromosome chromosomes[])
	{
		_chromosomes = chromosomes.clone();
		_numChromosomes = numChromosomes;
	}
	
	public Chromosome getChromosomes(int number)
	{
		return _chromosomes[number];
	}
	
	public Chromosome[] getChromosomes()
	{
		return _chromosomes;
	}
	
	public int getNumChromosomes()
	{
		return _numChromosomes;
	}
	
	public void printCountsTotals(){
		int phyMod = MagicGene.values().length;
		int mindMod = phyMod + PhysicalGene.values().length;
		int numTypes = mindMod + MindGene.values().length;
		int[] ans = new int[numTypes - 2];
		int i;
		
		for(Chromosome chrom : _chromosomes){
			int[] counts = chrom.getCounts();
			for(i = 0; i < numTypes - 2; i++){
				ans[i] += counts[i];
			}
		}
		int total = _numChromosomes * _chromosomes[0].getNumRungs() * 2;
		System.out.println("Total GeneBases = " + total);
		for(i = 0; i < numTypes - 2; i++){
			printHelper(i);
			System.out.println(ans[i]);
		}
	}
	
	public void printLayout(boolean deep){
		if(deep){ 
			for(int i = 1; i <= _numChromosomes; i++){
				System.out.println();
				System.out.println("CHROMOSOME " + i);
				_chromosomes[i-1].printLayout();
			}
		}else{
			for(Chromosome chrom : _chromosomes){
				chrom.getCounts();
			}//TODO add and print counts
		}
	}
	
	public void printHelper(int i){
		if(i == 0){
			System.out.print("Trash: ");
		}else if(i < 9){
			System.out.print(PhysicalGene.values()[i - 1] + ": ");
		}
		else if(i < 15){
			System.out.print(MindGene.values()[i - 9] + ": ");
		}else{
			System.out.print(MagicGene.values()[i - 15] + ": ");
		}
	}
}
