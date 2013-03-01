package de.kopis.jtoml.antlr;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;

import de.kopis.jtoml.antlr.impl.TomlBaseListener;
import de.kopis.jtoml.antlr.impl.TomlParser.BooleanContext;
import de.kopis.jtoml.antlr.impl.TomlParser.DateContext;
import de.kopis.jtoml.antlr.impl.TomlParser.IntegerContext;
import de.kopis.jtoml.antlr.impl.TomlParser.ListContext;
import de.kopis.jtoml.antlr.impl.TomlParser.SectionContext;
import de.kopis.jtoml.antlr.impl.TomlParser.StringContext;

public class TomlLoader extends TomlBaseListener {
        private final Map<String, Object> tomlContext;
        private String section = "";

        public TomlLoader(Map<String, Object> context) {
            this.tomlContext = context;
        }

        private void put(String key, Object value) {
            String sectionKey = prependSection(key);
            tomlContext.put(sectionKey, value);
        }

        private String prependSection(String key) {
            return ("".equals(section) ? "" : section + ".") + key;
        }

        @Override
        public void enterSection(SectionContext ctx) {
            this.section = unquote(ctx.getText());
        }

        @Override
        public void enterString(StringContext ctx) {
            String key = ctx.WORD().getText();
            String value = unquote(ctx.STRING().getText());
            put(key, value);
        }

        @Override
        public void enterDate(DateContext ctx) {
            String key = ctx.WORD().getText();
            Calendar value = parseDate(ctx.DATE().getText());
            put(key, value);
        }

        @Override
        public void enterInteger(IntegerContext ctx) {
            String key = ctx.WORD().getText();
            Integer value = Integer.valueOf(ctx.INT().getText());
            put(key, value);
        }

        @Override
        public void enterBoolean(BooleanContext ctx) {
            String key = ctx.WORD().getText();
            Boolean value = Boolean.valueOf(ctx.BOOLEAN().getText());
            put(key, value);
        }

        @Override
        public void enterList(ListContext ctx) {
            String key = ctx.WORD().getText();
            String value = ctx.array().getText().trim();
            // remove []
            value = unquote(value);
            List<Object> arr = parseArray(value);
            put(key, arr);
        }

        private List<Object> parseArray(String value) {
            List<Object> arr = new ArrayList<Object>();
            StringTokenizer tokenizer = new StringTokenizer(value, ",");
            while(tokenizer.hasMoreTokens()) {
                String element = tokenizer.nextToken().trim();
                if(element.startsWith("\"")) {
                    // string
                    arr.add(element);
                } else if(element.startsWith("[")) {
                    // TODO how to parse a nested array?
                } else if(element.matches("\\d+")) {
                    Integer valueOf = Integer.valueOf(element);
                    arr.add(valueOf);
                } else {
                    System.err.println("array element could not be parsed: " + element);
                }
            }
            return arr;
        }

        private String unquote(String string) {
            if (string.startsWith("[") || string.startsWith("\"")) {
                string = string.substring(1);
            }
            if (string.endsWith("]") || string.endsWith("\"")) {
                string = string.substring(0, string.length() - 1);
            }
            return string.trim();
        }

        private Calendar parseDate(String date) {
            // 1979-05-27T07:32:00Z
            final SimpleDateFormat TOML_DATEFORMAT = new SimpleDateFormat(
                    "yyyy-MM-dd'T'hh:mm:SS'Z'");
            TOML_DATEFORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
            Calendar calendar = Calendar.getInstance(TimeZone
                    .getTimeZone("UTC"));
            try {
                Date value = TOML_DATEFORMAT.parse(date);
                calendar.setTime(value);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return calendar;
        }
    }

