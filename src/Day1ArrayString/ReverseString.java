package Day1ArrayString;

public class ReverseString {

        public static void main(String[] args) {
            String str = "abcde";
            System.out.println(reverse(str));
        }

        public static String reverse(String str) {
            char[] charArray = str.toCharArray();
            int start = 0;
            int end = charArray.length - 1;
            while (start < end) {
                char temp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = temp;

                start++;
                end--;
            }
            return new String(charArray);
        }
}
