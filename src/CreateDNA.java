import java.util.Locale;
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

		GeneBase fatherOne, fatherTwo, motherOne, motherTwo;

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
				fatherOne = father.getChromosomes(j).getRungs(i).getBaseOne();
				fatherTwo = father.getChromosomes(j).getRungs(i).getBaseTwo();
				motherOne = mother.getChromosomes(j).getRungs(i).getBaseOne();
				motherTwo = mother.getChromosomes(j).getRungs(i).getBaseTwo();

				if((fatherOne == motherOne && fatherTwo == motherTwo) || (fatherOne == motherTwo && fatherTwo == motherOne)){
					rungs[i] = helper(fatherOne, fatherTwo, motherOne, motherTwo);
				}else{
					rungs[i] = helper(fatherOne, fatherTwo, motherOne, motherTwo);
				}
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

	private static GeneRung helper(GeneBase fatherOne, GeneBase fatherTwo, GeneBase motherOne, GeneBase motherTwo){
		GeneBase toAddOne, toAddTwo;
		int result = rand.nextInt(200);
		if(result < 100)
			toAddOne = fatherOne;
		else if(result < 199)
			toAddOne = motherOne;
		else
			toAddOne = new GeneBase(GeneCatagory.Magic, MagicGene.Junk);

		result = rand.nextInt(200);
		if(result < 100)
			toAddTwo = fatherTwo;
		else if(result < 199)
			toAddTwo = motherTwo;
		else
			toAddTwo = new GeneBase(GeneCatagory.Magic, MagicGene.Junk);

		return new GeneRung(toAddOne, toAddTwo);
	}
}
