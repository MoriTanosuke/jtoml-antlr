package de.kopis.jtoml.antlr;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Locale;

import me.grison.jtoml.TomlParser;
import me.grison.jtoml.impl.Toml;

import org.junit.Before;
import org.junit.Test;

public class SpecificationsTest {
    static {
        Locale.setDefault(Locale.US);
    }

    private TomlParser tomlParser;

    @Test
    public void testInteger() {
        Toml toml = Toml.parse("foo = 42", tomlParser);
        assertEquals(new Integer(42), toml.getAs("foo", Integer.class));
    }

    @Test
    public void testFloat() {
        Toml toml = Toml.parse("foo = 13.37");
        assertEquals(new Float(13.37), toml.getAs("foo", Float.class), 0.00001f);
    }

    @Test
    public void testBoolean() {
        Toml toml = Toml.parse("foo = true\nbar = false");
        assertEquals(true, toml.getBoolean("foo").booleanValue());
        assertEquals(false, toml.getBoolean("bar").booleanValue());
    }

    @Test
    public void testString() {
        Toml toml = Toml.parse("foo = \"Hello\\tWorld\\nI'm having \\\"!\"");
        assertEquals("Hello\tWorld\nI'm having \"!", toml.getString("foo"));
    }

    @Test
    public void testArray() {
        Toml toml = Toml
                .parse("foo = [\n\"Hello\",\n\n\t \"World\"\n,\"Nice\"]");
        assertEquals(Arrays.asList("Hello", "World", "Nice"),
                toml.getList("foo"));
    }
    
    @Before
    public void setUp() {
        tomlParser = new AntlrTomlParser();
    }
}
