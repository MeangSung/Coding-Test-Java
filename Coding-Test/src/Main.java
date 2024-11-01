public class Main {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        //얕은 복사
        int[][] b =a.clone();
        System.out.print("a,b 배열안의 배열주소 비교 : ");
        System.out.println(b == a? "같습니다" : "다릅니다");
        for(int i = 0; i < b.length; i++){
            System.out.print("a,b 배열안의 배열의 값 주소 비교 : ");
            System.out.println(b[i] == a[i]? "같습니다" : "다릅니다");
        }
        System.out.println();

        //깊은 복사
        int[][] c = new int[a.length][a[0].length];
        for(int i=0;i<a.length;i++){
            c[i]=a[i].clone();
        }
        System.out.print("a,c 배열안의 배열주소 비교 : ");
        System.out.println(c==a? "같습니다" : "다릅니다");
        for(int i = 0; i < c.length; i++){
            System.out.print("a,c 배열안의 배열의 값 주소 비교 : ");
            System.out.println(c[i] == a[i]? "같습니다" : "다릅니다");
        }
        System.out.println();
    }
}