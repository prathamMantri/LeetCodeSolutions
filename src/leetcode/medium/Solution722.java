package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution722 {

    public List<String> removeCommentsOld(String[] code) {
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
  /*  public List<String> removeComments(String[] code){

        boolean singleLine = false;
        boolean multiLine = false;

        StringBuilder res;
        List<String> result = new ArrayList<>();

        for(int i=0; i<code.length; i++){
            res = new StringBuilder();
            String line = code[i];
            int j=0;
            while(j<line.length()-1){
                if(singleLine)
                    break;
                char current = line.charAt(j);
                char next = line.charAt(++j);
                if(!singleLine && !multiLine){
                    if(current == '/'){
                        if(next == '/')
                            singleLine = true;
                        else if(next == '*')
                            multiLine = true;
                        else{
                            res.append(current);
                        }
                    }else{
                        res.append(current);
                    }
                }else if(multiLine){
                    if(current == '*'){
                        if(next == '/'){
                            multiLine = false;
                        }
                    }
                }
                if(!singleLine && !multiLine && j==line.length()-1){
                    if(current == '*' && next == '/')
                        res.append("");
                    else
                        res.append(next);
                }
            }
            singleLine = false;
            result.add(res.toString());
        }
        return result;
    }*/


    // Official Solution from Leetcode

    public List<String> removeComments(String[] source) {
        boolean inBlock = false;
        StringBuilder newline = new StringBuilder();
        List<String> ans = new ArrayList();
        for (String line : source) {
            int i = 0;
            char[] chars = line.toCharArray();
            if (!inBlock) newline = new StringBuilder();
            while (i < line.length()) {
                if (!inBlock && i + 1 < line.length() && chars[i] == '/' && chars[i + 1] == '*') {
                    inBlock = true;
                    i++;
                } else if (inBlock && i + 1 < line.length() && chars[i] == '*' && chars[i + 1] == '/') {
                    inBlock = false;
                    i++;
                } else if (!inBlock && i + 1 < line.length() && chars[i] == '/' && chars[i + 1] == '/') {
                    break;
                } else if (!inBlock) {
                    newline.append(chars[i]);
                }
                i++;
            }
            if (!inBlock && newline.length() > 0) {
                ans.add(new String(newline));
            }
        }
        return ans;
    }


}






