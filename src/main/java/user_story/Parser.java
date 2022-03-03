package user_story;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
    private HashMap<String, String> asciiToCodeMap = new HashMap<>();

    public Parser() {
        asciiToCodeMap.put(" _ | ||_|", "0");
        asciiToCodeMap.put("     |  |", "1");
        asciiToCodeMap.put(" _  _||_ ", "2");
        asciiToCodeMap.put(" _  _| _|", "3");
        asciiToCodeMap.put("   |_|  |", "4");
        asciiToCodeMap.put(" _ |_  _|", "5");
        asciiToCodeMap.put(" _ |_ |_|", "6");
        asciiToCodeMap.put(" _   |  |", "7");
        asciiToCodeMap.put(" _ |_||_|", "8");
        asciiToCodeMap.put(" _ |_| _|", "9");

    }

    public String getCodeOfAscii(String ascii) {
        return ((ascii.length() != 0) && (ascii != "         ") && (asciiToCodeMap.get(ascii) == null)) ? "?" : asciiToCodeMap.get(ascii);
    }

    public Map<Integer, String> entryToAscii(Entry entry) {
        Map<Integer, String> asciiNumbers = new HashMap<>();
        String element = "";
        for (String line : entry.getLines()) {
            if(!line.equals("")) {
                int i = 0 ;
                for(int index = 0 ; index < 9 ; index++) {
                    asciiNumbers.put(index, asciiNumbers.get(index) != null ? asciiNumbers.get(index).concat(line.substring(i, i+3)) : line.substring(i, i+3));
                    i += 3;
                }
            }
        }
        return asciiNumbers;
    }

    public List<String> getListOfAscii(List<Entry> entries) {
        List<String> asciiStrings = new ArrayList<>();
        for(Entry entry : entries) {
            Map<Integer, String> asciiNumbers = entryToAscii(entry);
            String codeValues = "";
            String codeValue = "";
            String asciiOf = "";
            for (int i = 0; i < asciiNumbers.size(); i++) {
                asciiOf += asciiNumbers.get(i);
                codeValue += getCodeOfAscii(asciiOf);
                if (!(codeValue == null)) {
                    codeValues += codeValue;
                    codeValue = "";
                    asciiOf = "";
                }
            }
            asciiStrings.add(codeValues);
        }
        return asciiStrings;
    }

    public List<Code> asciiToCodes(List<Entry> entries) {
        List<Code> codes = new ArrayList<>();
        List<String> asciiStrings = getListOfAscii(entries);
        for(String asciiString : asciiStrings) {
            Code newCode = new Code(asciiString);
            codes.add(newCode);
        }
        return codes;
    }

}