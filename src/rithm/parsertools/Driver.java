package rithm.parsertools;

public class Driver {
	public static void main(String args[])
	{
		LTLParser ltlParser = new LTLParser("LTL");
		ltlParser.AppendSpec("a-><>b");
		ltlParser.AppendSpec("c-><>d");
		for(String pred: ltlParser.getPredsForSpec("a-><>b"))
			System.out.println(pred);
		for(String pred: ltlParser.getPredsForSpec("c-><>d"))
			System.out.println(pred);
	}
}
