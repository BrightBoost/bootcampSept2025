package org.example;

public class StringExplanation {
    public static void main(String[] args) {
        String s = "blabla";
        String s2 = new String("blabla");

        boolean same = s == s2; // is it the same block memory?
        System.out.println(same);

        // are the contents equal?
        boolean sameContent = s.equals(s2);
        System.out.println(sameContent);

        int i1 = 8;
        int i2 = 8;
        boolean notEqual = i1 != i2;
        System.out.println(notEqual);

        String code = "1234-abc-bla";
        String[] subCodes = code.split("-"); // {"1234","abc", "bla"}
        System.out.println(subCodes[1]);

        System.out.println(code.contains("123"));


    }
}
