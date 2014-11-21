package rithm.core;

import java.util.ArrayList;


public abstract class ParserPlugin<Formula> implements RiTHMPlugin{

	protected String parser_name;
	private enum type_enum
	{
		NATIVE,
		JAVA
	}
	protected type_enum parser_type;
	public static int loaded_count = 0;
	
	public void set_name(String name)
	{
		parser_name = name;
	}
	public String get_name()
	{
		return parser_name;
	}
	public void set_type(int type)
	{
		parser_type = type_enum.values()[type];
	}
	public int get_type()
	{
		return parser_type.ordinal();
	}
	abstract public boolean LoadSpecs(String filename);
	abstract public boolean LoadSpecs(Formula[] Specs);
	abstract public boolean[] ValidateSpecs();
	abstract public boolean AppendSpec(Formula Spec);
	abstract public boolean[] ValidationResults();
	abstract public boolean ExportSpecs(Formula args[]);
	abstract public boolean RewriteSpecs(Formula args[]);
}
