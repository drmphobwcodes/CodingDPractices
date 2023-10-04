package Day5Hashing;

public class FirstNonRepeatCharacter {
    public char firstNonRepeatCharacter(String str) {
        int[] count = new int[26];

        for(int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }

        for(int i = 0; i < str.length(); i++) {
            if(count[str.charAt(i) - 'a'] == 1) {
                return str.charAt(i);
            }
        }

        return '0';
    }
}
