package de.kopis.jtoml.antlr;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import de.kopis.jtoml.antlr.impl.TomlLexer;
import de.kopis.jtoml.antlr.impl.TomlParser;

public class AntlrTomlParser extends HashMap<String, Object> implements me.grison.jtoml.TomlParser {

    private static final long serialVersionUID = 3365676949764887204L;

    public AntlrTomlParser() {
        super();
        System.out.println("Using ANTLR to parse toml files.");
    }

    private Map<String, Object> parseInputStream(InputStream fileInputStream) {
        Map<String, Object> context = new HashMap<String, Object>();
        try {
            ANTLRInputStream in = new ANTLRInputStream(fileInputStream);
            TomlLexer lexer = new TomlLexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            TomlParser parser = new TomlParser(tokens);
            ParseTree tree = parser.toml();
            System.out.println(tree.toStringTree(parser));
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(new TomlLoader(context), tree);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return context;
    }

    @Override
    public Map<String, Object> parse(String tomlString) {
        return parseInputStream(new ByteArrayInputStream(tomlString.getBytes()));
    }

}
