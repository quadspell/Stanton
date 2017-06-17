import java.util.Random;

public class DNA_Test {
	public static void main(String[] args){
		Random rand = new Random();
		System.out.println("Starting");
		DNA test = CreateDNA.createFromScratch(46, 100);
		DNA test2 = CreateDNA.createFromScratch(46, 100);
		DNA child;
		//test.printLayout(true);
		System.out.println("Mother:");
		test.printCountsTotals();
		System.out.println();
		System.out.println("Father: ");
		test2.printCountsTotals();

		for(int i = 0; i < 200; i++){
			child = CreateDNA.createChild(test, test2);
			test2 = CreateDNA.createChild(test, test2);
			test = child;
		}

		System.out.println();
		System.out.println("Inbreeds: ");
		test.printCountsTotals();

		test2 = CreateDNA.createFromScratch(46, 100);
		test = CreateDNA.createChild(test, test2);
		
		System.out.println();
		System.out.println("Recovery: ");
		test.printCountsTotals();
		//System.out.println();
		//System.out.println("Inbreed2: ");
		//test2.printCountsTotals();
		
		System.out.println("Done");
		
		
	}
}
