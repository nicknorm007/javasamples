package demo;

import com.google.common.collect.ImmutableMap;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordHelpers
{
    public String returnSingleWordFromWords(String input)
    {
        String pattern = "(\\b\\w+\\b)(\\s*\\1\\b)+";
        Pattern r = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        String single = "";

        Matcher m = r.matcher(input);
        while(m.find( )){
            single = input.replaceAll(m.group(), m.group(1));
        }
        return single;

    }
    public Map<String, Integer> wordCount(String[] strings) {

        Map<String, Integer> map = new HashMap<String, Integer>();

        Arrays.asList(strings).forEach(str-> {

            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }

        });

        return map;

    }
    public String[] allSwap(String[] strings) {

        int[] swapped = new int[ strings.length ];
        for(int i=1;i<strings.length;i++)
        {

            for(int j=i-1;j>=0;j--)
            {
                if(swapped[i]==1 && swapped[j]==1) continue;

                if(strings[i].substring(0,1)
                        .equals(strings[j].substring(0,1)))
                {
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                    swapped[i] = 1;
                    swapped[j] = 1;

                }

            }


        }
        return strings;

    }
    public List<Integer> doubling(List<Integer> nums) {

        Integer[] array = nums.stream().toArray(Integer[]::new);

        List<Integer> timesTwo = Stream.of(array).map(n -> n * 2)
                .collect(Collectors.toList());

        return timesTwo;


    }
    public String addChar(String str, char ch, int position) {
        int len = str.length();
        char[] updatedArr = new char[len + 1];
        str.getChars(0, position, updatedArr, 0);
        updatedArr[position] = ch;
        str.getChars(position, len, updatedArr, position + 1);
        return new String(updatedArr);
    }
    public int countYZ(String str) {

        String[] eachWord = str.split("\\s+");
        int count =0;

        for(String s : eachWord)
        {

            if(s.matches("(.*)(z|y)$"))
            {
                count++;
            }


        }
        return count;

    }





}