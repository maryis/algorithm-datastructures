package interview.jsonparser;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String key="abc";
        Scanner scanner=new Scanner(System.in);
        scanner.useDelimiter("");//it makes next to return a char at a time

        JsonParser jsonParser=new JsonParser(scanner);

        System.out.println("Please enter the json:");
        while(jsonParser.hasToken()){
            Item item=jsonParser.next();
            if(item!=null) {
                System.out.println(item);
                if (item.getKey().equals(key)) {
                    System.out.println(item.value);
                }
            }
            else break;
        }
        System.out.println("End");
    }
}
