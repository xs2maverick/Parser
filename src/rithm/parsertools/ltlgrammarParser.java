// Generated from ltlgrammar.g4 by ANTLR 4.2

	package rithm.parsertools;
	import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ltlgrammarParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__1=1, T__0=2, Pred=3, Unary=4, Binary=5;
	public static final String[] tokenNames = {
		"<INVALID>", "'('", "')'", "Pred", "Unary", "Binary"
	};
	public static final int
		RULE_ltl = 0;
	public static final String[] ruleNames = {
		"ltl"
	};

	@Override
	public String getGrammarFileName() { return "ltlgrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		

	public ltlgrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class LtlContext extends ParserRuleContext {
		public LtlContext ltl(int i) {
			return getRuleContext(LtlContext.class,i);
		}
		public List<LtlContext> ltl() {
			return getRuleContexts(LtlContext.class);
		}
		public TerminalNode Pred() { return getToken(ltlgrammarParser.Pred, 0); }
		public TerminalNode Unary() { return getToken(ltlgrammarParser.Unary, 0); }
		public TerminalNode Binary() { return getToken(ltlgrammarParser.Binary, 0); }
		public LtlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ltl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlgrammarListener ) ((ltlgrammarListener)listener).enterLtl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlgrammarListener ) ((ltlgrammarListener)listener).exitLtl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ltlgrammarVisitor ) return ((ltlgrammarVisitor<? extends T>)visitor).visitLtl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LtlContext ltl() throws RecognitionException {
		return ltl(0);
	}

	private LtlContext ltl(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LtlContext _localctx = new LtlContext(_ctx, _parentState);
		LtlContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_ltl, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			switch (_input.LA(1)) {
			case Unary:
				{
				setState(3); match(Unary);
				setState(4); ltl(1);
				}
				break;
			case Pred:
				{
				setState(5); match(Pred);
				}
				break;
			case 1:
				{
				setState(6); match(1);
				setState(7); ltl(0);
				setState(8); match(2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(17);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LtlContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_ltl);
					setState(12);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(13); match(Binary);
					setState(14); ltl(3);
					}
					} 
				}
				setState(19);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0: return ltl_sempred((LtlContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean ltl_sempred(LtlContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\7\27\4\2\t\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\r\n\2\3\2\3\2\3\2\7\2\22\n\2\f\2\16\2"+
		"\25\13\2\3\2\2\3\2\3\2\2\2\30\2\f\3\2\2\2\4\5\b\2\1\2\5\6\7\6\2\2\6\r"+
		"\5\2\2\3\7\r\7\5\2\2\b\t\7\3\2\2\t\n\5\2\2\2\n\13\7\4\2\2\13\r\3\2\2\2"+
		"\f\4\3\2\2\2\f\7\3\2\2\2\f\b\3\2\2\2\r\23\3\2\2\2\16\17\f\4\2\2\17\20"+
		"\7\7\2\2\20\22\5\2\2\5\21\16\3\2\2\2\22\25\3\2\2\2\23\21\3\2\2\2\23\24"+
		"\3\2\2\2\24\3\3\2\2\2\25\23\3\2\2\2\4\f\23";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}