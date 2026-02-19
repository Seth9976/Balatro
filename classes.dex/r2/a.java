package r2;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public abstract class a {
    private static final TimeZone a;

    static {
        a.a = TimeZone.getTimeZone("UTC");
    }

    private static boolean a(String s, int v, char c) {
        return v < s.length() && s.charAt(v) == c;
    }

    private static int b(String s, int v) {
        while(v < s.length()) {
            int v1 = s.charAt(v);
            if(v1 >= 0x30 && v1 <= 57) {
                ++v;
                continue;
            }
            return v;
        }
        return s.length();
    }

    public static Date c(String s, ParsePosition parsePosition0) {
        int v19;
        TimeZone timeZone0;
        int v17;
        int v16;
        int v15;
        int v11;
        try {
            int v = parsePosition0.getIndex();
            int v1 = v + 4;
            int v2 = a.d(s, v, v1);
            if(a.a(s, v1, '-')) {
                ++v1;
            }
            int v3 = v1 + 2;
            int v4 = a.d(s, v1, v3);
            if(a.a(s, v3, '-')) {
                ++v3;
            }
            int v5 = v3 + 2;
            int v6 = a.d(s, v3, v5);
            boolean z = a.a(s, v5, 'T');
            if(!z && s.length() <= v5) {
                GregorianCalendar gregorianCalendar0 = new GregorianCalendar(v2, v4 - 1, v6);
                gregorianCalendar0.setLenient(false);
                parsePosition0.setIndex(v5);
                return gregorianCalendar0.getTime();
            }
            if(z) {
                int v7 = v5 + 3;
                int v8 = a.d(s, v5 + 1, v7);
                if(a.a(s, v7, ':')) {
                    ++v7;
                }
                int v9 = v7 + 2;
                int v10 = a.d(s, v7, v9);
                if(a.a(s, v9, ':')) {
                    ++v9;
                }
                if(s.length() <= v9 || (s.charAt(v9) == 43 || s.charAt(v9) == 45 || s.charAt(v9) == 90)) {
                    v15 = v10;
                    v16 = 0;
                    v17 = v8;
                    v5 = v9;
                    v11 = 0;
                }
                else {
                    v11 = a.d(s, v9, v9 + 2);
                    if(v11 > 59 && v11 < 0x3F) {
                        v11 = 59;
                    }
                    if(a.a(s, v9 + 2, '.')) {
                        int v12 = a.b(s, v9 + 4);
                        int v13 = Math.min(v12, v9 + 6);
                        int v14 = a.d(s, v9 + 3, v13);
                        switch(v13 - (v9 + 3)) {
                            case 1: {
                                v14 *= 100;
                                break;
                            }
                            case 2: {
                                v14 *= 10;
                            }
                        }
                        v15 = v10;
                        v16 = v14;
                        v17 = v8;
                        v5 = v12;
                    }
                    else {
                        v15 = v10;
                        v17 = v8;
                        v5 = v9 + 2;
                        v16 = 0;
                    }
                }
            }
            else {
                v17 = 0;
                v15 = 0;
                v16 = 0;
                v11 = 0;
            }
            if(s.length() <= v5) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            int v18 = s.charAt(v5);
            if(v18 == 90) {
                timeZone0 = a.a;
                v19 = v5 + 1;
            }
            else {
                if(v18 != 43 && v18 != 45) {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator \'" + ((char)v18) + "\'");
                }
                String s1 = s.substring(v5);
                s1 = s1.length() >= 5 ? s.substring(v5) : s1 + "00";
                v19 = v5 + s1.length();
                if("+0000".equals(s1) || "+00:00".equals(s1)) {
                    timeZone0 = a.a;
                }
                else {
                    TimeZone timeZone1 = TimeZone.getTimeZone(("GMT" + s1));
                    String s2 = timeZone1.getID();
                    if(!s2.equals("GMT" + s1) && !s2.replace(":", "").equals("GMT" + s1)) {
                        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + ("GMT" + s1) + " given, resolves to " + timeZone1.getID());
                    }
                    timeZone0 = timeZone1;
                }
            }
            GregorianCalendar gregorianCalendar1 = new GregorianCalendar(timeZone0);
            gregorianCalendar1.setLenient(false);
            gregorianCalendar1.set(1, v2);
            gregorianCalendar1.set(2, v4 - 1);
            gregorianCalendar1.set(5, v6);
            gregorianCalendar1.set(11, v17);
            gregorianCalendar1.set(12, v15);
            gregorianCalendar1.set(13, v11);
            gregorianCalendar1.set(14, v16);
            parsePosition0.setIndex(v19);
            return gregorianCalendar1.getTime();
        }
        catch(IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException indexOutOfBoundsException0) {
            String s3 = indexOutOfBoundsException0.getMessage();
            ParseException parseException0 = new ParseException("Failed to parse date [" + (s == null ? null : '\"' + s + '\"') + "]: " + (s3 != null && !s3.isEmpty() ? indexOutOfBoundsException0.getMessage() : "(" + indexOutOfBoundsException0.getClass().getName() + ")"), parsePosition0.getIndex());
            parseException0.initCause(indexOutOfBoundsException0);
            throw parseException0;
        }
    }

    private static int d(String s, int v, int v1) {
        int v4;
        int v2;
        if(v < 0 || v1 > s.length() || v > v1) {
            throw new NumberFormatException(s);
        }
        if(v < v1) {
            v2 = v + 1;
            int v3 = Character.digit(s.charAt(v), 10);
            if(v3 < 0) {
                throw new NumberFormatException("Invalid number: " + s.substring(v, v1));
            }
            v4 = -v3;
        }
        else {
            v4 = 0;
            v2 = v;
        }
        while(v2 < v1) {
            int v5 = Character.digit(s.charAt(v2), 10);
            if(v5 < 0) {
                throw new NumberFormatException("Invalid number: " + s.substring(v, v1));
            }
            v4 = v4 * 10 - v5;
            ++v2;
        }
        return -v4;
    }
}

