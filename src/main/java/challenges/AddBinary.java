package challenges;

public class AddBinary{
    public static String addBinary (String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        int length1 = str1.length() - 1;
        int length2 = str2.length() - 1;
        int carry = 0;

        while(length1 >= 0 || length2 >= 0){
            int sum = carry;

            if(length1 >= 0)
                sum += str1.charAt(length1) - '0';

            if(length2 >= 0)
                sum += str2.charAt(length2) - '0';

            sb.append(sum % 2);
            carry = sum /2;

            length1--;
            length2--;
        }

        if(carry != 0)
            sb.append(carry);

        return sb.reverse().toString();
    }

    public  static void main(String[] args) {
        System.out.println(addBinary("001", "100"));
    }
}