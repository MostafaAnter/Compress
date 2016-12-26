package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(compress("bb"));
    }

    public static String compress(String input){

        // split string to sup strings
        Matcher matcher = Pattern.compile("(\\w)\\1*").matcher(input);
        List<String> groupsList = new ArrayList<>();
        while (matcher.find()){
            groupsList.add(matcher.group());
        }

        // convert each group to this format cN  c mean character and
        // n count of char
        for (int i = 0; i < groupsList.size(); i++) {
            String group = groupsList.get(i);
            group = group.charAt(0) + "" + group.length() + "" ;
            groupsList.remove(i);
            groupsList.add(i, group);
        }

        // concat all group and do simple check ;)
        StringBuilder finalResult = new StringBuilder();
        for (int i = 0; i < groupsList.size(); i++) {
            finalResult.append(groupsList.get(i));
        }
        return input =
                finalResult.toString().length() < input.length()?
                        finalResult.toString(): input;
    }
}
