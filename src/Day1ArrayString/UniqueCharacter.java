package Day1ArrayString;

public class UniqueCharacter {

    public static void main(String[] args) {
        String str = "abcde";
        System.out.println(isUnique(str));
    }

    public static boolean isUnique(String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i); // get the ASCII value of the character
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
}
