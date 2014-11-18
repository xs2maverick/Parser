package rithm.parsertools;
import java.io.IOException;
import org.antlr.runtime.*;

import rithm.core.*;
public class LTLParser extends ParserPlugin<String>{
	private String SpecLang;
	
	public LTLParser(String Lang)
	{
		SpecLang = Lang;
	}
	@Override
	public void setname(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getname() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean LoadSpecs(String filename){
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean LoadSpecs(String[] Specs) {
		// TODO Auto-generated method stub
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
