package problem20;
/*
 * 面试题20：顺时针打印矩阵
 * 思路：一圈一圈打印，再具体到四个边分别打印。
 */
public class PrintMatrixInCircle {
    public void PrintMatrixClockwisely(int[][] a){
        if (a==null) return;
        int rows=a.length;
        int columns=a[0].length;
        int start=0;//起始位置坐标都是(0,0),(1,1)这种
        while (rows > start*2 && columns > start*2) {
            PrintMatrixInCircle(a,rows,columns,start);//从起始位置开始打印一圈
            start++;
        }
    }
    private void PrintMatrixInCircle(int[][] a, int rows, int columns, int start) {
        int endX=columns-start-1;//这一圈的最后一列的下标
        int endY=rows-start-1;//这一圈的最后一行的下标
        for (int i = start; i <= endX; i++){//从左到右 打印起始一行
            System.out.println(a[start][i]);
        }
        if (start < endY) {//从上到下 打印列
            for (int i = start+1; i <=endY; i++) {
                System.out.println(a[i][endX]);
            }
        }
        if (start < endX && start < endY) {//从右到左 打印行
            for (int i = endX-1; i >=start; i--) {
                System.out.println(a[endY][i]);
            }
        }
        if (start < endX && start < endY-1) {//从下到上 打印列
            for (int i = endY-1; i >=start+1; i--){
                System.out.println(a[i][start]);
            }
        }
    }
    public static void main(String[] args) {
        int[][] a={
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12},
                {13,14,15,16}
        };
        PrintMatrixInCircle t=new PrintMatrixInCircle();
        t.PrintMatrixClockwisely(a);
    }
}