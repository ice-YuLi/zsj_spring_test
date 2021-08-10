package com.zsj.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineOrHumpTranslate {

    private static Pattern linePattern = Pattern.compile("_(\\w)");
    private static Pattern enterPattern = Pattern.compile("([A-Z]+[\\w]*)\n");

    /** 下划线转驼峰 */
    public static String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
    /** sql insert into */
    public static String enterInsertInto(String str) {
        Matcher matcher = enterPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            sb.append("<isNotEmpty property=\""+lineToHump(matcher.group(1))+"\" prepend=\",\">\n");
            sb.append("\t" + matcher.group(1) + "\n");
            sb.append("</isNotEmpty>\n");
        }
        return sb.toString();
    }
    /** sql insert into value*/
    public static String enterInsertIntoValues(String str) {
        Matcher matcher = enterPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String translateStr = lineToHump(matcher.group(1));
            sb.append("<isNotEmpty property=\""+ translateStr +"\" prepend=\",\">\n");
            sb.append("\t#" + translateStr + ":VARCHAR#\n");
            sb.append("</isNotEmpty>\n");
        }
        return sb.toString();
    }
    /** sql update */
    public static String updateSql(String tableName, String column) {
        Matcher matcher = enterPattern.matcher(column);
        StringBuffer sb = new StringBuffer();
        sb.append("UPDATE ");
        sb.append(tableName);
        sb.append(" SET\n");
        sb.append("<dynamic prepend=\" \">\n");
        while (matcher.find()) {
            String item = matcher.group(1);
            String translateStr = lineToHump(matcher.group(1));
            sb.append("\t<isNotEmpty property=\""+ translateStr +"\" prepend=\",\">\n");
            sb.append("\t\t" + item + "=#" + translateStr + ":VARCHAR#\n");
            sb.append("\t</isNotEmpty>\n");
        }
        sb.append("</dynamic>");
        return sb.toString();
    }
    public static void main(String[] args) {
        String tableName = "PERSPECLIST";
        String columnStr = "LABEL_ID\n" +
                "CLIENT_ID\n" +
                "LABEL_TP_CAT\n" +
                "LABEL_TP_CD\n" +
                "DESCRIPTION\n" +
                "SOURCE_SYS_TP_CD\n" +
                "ACTIVE_IND\n" +
                "START_TMS\n" +
                "END_TMS\n" +
                "LAST_SRC_UPDATE_TMS\n" +
                "LAST_UPDATE_INST\n" +
                "LAST_UPDATE_TLR\n" +
                "LAST_UPDATE_TMS\n" +
                "LAST_UPDATE_CHN\n" +
                "LAST_UPDATE_TXN\n" +
                "LAST_UPDATE_TXN_ID\n" +
                "LAST_ACCOUNT_DATE\n";

//        System.out.println(lineToHump(inputStr));
//        System.out.println(enterInsertInto(inputStr));
//        System.out.println(enterInsertIntoValues(inputStr));
        System.out.println(updateSql(tableName, columnStr));
    }
}
