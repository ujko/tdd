package newTest;

public class Binary {
    public String method(int a){
        String result = "";
        if(a<0){
            throw new IllegalArgumentException("Argument nie moze miec wartoci ujemnej");
        }
        while(a >0){
            result = a%2 + result;
            a = a/2;

        }
        return  result.equals("")?"0":result;
    }
    public int binaryZero(String a) {
        String temporaryString = a.substring(a.indexOf("1"), a.lastIndexOf("1") + 1);
        String[] binaryTable = temporaryString.split("1");
        int result = 0;
        for(String s: binaryTable){
            int length = s.length();
            if(length > result){
                result = length;
            }
        }
        return result;
    }
}
