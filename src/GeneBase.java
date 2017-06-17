import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GeneBase {
	private GeneType type;
	private GeneCatagory catagory;
	

		
		
		private static Random rand = new Random(System.currentTimeMillis());;
		
		public GeneBase(GeneCatagory catagory, GeneType type)
		{
			this.catagory = catagory;
			this.type = type;
		}
		
		public GeneBase(){
			setCatagory();
			setType();
		}
		
		public GeneType getType(){
			return type;
		}
		
		public GeneCatagory getCatagory(){
			return catagory;
		}
		
		public void setType(GeneType newType, boolean recessive){
			if(recessive)
				catagory = GeneCatagory.Recessive;
			else if(newType instanceof MagicGene)
				catagory = GeneCatagory.Magic;
			else if(newType instanceof PhysicalGene)
				catagory = GeneCatagory.Physical;
			else if(newType instanceof MindGene)
				catagory = GeneCatagory.Mind;	
			type = newType;
		}
		
		public void setType(){
			if(catagory == GeneCatagory.Magic)
				type = MagicGene.values()[rand.nextInt(MagicGene.values().length)];
			else if(catagory == GeneCatagory.Physical)
				type = PhysicalGene.values()[rand.nextInt(PhysicalGene.values().length)];
			else if(catagory == GeneCatagory.Mind)
				type = MindGene.values()[rand.nextInt(MindGene.values().length)];
			else{
				switch(rand.nextInt(3)){
				case 0:
					type = MagicGene.values()[rand.nextInt(MagicGene.values().length - 1)];
					break;
				case 1:
					type = PhysicalGene.values()[rand.nextInt(PhysicalGene.values().length - 1)];
					break;
				case 2:
					type = MindGene.values()[rand.nextInt(MindGene.values().length - 1)];
					break;
				default:
					type = MagicGene.values()[rand.nextInt(MagicGene.values().length - 1)];
				}
			}
		}
		
		public void setCatagory(){
			catagory = GeneCatagory.values()[rand.nextInt(GeneCatagory.values().length)];
		}
}
