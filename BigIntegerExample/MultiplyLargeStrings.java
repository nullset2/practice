import java.math.BigInteger;

class MultiplyLargeStrings{
    public static void main(String[] args){
        String s1 = "123123123123123123123123123123123123";
        String s2 = "999988887777666655554444333322221111";

        BigInteger n1 = new BigInteger(s1);
        BigInteger n2 = new BigInteger(s2);

        System.out.println(new String(n1.multiply(n2).toString()));
    }
}
