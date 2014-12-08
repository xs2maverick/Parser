package rithm.core;

import java.util.*;
 
public abstract class 
ParserPlugin<Formula, Predicate, T1 extends Collection<? extends Boolean>, T2 extends Collection<Formula>, T3 extends Collection<Predicate>, T4 extends AbstractMap<Formula, String> > 
implements RiTHMPlugin{

	protected String parser_name;
	private enum type_enum
	{
		NATIVE,
		JAVA
	}
	protected type_enum parser_type;
	public static int loaded_count = 0;
	/**Set the name of Parser Plugin 
	 * @param This is the name to be set*/
	public void set_name(String name)
	{
		parser_name = name;
	}
	/**Get the name of Parser Plugin 
	 * @return Name of Parser Plugin*/
	public String get_name()
	{
		return parser_name;
	}
	/**Set the type of Parser Plugin 
	* @param {@link {@link ParserPlugin#parser_type}}*/
	public void set_type(int type)
	{
		parser_type = type_enum.values()[type];
	}
	/**Get the type of Parser Plugin 
	 * @return type of Parser Plugin*/
	public int get_type()
	{
		return parser_type.ordinal();
	}
	/**Load a set of <Formula> in a file
	 * @param filename which specify the file from which the <Formula>'s will be loaded
	 * @return whether the loading was successful*/
	abstract public boolean LoadSpecs(String filename);
	
	/**Load a set of <Formula> from a collection of type <T2>
	 * @param a collection of type <T2>
	 * @return whether the loading was successful*/
	abstract public boolean LoadSpecs(T2 Specs);
	
	/**Validate previously loaded formulae of type <Formula>
	 * @return a collection of type <T1>*/
	abstract public T1 ValidateSpecs();
	
	/**Append a <Formula> to previously loaded formulae
	 * @return whether the append was successful*/
	abstract public boolean AppendSpec(Formula Spec);
	
	/**Remove a specification of type <Formula>
	 * @param a specification of type <Formula>
	 * @return whether the removal was successful*/
	abstract public boolean RemoveSpec(Formula Spec);
	
	/**Get the results of the validation of loaded specifications
	 * @return a collection of type <T1>*/
	abstract public T1 ValidationResults();
	
	/**Export the specifications in a different syntax
	 * @param a collection of type <T2>
	 * @return whether the export is successful*/
	abstract public boolean ExportSpecs(T2 Specs);
	
	/**Rewrite the specifications in a different syntax
	 * @param a collection of type <T2>
	 * @return whether the rewrite is successful*/
	abstract public boolean RewriteSpecs(T2 Specs);
	
	/**Returns the currently loaded specifications
	 * @return a collection of type <T2>*/
	abstract public T2 GetSpecs();
	
	/**Returns the predicates of currently loaded specifications
	 * @return a collection of type <T3>*/
	abstract public T3 GetPredicates();
	
	/**Returns the error messages (if any) of the specifications whose loading was attempted
	 * @return a collection of type <T4>*/
	abstract public T4 getErrorMessages();
	
	/**Clears the error history of the attempted loads*/
	abstract public void ClearErrors();
	
	/**Returns the error messages for a particular Formula
	 * @param The specification of type <Formula>
	 * @return Error Message <T4>*/
	abstract public String GetErrorforSpec(Formula Spec);
	
	/**Clears all the loaded specifications 
	 * @return whether the removal was successful*/
	abstract public boolean RemoveAllSpecs();
}
