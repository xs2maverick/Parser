package rithm.core;

public interface RiTHMPlugin {
	public static final  String VERSION="1.0";
	/**
     * Set the name of RiTHM plugin
     * @param name of the plugin.
     */
	public void set_name(String name);
	/**
     * Get the name of RiTHM plugin
     * @return name of the plugin.
     */
	public String get_name();
	/**
     * Set the type of plugin
     * @param integer denoting the type.
     */
	public void set_type(int type);
	/**
     * Get the type of plugin
     * @return integer denoting the type.
     */
	public int get_type();
}
