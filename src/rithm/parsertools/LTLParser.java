package rithm.parsertools;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Hashtable;

import org.antlr.runtime.*;
import org.antlr.v4.codegen.model.SrcOp;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import rithm.core.*;
import rithm.parsertools.ltlgrammarParser.PredContext;
class ltlErrorListener extends BaseErrorListener
{
	Boolean validation_result;
	String error_message;
	public ltlErrorListener()
	{
		super();
		validation_result = true;
		error_message ="";
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex,
			int stopIndex, boolean exact, BitSet ambigAlts,
			ATNConfigSet configs) {
		// TODO Auto-generated method stub
		super.reportAmbiguity(recognizer, dfa, startIndex, stopIndex, exact, ambigAlts,
				configs);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void reportAttemptingFullContext(Parser recognizer, DFA dfa,
			int startIndex, int stopIndex, BitSet conflictingAlts,
			ATNConfigSet configs) {
		// TODO Auto-generated method stub
		super.reportAttemptingFullContext(recognizer, dfa, startIndex, stopIndex,
				conflictingAlts, configs);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void reportContextSensitivity(Parser recognizer, DFA dfa,
			int startIndex, int stopIndex, int prediction,
			ATNConfigSet configs) {
		// TODO Auto-generated method stub
		super.reportContextSensitivity(recognizer, dfa, startIndex, stopIndex,
				prediction, configs);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer,
			Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		// TODO Auto-generated method stub
		validation_result = false;
		super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
		error_message = "line "+line+":"+charPositionInLine+" at "+
				offendingSymbol+": "+msg;
	}
	
}

public class LTLParser extends ParserPlugin
<String, String, ArrayList<Boolean>, ArrayList<String>, ArrayList<String>, HashMap<String, String>>{
	/**
     * The language used by the parser
     * Currently Unused
     */
	private String SpecLang;
	/**
     * Collection of Predicates for the specifications parsed by the parser
     * @see #GetPredicates()
     */
	private HashMap<String, ArrayList<String>> predsForSpec;
	private ArrayList<String> PredicateList;
	/**
     * A Map used to maintain the references between specifications and predicates
     * @see #GetPredicates()
     */
	private HashMap<String, Integer> PredCount;
	
	/**
     * A Map used to maintain the references between specifications and predicates
     * @see #GetSpecs()
     */
	private ArrayList<String> SpecList;
	
	/**
     * A Map used to maitain the references between specifications and predicates
     * @see #ValidateSpecs()
     */
	private ArrayList<Boolean> SpecValidationList;
	private ltlgrammarLexer lexer;
	private ltlgrammarParser parser;
	private HashMap<String, String> ErrorMessages;
	public enum Mode
	{
		insert,
		delete
	}
	public LTLParser(String Lang)
	{
		SpecLang = Lang;
		SpecList  = new ArrayList<String>();
		SpecValidationList = new ArrayList<Boolean>();
		PredicateList = new ArrayList<String>();
		PredCount = new HashMap<String, Integer>();
		ErrorMessages = new HashMap<String, String>();
		predsForSpec = new HashMap<String, ArrayList<String>>();
	}
	class RiTHMltlgrammarListener extends ltlgrammarBaseListener
	{
		int mode;
		String spec;
		public RiTHMltlgrammarListener(int mode, String spec)
		{
			super();
			this.mode = mode;
			this.spec = spec;
		}
		@Override
		public void enterPred(PredContext ctx) {
			// TODO Auto-generated method stub
			super.enterPred(ctx);
//			System.out.println(PredCount.get(ctx.PREDNAME().toString()));
			switch (mode) {
			case 1:
				if(!PredicateList.contains(ctx.PREDNAME().toString()))
				{
					PredicateList.add(ctx.PREDNAME().toString());
				}
				if(PredCount.containsKey(ctx.PREDNAME().toString()))
				{
					PredCount.put(ctx.PREDNAME().toString(), PredCount.get(ctx.PREDNAME().toString())+1);
				}
				else
				{
					PredCount.put(ctx.PREDNAME().toString(), 1);
				}
				if(!predsForSpec.containsKey(spec))
					predsForSpec.put(spec, new ArrayList<String>());
				if(!predsForSpec.get(spec).contains(ctx.PREDNAME().toString()))
					predsForSpec.get(spec).add(ctx.PREDNAME().toString());
				break;
			case 2:
				if(PredCount.get(ctx.PREDNAME().toString()) <= 1)
				{
					PredCount.remove(ctx.PREDNAME().toString());
					PredicateList.remove(ctx.PREDNAME().toString());
//					System.out.println("deleted from PredicateList" + ctx.PREDNAME().toString());
					for (String each_pred: PredicateList)
						System.out.println(each_pred);
				}
				else
				{
					PredCount.put(ctx.PREDNAME().toString(), PredCount.get(ctx.PREDNAME().toString())-1);
				}
				if(predsForSpec.get(spec).contains(ctx.PREDNAME().toString()))
					predsForSpec.get(spec).remove(ctx.PREDNAME().toString());
				break;
			default:
				break;
			}

		}
		
	}

	@Override
	public void set_name(String name) {
		// TODO Auto-generated method stub
		super.set_name(name);
	}
	
	@Override
	public boolean RemoveSpec(String Spec) {
		// TODO Auto-generated method stub
		validate_spec(Spec,2);
		SpecList.remove(Spec);
		return false;
	}
	@Override
	public String get_name() {
		// TODO Auto-generated method stub
		return super.get_name();
	}

	@Override
	public boolean LoadSpecs(String filename){
		// TODO Auto-generated method stub
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader(filename));
			String line = null;

			while((line = br.readLine())!= null)
			{
				SpecList.add(line);
			}
			br.close();
		}
		catch(IOException ie)
		{
			return false;
		}
		ValidateSpecs();
		return true;
	}

	@Override
	public boolean LoadSpecs(ArrayList<String> Specs) {
		// TODO Auto-generated method stub
		this.SpecList.addAll(Specs);
		ValidateSpecs();
		return false;
	}

	@Override 
	public ArrayList<Boolean> ValidateSpecs() {
		// TODO Auto-generated method stub

		for(int i = 0; i < SpecList.size();i++)
		{	
			if(!validate_spec(SpecList.get(i),1))
				SpecList.remove(i);
			
		}
		for(int i = 0; i < SpecList.size();i++)
			SpecValidationList.add(true);
		
		return SpecValidationList;
	}

	@Override
	public boolean AppendSpec(String Spec) {
		// TODO Auto-generated method stub

		if(validate_spec(Spec,1))
		{
			SpecList.add(Spec);
			SpecValidationList.add(true);
		}
		else
			return false;
		return true;
	}
	private boolean validate_spec(String Spec, int mode)
	{
		lexer = new ltlgrammarLexer(new ANTLRInputStream(Spec));
		lexer.removeErrorListeners();
		ltlErrorListener le2 = new ltlErrorListener();
		lexer.addErrorListener(le2);
		CommonTokenStream tokenstream = new CommonTokenStream(lexer);
		RiTHMltlgrammarListener rllistener = new RiTHMltlgrammarListener(mode, Spec);
		parser = new ltlgrammarParser(tokenstream);
		ParseTreeWalker ptwalker = new ParseTreeWalker();
		parser.removeErrorListeners();
		ltlErrorListener le1 = new ltlErrorListener();
		parser.addErrorListener(le1);
		ParseTree ptree = parser.ltl();
		ptwalker.walk(rllistener, ptree);
		boolean retval = le1.validation_result && le2.validation_result;
		ptwalker = null;
		
		if(retval)
			ErrorMessages.put(Spec, "No error, Valid LTL formula\n");
		else
			ErrorMessages.put(Spec, le1.error_message + le2.error_message);
		
		lexer = null;
		parser = null;
		tokenstream = null;
		le1 = null;
		le2 = null;

		return retval;
	}
	@Override
	public ArrayList<Boolean> ValidationResults() {
		// TODO Auto-generated method stub
		return SpecValidationList;
	}

	@Override
	public boolean ExportSpecs(ArrayList<String> args) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean RewriteSpecs(ArrayList<String>  args) {
		// TODO Auto-generated method stub
		if(args.size() != SpecList.size())
			return false;
		if(args != null)
		{
			for(int i = 0;i < args.size();i++)
			{
				String filename = args.get(i);BufferedWriter bw ;
				try
				{
					bw = new BufferedWriter(new FileWriter(filename));
					bw.write(this.SpecList.get(i));
					bw.close();
					
				}catch(Exception e)
				{
					System.out.println(e.getMessage());
					return false;
				}
			}
		}
		return true;
	}
	@Override
	public ArrayList<String> GetSpecs()
	{
		return SpecList;
	}
	@Override
	public ArrayList<String> GetPredicates()
	{
		return PredicateList;
	}
	@Override
	public HashMap<String, String> getErrorMessages() {
		// TODO Auto-generated method stub
		return ErrorMessages;
	}
	public void ClearErrors()
	{
		ErrorMessages.clear();
	}
	public String GetErrorforSpec(String Spec)
	{
		if(ErrorMessages.containsKey(Spec))
			return ErrorMessages.get(Spec);
		else
			return "No Record Found";
	}

	@Override
	public boolean RemoveAllSpecs() {
		// TODO Auto-generated method stub
		for(String each_spec: SpecList)
			validate_spec(each_spec, 2);
		SpecList = null;
		SpecList = new ArrayList<String>();
		return false;
	}
	public ArrayList<String> getPredsForSpec(String spec)
	{
		if(predsForSpec.containsKey(spec))
			return predsForSpec.get(spec);
		return null;
	}
}
