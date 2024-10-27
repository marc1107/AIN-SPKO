// Generated from SimpleLangLexer.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SimpleLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LET=1, IF=2, ELSE=3, PRINT=4, ID=5, NUMBER=6, PLUS=7, MINUS=8, STAR=9, 
		SLASH=10, EQ=11, NEQ=12, LT=13, GT=14, LE=15, GE=16, SEMI=17, ASSIGN=18, 
		LPAREN=19, RPAREN=20, LBRACE=21, RBRACE=22, WS=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LET", "IF", "ELSE", "PRINT", "ID", "NUMBER", "PLUS", "MINUS", "STAR", 
			"SLASH", "EQ", "NEQ", "LT", "GT", "LE", "GE", "SEMI", "ASSIGN", "LPAREN", 
			"RPAREN", "LBRACE", "RBRACE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'let'", "'if'", "'else'", "'print'", null, null, "'+'", "'-'", 
			"'*'", "'/'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "';'", "'='", 
			"'('", "')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LET", "IF", "ELSE", "PRINT", "ID", "NUMBER", "PLUS", "MINUS", 
			"STAR", "SLASH", "EQ", "NEQ", "LT", "GT", "LE", "GE", "SEMI", "ASSIGN", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public SimpleLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimpleLangLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0017x\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0005"+
		"\u0004D\b\u0004\n\u0004\f\u0004G\t\u0004\u0001\u0005\u0004\u0005J\b\u0005"+
		"\u000b\u0005\f\u0005K\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0004\u0016"+
		"s\b\u0016\u000b\u0016\f\u0016t\u0001\u0016\u0001\u0016\u0000\u0000\u0017"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017"+
		"\u0001\u0000\u0004\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u00000"+
		"9\u0003\u0000\t\n\r\r  z\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000"+
		"\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000"+
		")\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001"+
		"\u0000\u0000\u0000\u0001/\u0001\u0000\u0000\u0000\u00033\u0001\u0000\u0000"+
		"\u0000\u00056\u0001\u0000\u0000\u0000\u0007;\u0001\u0000\u0000\u0000\t"+
		"A\u0001\u0000\u0000\u0000\u000bI\u0001\u0000\u0000\u0000\rM\u0001\u0000"+
		"\u0000\u0000\u000fO\u0001\u0000\u0000\u0000\u0011Q\u0001\u0000\u0000\u0000"+
		"\u0013S\u0001\u0000\u0000\u0000\u0015U\u0001\u0000\u0000\u0000\u0017X"+
		"\u0001\u0000\u0000\u0000\u0019[\u0001\u0000\u0000\u0000\u001b]\u0001\u0000"+
		"\u0000\u0000\u001d_\u0001\u0000\u0000\u0000\u001fb\u0001\u0000\u0000\u0000"+
		"!e\u0001\u0000\u0000\u0000#g\u0001\u0000\u0000\u0000%i\u0001\u0000\u0000"+
		"\u0000\'k\u0001\u0000\u0000\u0000)m\u0001\u0000\u0000\u0000+o\u0001\u0000"+
		"\u0000\u0000-r\u0001\u0000\u0000\u0000/0\u0005l\u0000\u000001\u0005e\u0000"+
		"\u000012\u0005t\u0000\u00002\u0002\u0001\u0000\u0000\u000034\u0005i\u0000"+
		"\u000045\u0005f\u0000\u00005\u0004\u0001\u0000\u0000\u000067\u0005e\u0000"+
		"\u000078\u0005l\u0000\u000089\u0005s\u0000\u00009:\u0005e\u0000\u0000"+
		":\u0006\u0001\u0000\u0000\u0000;<\u0005p\u0000\u0000<=\u0005r\u0000\u0000"+
		"=>\u0005i\u0000\u0000>?\u0005n\u0000\u0000?@\u0005t\u0000\u0000@\b\u0001"+
		"\u0000\u0000\u0000AE\u0007\u0000\u0000\u0000BD\u0007\u0001\u0000\u0000"+
		"CB\u0001\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000"+
		"\u0000EF\u0001\u0000\u0000\u0000F\n\u0001\u0000\u0000\u0000GE\u0001\u0000"+
		"\u0000\u0000HJ\u0007\u0002\u0000\u0000IH\u0001\u0000\u0000\u0000JK\u0001"+
		"\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000"+
		"L\f\u0001\u0000\u0000\u0000MN\u0005+\u0000\u0000N\u000e\u0001\u0000\u0000"+
		"\u0000OP\u0005-\u0000\u0000P\u0010\u0001\u0000\u0000\u0000QR\u0005*\u0000"+
		"\u0000R\u0012\u0001\u0000\u0000\u0000ST\u0005/\u0000\u0000T\u0014\u0001"+
		"\u0000\u0000\u0000UV\u0005=\u0000\u0000VW\u0005=\u0000\u0000W\u0016\u0001"+
		"\u0000\u0000\u0000XY\u0005!\u0000\u0000YZ\u0005=\u0000\u0000Z\u0018\u0001"+
		"\u0000\u0000\u0000[\\\u0005<\u0000\u0000\\\u001a\u0001\u0000\u0000\u0000"+
		"]^\u0005>\u0000\u0000^\u001c\u0001\u0000\u0000\u0000_`\u0005<\u0000\u0000"+
		"`a\u0005=\u0000\u0000a\u001e\u0001\u0000\u0000\u0000bc\u0005>\u0000\u0000"+
		"cd\u0005=\u0000\u0000d \u0001\u0000\u0000\u0000ef\u0005;\u0000\u0000f"+
		"\"\u0001\u0000\u0000\u0000gh\u0005=\u0000\u0000h$\u0001\u0000\u0000\u0000"+
		"ij\u0005(\u0000\u0000j&\u0001\u0000\u0000\u0000kl\u0005)\u0000\u0000l"+
		"(\u0001\u0000\u0000\u0000mn\u0005{\u0000\u0000n*\u0001\u0000\u0000\u0000"+
		"op\u0005}\u0000\u0000p,\u0001\u0000\u0000\u0000qs\u0007\u0003\u0000\u0000"+
		"rq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000"+
		"\u0000tu\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0006\u0016"+
		"\u0000\u0000w.\u0001\u0000\u0000\u0000\u0004\u0000EKt\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}