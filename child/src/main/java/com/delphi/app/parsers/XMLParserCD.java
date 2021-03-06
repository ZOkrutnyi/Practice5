package com.delphi.app.parsers;

import com.delphi.app.data.CD;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLParserCD implements Parser {

    @Override
    public List<CD> parse(String text) {
        List<CD> cds = new ArrayList<>();
        CD cd;
        Pattern pattern = Pattern.compile("<CD>[\\s\\S]*?</CD>");
        Matcher matcher = pattern.matcher(text);
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
        Matcher tagMatcher = Pattern.compile(
                 String.format("<%s>(.+?)</%s>",field.name(),field.name()))
                .matcher(matcher.group());
        return tagMatcher.find() ? tagMatcher.group(1) : "null";
    }

}
