// Generated from ltlgrammar.g4 by ANTLR 4.2

	package rithm.parsertools;
	import java.util.HashMap;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ltlgrammarLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__1=1, T__0=2, Pred=3, Unary=4, Binary=5;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'('", "')'", "Pred", "Unary", "Binary"
	};
	public static final String[] ruleNames = {
		"T__1", "T__0", "Pred", "Unary", "Binary"
	};


		


	public ltlgrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ltlgrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\7,\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\3\3\3\3\4\6\4\23\n\4\r\4\16\4"+
		"\24\3\4\5\4\30\n\4\3\5\3\5\3\5\3\5\3\5\5\5\37\n\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\5\6+\n\6\2\2\7\3\3\5\4\7\5\t\6\13\7\3\2\5\3\2c|\4"+
		"\2HHVV\4\2WWYY\63\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\3\r\3\2\2\2\5\17\3\2\2\2\7\27\3\2\2\2\t\36\3\2\2\2\13*\3\2\2"+
		"\2\r\16\7*\2\2\16\4\3\2\2\2\17\20\7+\2\2\20\6\3\2\2\2\21\23\t\2\2\2\22"+
		"\21\3\2\2\2\23\24\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2\2\25\30\3\2\2\2\26"+
		"\30\t\3\2\2\27\22\3\2\2\2\27\26\3\2\2\2\30\b\3\2\2\2\31\32\7>\2\2\32\37"+
		"\7@\2\2\33\34\7]\2\2\34\37\7_\2\2\35\37\7#\2\2\36\31\3\2\2\2\36\33\3\2"+
		"\2\2\36\35\3\2\2\2\37\n\3\2\2\2 +\t\4\2\2!\"\7(\2\2\"+\7(\2\2#$\7~\2\2"+
		"$+\7~\2\2%&\7/\2\2&+\7@\2\2\'(\7>\2\2()\7/\2\2)+\7@\2\2* \3\2\2\2*!\3"+
		"\2\2\2*#\3\2\2\2*%\3\2\2\2*\'\3\2\2\2+\f\3\2\2\2\7\2\24\27\36*\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}