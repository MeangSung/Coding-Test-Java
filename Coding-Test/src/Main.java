public class Main {
    public static void main(String[] args) {

        System.out.println(func(6,100,5));


    }

    private static  long func(long a, long b, long c){
        long val =1 ;
        while(b-- >= 0) val = val * a % c;
        return val;
    }
}