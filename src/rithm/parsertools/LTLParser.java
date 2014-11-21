package rithm.parsertools;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.antlr.runtime.*;

import rithm.core.*;
public class LTLParser extends ParserPlugin<String>{
	private String SpecLang;
	private ltlgrammarParser parser;
	private ltlgrammarLexer lexer;
	private ArrayList<String> SpecList;
	public LTLParser(String Lang)
	{
		SpecLang = Lang;
	}
	@Override
	public void set_name(String name) {
		// TODO Auto-generated method stub
		super.set_name(name);
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
		return true;
	}

	@Override
	public boolean LoadSpecs(String[] Specs) {
		// TODO Auto-generated method stub
		for (String spec: Specs)
			this.SpecList.add(spec);
		return false;
	}

	@Override 
	public boolean[] ValidateSpecs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean AppendSpec(String Spec) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean[] ValidationResults() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ExportSpecs(String[] args) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean RewriteSpecs(String[] args) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
