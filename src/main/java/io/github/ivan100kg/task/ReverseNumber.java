package io.github.ivan100kg.task;

public class ReverseNumber {
    public static int foo(int i) {
        StringBuilder sb = new StringBuilder().append(i);
        boolean negative = sb.toString().startsWith("-");
        sb.reverse();
        if(negative) sb.replace(sb.lastIndexOf("-"),sb.length(),"").insert(0, "-");
        String max = String.valueOf(Integer.MAX_VALUE);
        String min = String.valueOf(Integer.MIN_VALUE);
        int result = 0;
        if(negative && sb.length() < min.length() || !negative && sb.length() < max.length())
            result = Integer.parseInt(sb.toString());
        else if (negative && sb.length() == min.length() && sb.toString().compareTo(min) < 1 ||
                !negative && sb.length() == max.length() && sb.toString().compareTo(max) < 1)
            result = Integer.parseInt(sb.toString());
        return result;
    }
}
