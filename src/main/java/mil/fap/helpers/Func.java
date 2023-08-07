package mil.fap.helpers;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import mil.fap.security.encrypt.Sequence;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public final class Func {

    public static final Integer Seed = 7;

    public static final Integer Year = Calendar.YEAR;
    public static final Integer Month = Calendar.MONTH;
    public static final Integer DayOfYear = Calendar.DAY_OF_YEAR;
    public static final Integer DayOfMonth = Calendar.DAY_OF_MONTH;
    public static final Integer DayOfWeek = Calendar.DAY_OF_WEEK;
    public static final Integer Hour = Calendar.HOUR;
    public static final Integer Minute = Calendar.MINUTE;
    public static final Integer Second = Calendar.SECOND;

    /**
     * Check if received object is null
     *
     * @param value
     * @return
     */
    public static boolean isNull(Object value) {
        return value == null;
    }

    /**
     * Check if string is null or does not have a character ("")
     *
     * @param value
     * @return
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().equals("");
    }

    /**
     * Returns optional value if value is null
     *
     * @param value
     * @param optional
     * @return
     */
    public static <T extends Object> T iif(T value, T optional) {
        return value == null ? optional : value;
    }

    /**
     *
     * @param value
     * @return
     */
    public static boolean isInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     *
     * @param value
     * @return
     */
    public static boolean isDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * Get specific cookie by name in cookie's array
     *
     * @param cookies
     * @param name
     * @return
     */
    public static Cookie getCookie(HttpServletRequest request, String name) {
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(name)) {
                return cookie;
            }
        }
        return null;
    }

    /**
     * Get specific cookie by name in cookie's array
     *
     * @param cookies
     * @param name
     * @return
     */
    public static Cookie addCookie(String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24);
        return cookie;
    }

    /**
     * Get specific cookie by name in cookie's array
     *
     * @param cookies
     * @param name
     * @return
     */
    public static Cookie removeCookie(String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        return cookie;
    }

    /**
     * Convert text to AES type encrypt
     *
     * @param value
     * @return
     */
    public static String encrypt(String value) {
        return new Sequence().encrypt(value, Seed);
    }

    /**
     * Convert text from AES type encrypt to normal
     *
     * @param value
     * @return
     */
    public static String decrypt(String value) {
        return new Sequence().decrypt(value, Seed);
    }

    public static Boolean in(Integer value, Integer... comparers) {
        for (Integer comparer : comparers) {
            if (value == comparer) {
                return true;
            }
        }
        return false;
    }

    public static Boolean in(Double value, Double... comparers) {
        for (Double comparer : comparers) {
            if (value == comparer) {
                return true;
            }
        }
        return false;
    }

    public static Boolean in(String value, String... comparers) {
        for (String comparer : comparers) {
            if (value.equals(comparer)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean inIgnoreCase(String value, String... comparers) {
        for (String comparer : comparers) {
            if (value.equalsIgnoreCase(comparer)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean in(Character value, Character... characters) {
        for (Character character : characters) {
            if (value == character) {
                return true;
            }
        }
        return false;
    }

    public static Boolean in(Character character, String value) {
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == character) {
                return true;
            }
        }
        return false;
    }

    public static Boolean isLetter(Character character) {
        return Pattern.matches("[a-zA-Záéíóúñ]", String.valueOf(character));
    }

    public static Date dateAdd(Date value, Integer field, Integer add) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        calendar.add(field, add);
        return calendar.getTime();
    }

    /**
     * Diff two dates by theirs day
     *
     * @param arg1
     * @param arg2
     * @return
     */
    public static Integer dayDiff(Date arg1, Date arg2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(arg1);
        Integer i1 = calendar.get(DayOfYear);
        calendar.setTime(arg2);
        Integer i2 = calendar.get(DayOfYear);
        return i1 - i2;
    }

    public static Boolean isAjaxRequest(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }
    public static String toString(User user) {
        StringBuilder sb = new StringBuilder();
 
        sb.append("UserName:").append(user.getUsername());
 
        Collection<GrantedAuthority> authorities = user.getAuthorities();
        if (authorities != null && !authorities.isEmpty()) {
            sb.append(" (");
            boolean first = true;
            for (GrantedAuthority a : authorities) {
                if (first) {
                    sb.append(a.getAuthority());
                    first = false;
                } else {
                    sb.append(", ").append(a.getAuthority());
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }
    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

}
