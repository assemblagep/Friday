package infrastructure.spring.service;

import infrastructure.spring.model.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressParser {

    public Address parseAddress(String address) {
        StringBuffer resStreet = new StringBuffer("");
        StringBuffer resNumber = new StringBuffer("");

        String[] splitString = (deleteDoubleSpacesAndCommas(address).split("\\s+"));
        int arrayLength = splitString.length;

        for(int i =0; i < arrayLength; i ++) {
            String subString = splitString[i];
            if (isNumber(subString)) { //building number, check if it has additional letter
                resNumber.append(subString);
                if ((i + 1) < arrayLength) { // the array has more elements
                    if (checkComplexNumber(resNumber,splitString[i + 1]))
                        i++;
                }
            }else // street
                resStreet.append(subString).append(" ");
        }
        return new Address(resStreet.toString().trim(), resNumber.toString());
    }

    private String deleteDoubleSpacesAndCommas(String s) {
        return s.replaceAll(","," ").replaceAll("  "," ");
    }
    private boolean isNumber(String s) {
        return s.matches("[0-9]+[a-zA-Z]?");
    }

    private boolean checkComplexNumber(StringBuffer resNumber, String nextSubString) {
        boolean complexNumer = nextSubString.length() ==1;
        resNumber.append(complexNumer ? nextSubString : "");
        return complexNumer;
    }
}
