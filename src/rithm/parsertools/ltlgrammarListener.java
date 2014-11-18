// Generated from ltlgrammar.g4 by ANTLR 4.2

	package rithm.parsertools;
	import java.util.HashMap;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ltlgrammarParser}.
 */
public interface ltlgrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ltlgrammarParser#ltl}.
	 * @param ctx the parse tree
	 */
	void enterLtl(@NotNull ltlgrammarParser.LtlContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlgrammarParser#ltl}.
	 * @param ctx the parse tree
	 */
	void exitLtl(@NotNull ltlgrammarParser.LtlContext ctx);
}