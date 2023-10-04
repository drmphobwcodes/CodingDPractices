package Day6Recursion;

public class VAlidParenthesis {
    public boolean validParenthesis(String s) {
        if(s.length() == 0) {
            return true;
        }

        if(s.length() == 1) {
            return false;
        }

        if(s.charAt(0) == '(' && s.charAt(s.length() - 1) == ')') {
            return validParenthesis(s.substring(1, s.length() - 1));
        }

        return false;
    }
}
