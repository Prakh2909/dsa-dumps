// java stores string in UTF 16 format similar for ASCII for first 128 characters
// ways to use string mentioned in the program below

public class StringClass {
    public static void main(String[] args) {
        
        char[] charArray = {'a','b','c','d','e'};
        String str = "Whatsupman";//immutable
        String[] stringArray = {"Hello","Whatsup"}; // immutable and thread safe
        StringBuilder stringBuilder = new StringBuilder("Hello"); // mutable but not thread safe
        StringBuffer stringBuffer = new StringBuffer("HAHAHAHA"); // mutable and thread safe

        System.out.println(stringArray);
        System.out.println(stringBuffer);
        System.out.println(stringBuilder);
        System.out.println(str);
        System.out.println(charArray);
    }
}