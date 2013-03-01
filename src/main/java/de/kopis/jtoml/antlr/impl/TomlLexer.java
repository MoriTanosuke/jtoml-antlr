// Generated from src/main/resources/Toml.g4 by ANTLR 4.0
package de.kopis.jtoml.antlr.impl;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TomlLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__5=1, T__4=2, T__3=3, T__2=4, T__1=5, T__0=6, NUMBER=7, BOOLEAN=8, WORD=9, 
		STRING=10, DATE=11, NEWLINE=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "' '", "','", "'['", "'='", "'#'", "NUMBER", "BOOLEAN", "WORD", 
		"STRING", "DATE", "NEWLINE"
	};
	public static final String[] ruleNames = {
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "NUMBER", "BOOLEAN", "WORD", 
		"STRING", "DATE", "NEWLINE"
	};


	public TomlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Toml.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\2\4\16i\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\6\b)\n\b\r\b\16\b*\3\b\3\b\6\b/\n\b\r\b\16\b\60"+
		"\5\b\63\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t>\n\t\3\n\6\nA\n\n"+
		"\r\n\16\nB\3\13\3\13\3\13\3\13\7\13I\n\13\f\13\16\13L\13\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\5\rf\n\r\3\r\3\r\2\16\3\3\1\5\4\1\7\5\1\t\6\1\13\7"+
		"\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\3\2\23\3\62;\3\62"+
		";\r\13\f##%%()/\60\62;AAC\\^^aac|\3\62;\3\62;\3\62;\3\62;\3\62;\3\62;"+
		"\3\62;\3\62;\3\62;\3\62;\3\62;\3\62;\3\62;\3\62;o\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2"+
		"\2\2\5\35\3\2\2\2\7\37\3\2\2\2\t!\3\2\2\2\13#\3\2\2\2\r%\3\2\2\2\17(\3"+
		"\2\2\2\21=\3\2\2\2\23@\3\2\2\2\25D\3\2\2\2\27O\3\2\2\2\31e\3\2\2\2\33"+
		"\34\7_\2\2\34\4\3\2\2\2\35\36\7\"\2\2\36\6\3\2\2\2\37 \7.\2\2 \b\3\2\2"+
		"\2!\"\7]\2\2\"\n\3\2\2\2#$\7?\2\2$\f\3\2\2\2%&\7%\2\2&\16\3\2\2\2\')\t"+
		"\2\2\2(\'\3\2\2\2)*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\62\3\2\2\2,.\13\2\2\2"+
		"-/\t\3\2\2.-\3\2\2\2/\60\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\63\3\2\2"+
		"\2\62,\3\2\2\2\62\63\3\2\2\2\63\20\3\2\2\2\64\65\7v\2\2\65\66\7t\2\2\66"+
		"\67\7w\2\2\67>\7g\2\289\7h\2\29:\7c\2\2:;\7n\2\2;<\7u\2\2<>\7g\2\2=\64"+
		"\3\2\2\2=8\3\2\2\2>\22\3\2\2\2?A\t\4\2\2@?\3\2\2\2AB\3\2\2\2B@\3\2\2\2"+
		"BC\3\2\2\2C\24\3\2\2\2DE\7$\2\2EJ\5\23\n\2FG\7\"\2\2GI\5\23\n\2HF\3\2"+
		"\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3\2\2\2LJ\3\2\2\2MN\7$\2\2N\26\3"+
		"\2\2\2OP\t\5\2\2PQ\t\6\2\2QR\t\7\2\2RS\t\b\2\2ST\7/\2\2TU\t\t\2\2UV\t"+
		"\n\2\2VW\7/\2\2WX\t\13\2\2XY\t\f\2\2YZ\7V\2\2Z[\t\r\2\2[\\\t\16\2\2\\"+
		"]\7<\2\2]^\t\17\2\2^_\t\20\2\2_`\7<\2\2`a\t\21\2\2ab\t\22\2\2bc\7\\\2"+
		"\2c\30\3\2\2\2df\7\17\2\2ed\3\2\2\2ef\3\2\2\2fg\3\2\2\2gh\7\f\2\2h\32"+
		"\3\2\2\2\n\2*\60\62=BJe";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}