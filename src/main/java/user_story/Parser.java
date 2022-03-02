package user_story;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
    private HashMap<String, String> textToCodeMap = new HashMap<>();

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
        return ((text.length() != 0) && (text != "         ") && (textToCodeMap.get(text) == null)) ? "?" : textToCodeMap.get(text);
    }

    public Map<Integer, String> entryToText(Entry entry) {
        Map<Integer, String> textNumbers = new HashMap<>();
        String element = "";
        for (String line : entry.getLines()) {
            if(!line.equals("")) {
                int i = 0 ;
                for(int index = 0 ; index < 9 ; index++) {
                    textNumbers.put(index, textNumbers.get(index) != null ? textNumbers.get(index).concat(line.substring(i, i+3)) : line.substring(i, i+3));
                    i += 3;
                }
            }
        }
        return textNumbers;
    }

    public List<String> getListOfNumbersFromText(List<Entry> entries) {
        List<String> textStrings = new ArrayList<>();
        for(Entry entry : entries) {
            Map<Integer, String> textNumbers = entryToText(entry);
            String codeValues = "";
            String codeValue = "";
            String textOf = "";
            for (int i = 0; i < textNumbers.size(); i++) {
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
        return textStrings;
    }

    public List<Code> textToCodes(List<Entry> entries) {
        List<Code> codes = new ArrayList<>();
        List<String> textStrings = getListOfNumbersFromText(entries);
        for(String textString : textStrings) {
            Code newCode = new Code(textString);
            codes.add(newCode);
        }
        return codes;
    }

}