package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution722 {
    public static void main(String[] args) {
        Solution722 sol = new Solution722();
        //String[] code = {"void func(int k) {", "// this function does nothing /*", "   k = k*2/4;", "   k = k/2;*/", "}"};
        String[] code = {"main() {", "   func(1);", "   /** / more comments here", "   float f = 2.0", "   f += f;", "   cout << f; */", "}"};
        //String[] code = {"a/*comment", "line", "more_comment*/b"};
        //String[] code = {"struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};"};
        //String[] code = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};

        System.out.println(sol.removeComments(code));
    }

    public List<String> removeComments(String[] code) {
        if (code == null || code.length == 0) {
            return null;
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean block = false;
        boolean line = false;

        for (String lineCode : code) {
            if (!block)
                sb = new StringBuilder();
            for (int j = 0; j < lineCode.length(); j++) {
                if (lineCode.charAt(j) == '/') {
                    if (j + 1 < lineCode.length()) {
                        if (lineCode.charAt(j + 1) == '*') {
                            if (!line) {
                                block = true;
                                j = j + 2;
                            }
                        } else if (lineCode.charAt(j + 1) == '/')
                            if (!block) {
                                line = true;
                                j = j + 2;
                            }
                    }
                }
                if (lineCode.charAt(j) == '*') {
                    if (j + 1 < lineCode.length()) {
                        if (lineCode.charAt(j + 1) == '/') {
                            if (!block && !line) {
                                sb.append("*/");
                            }
                            if (!line) {
                                block = false;
                                j = j + 1;
                            }
                        } else {
                            if (!block)
                                sb.append("*");
                        }
                    }
                } else if (!block && !line) {
                    sb.append(lineCode.charAt(j));
                }
            }
            if (!sb.toString().equals("") && !block)
                res.add(sb.toString());
            line = false;
        }
        return res;
    }


}






