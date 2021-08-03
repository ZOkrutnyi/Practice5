package com.delphi.app.parsers;

import com.delphi.app.data.AbstractColumnData;
import com.delphi.app.data.CD;
import com.delphi.app.readers.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class XMLParserCD implements Parser {
    private final Reader reader;

    protected XMLParserCD(Reader reader) {
        this.reader = reader;
    }

    //<CD>[\\s\\S]*?<\\/CD>
    //<CD.*>((.|\n)*?)<\/CD>
    @Override
    public List<? extends AbstractColumnData> parse() {
        List<AbstractColumnData> cds = new ArrayList<>();
        CD cd;
        Pattern pattern = Pattern.compile("<CD>[\\s\\S]*?<\\/CD>");
        Matcher matcher = pattern.matcher(reader.byteToString(reader.read()));
        Matcher tagMatcher;
        while (matcher.find()) {
            cd = new CD();
            tagMatcher = getPatterns()[0].matcher(matcher.group());
            tagMatcher.find();
            cd.setTitle(tagMatcher.group(1));

            tagMatcher = getPatterns()[1].matcher(matcher.group());
            tagMatcher.find();
            cd.setArtist(tagMatcher.group(1));

            tagMatcher = getPatterns()[2].matcher(matcher.group());
            tagMatcher.find();
            cd.setCountry(tagMatcher.group(1));

            tagMatcher = getPatterns()[3].matcher(matcher.group());
            tagMatcher.find();
            cd.setCompany(tagMatcher.group(1));

            tagMatcher = getPatterns()[4].matcher(matcher.group());
            tagMatcher.find();
            cd.setPrice(tagMatcher.group(1));

            tagMatcher = getPatterns()[5].matcher(matcher.group());
            tagMatcher.find();
            cd.setYear(tagMatcher.group(1));
            cds.add(cd);
        }
        return cds;
    }

    private Pattern[] getPatterns() {
        Pattern[] content = new Pattern[6];
        content[0] = Pattern.compile("<TITLE>(.+?)<\\/TITLE>");
        content[1] = Pattern.compile("<ARTIST>(.+?)<\\/ARTIST>");
        content[2] = Pattern.compile("<COUNTRY>(.+?)<\\/COUNTRY>");
        content[3] = Pattern.compile("<COMPANY>(.+?)<\\/COMPANY>");
        content[4] = Pattern.compile("<PRICE>(.+?)<\\/PRICE>");
        content[5] = Pattern.compile("<YEAR>(.+?)<\\/YEAR>");
        return content;
    }
}
