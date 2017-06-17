import java.util.Random;

public class DNA_Test {
	public static void main(String[] args){
		Random rand = new Random();
		System.out.println("Starting");
		DNA test = CreateDNA.createFromScratch(46, 100);
		DNA test2 = CreateDNA.createPure(46, 100, MagicGene.Fire);
		DNA child;
		//test.printLayout(true);
		System.out.println("Mother:");
		test.printCountsTotals();
		System.out.println();
		System.out.println("Father: ");
		test2.printCountsTotals();
		
		child = CreateDNA.createChild(test, test2);
		
		for(int i = 0; i < 1; i++){
			child = CreateDNA.createChild(test, child);
		}
		
		System.out.println();
		System.out.println("Inbreeds: ");
		child.printCountsTotals();
		System.out.println();
		//System.out.println("Inbreed2: ");
		//test2.printCountsTotals();
		
		System.out.println("Done");
		
		
	}
}
