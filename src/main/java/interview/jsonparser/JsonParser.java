package interview.jsonparser;

import java.util.Scanner;

import static interview.jsonparser.ValueType.*;

public class JsonParser {

    private Scanner scanner;

    public JsonParser(Scanner scanner) {
        this.scanner=scanner;
    }

    public boolean hasToken() {
        return scanner.hasNext();

    }

    public Item next() {
        Item item=new Item();
        String key=getKey(scanner);
        if(key==null)
            return null;
        item.setKey(key);

        char next=  scanner.next().charAt(0);
        ValueType type=getType(next);

        Object value=null;
        switch (type){
//            case NUMBER:
//                value=readNumber();
            case STRING:
                item.setValueType(STRING);
                value=readString();
//            case BOOLEAN:
//            case ARRAY:
//            case OBJECT:

        }
        item.setValue(value);
        return item;
    }

    private String readString() {
        char next=  scanner.next().charAt(0);

        while (next==' '||next==':' || next=='"')//move to readValue
            next= (char) scanner.next().charAt(0);

        StringBuilder value=new StringBuilder();
        while (next!='"') {
            value.append(next);
            next = (char) scanner.next().charAt(0);
        }
        return value.toString();

    }

    private String getKey(Scanner scanner) {
        char next=  scanner.next().charAt(0);

        while(next==' '||next=='"' || next=='{' || next==',')//begin characters
            next= (char) scanner.next().charAt(0);

        if(next=='}')
            return null;
        StringBuilder key=new StringBuilder();
        while (next!='"') {
            key.append(next);
            next = (char) scanner.next().charAt(0);
        }
        return key.toString();
    }

    private ValueType getType(char next) {
        if(next=='"')
            return STRING;
        if(next=='{')
            return OBJECT;
        if(next=='[')
            return ARRAY;

        return STRING;
    }

}
