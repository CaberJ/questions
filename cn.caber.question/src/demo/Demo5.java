package demo;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Stack;

/**
 * 栈的使用
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断该字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 1, 左括号必须用相同类型的右括号闭合。
 * 2, 左括号必须以正确的顺序闭合。
 * <p>
 * 比如 "()"、"()[]{}"、"{[]}" 都是有效字符串，而 "(]" 、"([)]" 则不是。
 */
public class Demo5 {
    public static void main(String[] args) {
        Boolean res = null;
        String s = "({[()]})";
        String s1 = "({[()]}";
        String s2 = "()";
        String s3 = "(]";
        System.out.println(judge(s));
    }

    public static boolean judge(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> charStack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (map.values().contains(aChar)) {
                charStack.push(aChar);
            } else if (map.keySet().contains(aChar)) {
                Character pop = charStack.pop();
                if (pop == null || !pop.equals(map.get(aChar))) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return charStack.empty();
    }


}
