
public class GeneRung 
{
	private GeneBase _baseOne;
	private GeneBase _baseTwo;
	
	public GeneRung(GeneBase baseOne, GeneBase baseTwo)
	{
		_baseOne = baseOne;
		_baseTwo = baseTwo;
	}
	
	public GeneBase getBaseOne()
	{
		return _baseOne;
	}
	
	public GeneBase getBaseTwo()
	{
		return _baseTwo;
	}
}
