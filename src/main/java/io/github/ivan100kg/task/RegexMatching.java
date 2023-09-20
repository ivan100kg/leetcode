package io.github.ivan100kg.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatching {
    public static boolean isMatch(String s, String p) {
        p = p.replaceAll("\\*+","*");
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
