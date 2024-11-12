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
		LET=1, IF=2, ELSE=3, PRINT=4, ID=5, NUMBER=6, STRING=7, PLUS=8, MINUS=9, 
		STAR=10, SLASH=11, EQ=12, NEQ=13, LT=14, GT=15, LE=16, GE=17, SEMI=18, 
		ASSIGN=19, LPAREN=20, RPAREN=21, LBRACE=22, RBRACE=23, WS=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LET", "IF", "ELSE", "PRINT", "ID", "NUMBER", "STRING", "PLUS", "MINUS", 
			"STAR", "SLASH", "EQ", "NEQ", "LT", "GT", "LE", "GE", "SEMI", "ASSIGN", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'let'", "'if'", "'else'", "'print'", null, null, null, "'+'", 
			"'-'", "'*'", "'/'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "';'", 
			"'='", "'('", "')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LET", "IF", "ELSE", "PRINT", "ID", "NUMBER", "STRING", "PLUS", 
			"MINUS", "STAR", "SLASH", "EQ", "NEQ", "LT", "GT", "LE", "GE", "SEMI", 
			"ASSIGN", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "WS"
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
		"\u0004\u0000\u0018\u0083\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0005\u0004F\b\u0004\n\u0004\f\u0004I\t\u0004"+
		"\u0001\u0005\u0004\u0005L\b\u0005\u000b\u0005\f\u0005M\u0001\u0006\u0001"+
		"\u0006\u0005\u0006R\b\u0006\n\u0006\f\u0006U\t\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n"+
		"\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0004\u0017~\b\u0017"+
		"\u000b\u0017\f\u0017\u007f\u0001\u0017\u0001\u0017\u0000\u0000\u0018\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/"+
		"\u0018\u0001\u0000\u0005\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u0000"+
		"09\u0003\u0000\n\n\r\r\"\"\u0003\u0000\t\n\r\r  \u0086\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'"+
		"\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000"+
		"\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000"+
		"\u00011\u0001\u0000\u0000\u0000\u00035\u0001\u0000\u0000\u0000\u00058"+
		"\u0001\u0000\u0000\u0000\u0007=\u0001\u0000\u0000\u0000\tC\u0001\u0000"+
		"\u0000\u0000\u000bK\u0001\u0000\u0000\u0000\rO\u0001\u0000\u0000\u0000"+
		"\u000fX\u0001\u0000\u0000\u0000\u0011Z\u0001\u0000\u0000\u0000\u0013\\"+
		"\u0001\u0000\u0000\u0000\u0015^\u0001\u0000\u0000\u0000\u0017`\u0001\u0000"+
		"\u0000\u0000\u0019c\u0001\u0000\u0000\u0000\u001bf\u0001\u0000\u0000\u0000"+
		"\u001dh\u0001\u0000\u0000\u0000\u001fj\u0001\u0000\u0000\u0000!m\u0001"+
		"\u0000\u0000\u0000#p\u0001\u0000\u0000\u0000%r\u0001\u0000\u0000\u0000"+
		"\'t\u0001\u0000\u0000\u0000)v\u0001\u0000\u0000\u0000+x\u0001\u0000\u0000"+
		"\u0000-z\u0001\u0000\u0000\u0000/}\u0001\u0000\u0000\u000012\u0005l\u0000"+
		"\u000023\u0005e\u0000\u000034\u0005t\u0000\u00004\u0002\u0001\u0000\u0000"+
		"\u000056\u0005i\u0000\u000067\u0005f\u0000\u00007\u0004\u0001\u0000\u0000"+
		"\u000089\u0005e\u0000\u00009:\u0005l\u0000\u0000:;\u0005s\u0000\u0000"+
		";<\u0005e\u0000\u0000<\u0006\u0001\u0000\u0000\u0000=>\u0005p\u0000\u0000"+
		">?\u0005r\u0000\u0000?@\u0005i\u0000\u0000@A\u0005n\u0000\u0000AB\u0005"+
		"t\u0000\u0000B\b\u0001\u0000\u0000\u0000CG\u0007\u0000\u0000\u0000DF\u0007"+
		"\u0001\u0000\u0000ED\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000\u0000"+
		"GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000H\n\u0001\u0000\u0000"+
		"\u0000IG\u0001\u0000\u0000\u0000JL\u0007\u0002\u0000\u0000KJ\u0001\u0000"+
		"\u0000\u0000LM\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001"+
		"\u0000\u0000\u0000N\f\u0001\u0000\u0000\u0000OS\u0005\"\u0000\u0000PR"+
		"\b\u0003\u0000\u0000QP\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000"+
		"SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TV\u0001\u0000\u0000"+
		"\u0000US\u0001\u0000\u0000\u0000VW\u0005\"\u0000\u0000W\u000e\u0001\u0000"+
		"\u0000\u0000XY\u0005+\u0000\u0000Y\u0010\u0001\u0000\u0000\u0000Z[\u0005"+
		"-\u0000\u0000[\u0012\u0001\u0000\u0000\u0000\\]\u0005*\u0000\u0000]\u0014"+
		"\u0001\u0000\u0000\u0000^_\u0005/\u0000\u0000_\u0016\u0001\u0000\u0000"+
		"\u0000`a\u0005=\u0000\u0000ab\u0005=\u0000\u0000b\u0018\u0001\u0000\u0000"+
		"\u0000cd\u0005!\u0000\u0000de\u0005=\u0000\u0000e\u001a\u0001\u0000\u0000"+
		"\u0000fg\u0005<\u0000\u0000g\u001c\u0001\u0000\u0000\u0000hi\u0005>\u0000"+
		"\u0000i\u001e\u0001\u0000\u0000\u0000jk\u0005<\u0000\u0000kl\u0005=\u0000"+
		"\u0000l \u0001\u0000\u0000\u0000mn\u0005>\u0000\u0000no\u0005=\u0000\u0000"+
		"o\"\u0001\u0000\u0000\u0000pq\u0005;\u0000\u0000q$\u0001\u0000\u0000\u0000"+
		"rs\u0005=\u0000\u0000s&\u0001\u0000\u0000\u0000tu\u0005(\u0000\u0000u"+
		"(\u0001\u0000\u0000\u0000vw\u0005)\u0000\u0000w*\u0001\u0000\u0000\u0000"+
		"xy\u0005{\u0000\u0000y,\u0001\u0000\u0000\u0000z{\u0005}\u0000\u0000{"+
		".\u0001\u0000\u0000\u0000|~\u0007\u0004\u0000\u0000}|\u0001\u0000\u0000"+
		"\u0000~\u007f\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081"+
		"\u0082\u0006\u0017\u0000\u0000\u00820\u0001\u0000\u0000\u0000\u0005\u0000"+
		"GMS\u007f\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}