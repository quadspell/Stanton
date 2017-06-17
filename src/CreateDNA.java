import java.util.Random;

public class CreateDNA {
	static Random rand = new Random();
	public static DNA createFromScratch(int numChromosome, int rungsPerChrom){
			if(rungsPerChrom < 10)
			{
				System.out.println("Not enough Rungs per Chromosome");
				return null;
			}
			
			Chromosome chroms[] = new Chromosome[numChromosome];
			for(int j = 0; j < numChromosome; j++)
			{
				
				GeneRung rungs[] = new GeneRung[rungsPerChrom];
				
				for(int i = 0; i < rungsPerChrom; i++)
				{
					
					rungs[i] = new GeneRung(new GeneBase(), new GeneBase());
				}
				chroms[j] = new Chromosome(rungsPerChrom, rungs);
			}
			
			return new DNA(numChromosome, chroms);
	}
	
	public static DNA createChild(DNA mother, DNA father){
		int diffChrom = mother.getNumChromosomes() - father.getNumChromosomes();
		int baseChrom = mother.getNumChromosomes() + diffChrom;
		
		int diffRungs = mother.getChromosomes(0).getNumRungs() - father.getChromosomes(0).getNumRungs();
		int baseRungs = mother.getChromosomes(0).getNumRungs() + diffRungs;
		
		int result;
		GeneBase toAddOne;
		GeneBase toAddTwo;
		
		int numChrom;
		int numRungs;
		if(diffChrom != 0)
			numChrom = baseChrom + rand.nextInt(Math.abs(diffChrom));
		else
			numChrom = baseChrom;
		if(diffRungs != 0)
			numRungs = baseRungs + rand.nextInt(Math.abs(diffRungs));
		else
			numRungs = baseRungs;
		
		Chromosome chroms[] = new Chromosome[numChrom];
		
		
		for(int j = 0; j < numChrom; j++){
			GeneRung rungs[] = new GeneRung[numRungs];
			for(int i = 0; i < numRungs; i++){
				
				result = rand.nextInt(100);
				if(result < 50)
					toAddOne = father.getChromosomes(j).getRungs(i).getBaseOne();
				else if(result < 100)
					toAddOne = mother.getChromosomes(j).getRungs(i).getBaseOne();
				else
					toAddOne = new GeneBase();
				
				result = rand.nextInt(100);
				if(result < 33)
					toAddTwo = father.getChromosomes(j).getRungs(i).getBaseTwo();
				else if(result < 66)
					toAddTwo = mother.getChromosomes(j).getRungs(i).getBaseTwo();
				else
					toAddTwo = new GeneBase();
				
				rungs[i] = new GeneRung(toAddOne, toAddTwo);
			}
			chroms[j] = new Chromosome(numRungs, rungs);
		}
		
		return new DNA(numChrom, chroms);
	}
	
	public static DNA createPure(int numChrom, int rungsPerChrom, GeneType type){
		if(rungsPerChrom < 10)
		{
			System.out.println("Not enough Rungs per Chromosome");
			return null;
		}
		
		Chromosome chroms[] = new Chromosome[numChrom];
		for(int j = 0; j < numChrom; j++)
		{
			
			GeneRung rungs[] = new GeneRung[rungsPerChrom];
			
			for(int i = 0; i < rungsPerChrom; i++)
			{
				GeneBase base1 = new GeneBase();
				base1.setType(type, false);
				GeneBase base2 = new GeneBase();
				base2.setType(type, false);
				rungs[i] = new GeneRung(base1, base2);
			}
			chroms[j] = new Chromosome(rungsPerChrom, rungs);
		}
		
		return new DNA(numChrom, chroms);
	}
}
