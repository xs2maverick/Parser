package rithm.core;


public abstract class ParserPlugin<Formula> implements RiTHMPlugin{

	private String parser_name;
	private String parser_type;
	private static int loaded_count = 0;
	
	public void set_name(String name)
	{
		parser_name = name;
	}
	public String get_name()
	{
		return parser_name;
	}
	public void set_type(String type)
	{
		parser_type = type;
	}
	public String get_type()
	{
		return parser_type;
	}
	abstract public boolean LoadSpecs(String filename);
	abstract public boolean LoadSpecs(Formula[] Specs);
	abstract public boolean[] ValidateSpecs();
	abstract public boolean AppendSpec(Formula Spec);
	abstract public boolean[] ValidationResults();
	abstract public boolean ExportSpecs(Formula args[]);
	abstract public boolean RewriteSpecs(Formula args[]);
}
