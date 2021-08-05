package com.delphi.app.parsers;

import com.delphi.app.data.CD;
import com.delphi.app.readers.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLParserCD implements Parser<CD> {
    private final Reader reader;

    public XMLParserCD(Reader reader) {
        this.reader = reader;
    }

    @Override
    public List<CD> parse() {
        List<CD> cds = new ArrayList<>();
        CD cd;
        Pattern pattern = Pattern.compile("<CD>[\\s\\S]*?</CD>");
        Matcher matcher = pattern.matcher(reader.byteToString(reader.read()));
        while (matcher.find()) {
            cd = new CD();
            cd.setTitle(getAttribute(matcher, FieldCD.TITLE));
            cd.setArtist(getAttribute(matcher, FieldCD.ARTIST));
            cd.setCountry(getAttribute(matcher, FieldCD.COUNTRY));
            cd.setCompany(getAttribute(matcher, FieldCD.COMPANY));
            cd.setPrice(getAttribute(matcher, FieldCD.PRICE));
            cd.setYear(getAttribute(matcher, FieldCD.YEAR));
            cds.add(cd);
        }
        return cds;
    }

    private String getAttribute(Matcher matcher, FieldCD field) {
        Matcher tagMatcher = getPatterns()[field.ordinal()].matcher(matcher.group());
        return tagMatcher.find() ? tagMatcher.group(1) : "null";
    }

    private Pattern[] getPatterns() {
        Pattern[] content = new Pattern[6];
        content[0] = Pattern.compile("<TITLE>(.+?)</TITLE>");
        content[1] = Pattern.compile("<ARTIST>(.+?)</ARTIST>");
        content[2] = Pattern.compile("<COUNTRY>(.+?)</COUNTRY>");
        content[3] = Pattern.compile("<COMPANY>(.+?)</COMPANY>");
        content[4] = Pattern.compile("<PRICE>(.+?)</PRICE>");
        content[5] = Pattern.compile("<YEAR>(.+?)</YEAR>");
        return content;
    }
}
