package Day5Hashing;

public class CheckAnagrams {
    public boolean checkAnagrams(String str1, String str2) {
        int[] count = new int[26];

        for(int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i) - 'a']++;
        }

        for(int i = 0; i < str2.length(); i++) {
            count[str2.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; i++) {
            if(count[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
