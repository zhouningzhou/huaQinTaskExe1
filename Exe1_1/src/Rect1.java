import java.util.Scanner;

public class Rect1 implements Rect {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入选项：\n1.求3*5，5*6，6*8矩阵相乘，请输入  1  \n2.求任意二维矩阵的乘积，请输入 2\n3.退出请输入 3");
        String read;
        while(!((read=sc.nextLine()).contains("3"))){
            process(read);
            System.out.println("输入选项：\n1.求3*5，5*6，6*8请输入  1  \n2.求任意二维矩阵的乘积，请输入 2\n3.退出请输入 3");
        }
    }

    public static void process(String read){
        if(read.contains("1")){
            int a1[][]=new int[3][5];int b1[][]=new int[5][6];int c1[][]=new int[6][8];int[][] d;
            initializeMatrix(a1);initializeMatrix(b1);initializeMatrix(c1);
            int[][] c=MatrixMultiplying(a1,b1);
            if(null!=c)
               d=MatrixMultiplying(c,c1);
            else {
                System.out.println("这两个矩阵不满足相乘的条件");
                return;
            }
            if(null!=d){
                printMatrix(a1);printMatrix(b1);printMatrix(c1);printMatrix(d);
            }
            else{
            printMatrix(a1);printMatrix(b1);printMatrix(c1);
            }
        }
        else if(read.contains("2")){
        int[][] a=createMatrix();a=initializeMatrix(a);
        int[][] b=createMatrix();b=initializeMatrix(b);
        int[][] c=MatrixMultiplying(a,b);
        printMatrix(a);printMatrix(b);
         if(c!=null) printMatrix(c);
         else System.out.println("这两个矩阵不满足相乘的条件");
        }
    }

    public static int[][] createMatrix(){
        int i=(int)(Math.random()*20);
        int a[][]=new int [(int)(Math.random()*20)][(int)(Math.random()*20)]; //随机生成的二维矩阵
        return a;}

    public static int[][] initializeMatrix(int[][] a){
        for(int i=0;i<a.length;i++)
            for (int j = 0; j < a[i].length; j++)
                a[i][j] = (int) (Math.random() * 20);   //元素的大小range(0~20)
        return a;}

    public static void printMatrix(int[][] a){
        String max=getMax(a);
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.printf("%-"+max+"d",a[i][j]);  //20以内的数，格式化输出两位左对齐
                if(j!=a[i].length-1)
                    System.out.print(" ");
                else
                    System.out.print("\n");}}
        System.out.println();
    }

    public static String getMax(int[][] a){   //获取格式化字符串对齐时需要的位数
        int maxInt=0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++)
                if(a[i][j]>maxInt) maxInt=a[i][j];
        }
        return Integer.toString(Integer.toString(maxInt).length());
    }
    public static boolean judgeMatrixforMultiplying(int[][] a,int[][] b) {
        if(a==null ||b==null) return false;
        if (b.length <= 0 || a.length <= 0) return false;
        if (a[0].length != b.length) return false;  //当矩阵a的列数 不等于 b的行数
        else return true;                           //矩阵a的列数 等于 矩阵 b的行数
    }

    public static int[][] MatrixMultiplying(int[][] a,int[][] b){

        if(!judgeMatrixforMultiplying(a,b)){

            return null;}
        try {
                int[][] c = new int[a.length][b[0].length];     //矩阵c的行数等于矩阵a的行数，矩阵c的列数等于矩阵b的列数
                for (int i = 0; i < a.length; i++) {   //确定 矩阵a的行数
                    for (int k = 0; k < b[0].length; k++) {  //确定矩阵b的列数
                        int temp = 0;                      //c矩阵中的一个元素
                        for (int j = 0; j < a[i].length; j++) {        //矩阵a和b  对应 的行列相乘的结果
                            temp += a[i][j] * b[j][k];
                        }
                        c[i][k] = temp;
                    }
                }
                return c;}

            catch (Exception e)
            {
                e.printStackTrace();
            }
            return null;
    }
}
