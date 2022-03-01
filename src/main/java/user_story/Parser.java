package user_story;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
    HashMap<String, String> textToCodeMap = new HashMap<>();

    public Parser() {
        textToCodeMap.put(" _ | ||_|", "0");
        textToCodeMap.put("     |  |", "1");
        textToCodeMap.put(" _  _||_ ", "2");
        textToCodeMap.put(" _  _| _|", "3");
        textToCodeMap.put("   |_|  |", "4");
        textToCodeMap.put(" _ |_  _|", "5");
        textToCodeMap.put(" _ |_ |_|", "6");
        textToCodeMap.put(" _   |  |", "7");
        textToCodeMap.put(" _ |_||_|", "8");
        textToCodeMap.put(" _ |_| _|", "9");

    }

    public String getCodeOfText(String text) {
        if((text.length() !=0) && (text != "         ") && (textToCodeMap.get(text) == null)) return "?";
        return textToCodeMap.get(text);
    }

    public Map<Integer,String> entryToText(Entry entry) {
        Map<Integer,String> textNumbers = new HashMap<>();
        String element = "";
        for (String line : entry.lines) {
            if(!line.equals("")) {
                textNumbers.put(0, textNumbers.get(0)!= null? textNumbers.get(0).concat(line.substring(0, 3)):line.substring(0, 3));
                textNumbers.put(1, textNumbers.get(1)!= null? textNumbers.get(1).concat(line.substring(3, 6)):line.substring(3, 6));
                textNumbers.put(2, textNumbers.get(2)!= null? textNumbers.get(2).concat(line.substring(6, 9)):line.substring(6, 9));
                textNumbers.put(3, textNumbers.get(3)!= null? textNumbers.get(3).concat(line.substring(9, 12)):line.substring(9, 12));
                textNumbers.put(4, textNumbers.get(4)!= null? textNumbers.get(4).concat(line.substring(12, 15)):line.substring(12, 15));
                textNumbers.put(5, textNumbers.get(5)!= null? textNumbers.get(5).concat(line.substring(15, 18)):line.substring(15, 18));
                textNumbers.put(6, textNumbers.get(6)!= null? textNumbers.get(6).concat(line.substring(18, 21)):line.substring(18, 21));
                textNumbers.put(7, textNumbers.get(7)!= null? textNumbers.get(7).concat(line.substring(21, 24)):line.substring(21, 24));
                textNumbers.put(8, textNumbers.get(8)!= null? textNumbers.get(8).concat(line.substring(24, 27)):line.substring(24, 27));
            }
        }
        return textNumbers;
    }


    public List<Code> textToCodes(List<Entry> entries) {
        List<Code> codes = new ArrayList<Code>();
        List<String> textStrings = new ArrayList<String>();
        for(Entry entry : entries) {
            Map<Integer,String> textNumbers = entryToText(entry);
            String codeValues = "";
            String codeValue = "";
            String textOf = "";
            for (int i = 0; i < textNumbers.size(); i ++) {
                textOf += textNumbers.get(i);
                codeValue += getCodeOfText(textOf);
                if (!(codeValue == null)) {
                    codeValues += codeValue;
                    codeValue = "";
                    textOf = "";
                }
            }
            textStrings.add(codeValues);
        }
        for(String textString : textStrings) {
            Code newCode = new Code(textString);
            codes.add(newCode);
        }

        return codes;
    }

}