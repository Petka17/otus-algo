import model.*;

// import java.util.Date;

public class Program {

    public static void main(String[] args) {
        // IArray<Integer> singleArray = new SingleArray<Integer>();
        // IArray<Integer> vectorArray = new VectorArray<Integer>(2);
        // IArray<Integer> factorArray = new FactorArray<Integer>(50, 3);
        // IArray<Date> matrixArray = new MatrixArray<Date>();

        // testNewFunc(factorArray);
        // testAddArray(singleArray, 10_000);
        // testAddArray(vectorArray, 100_000);
        // testAddArray(factorArray, 100_000);
        // testAddArray(matrixArray, 100_000);

        System.out.print(nod(1234567890, 12));
        System.out.print(pow(1.000001, 1_000_000));
    }

    private static double pow(double base, int power) {
        double t = base;

        int j;
        for (j = 1; j < power / 2; j *= 2)
            t *= t;

        for (; j <= power; j++) {
            t *= base;
        }

        return t;
    }

    private static int nod(int x, int y) {
        int a = x;
        int b = y;

        while (a != 0 && b != 0) {
            if (a > b)
                a = a % b;
            else
                b = b % a;
        }

        return Math.max(a, b);
    }
    // private static void testNewFunc(IArray<Integer> arr) {
    // arr.add(0); // [0]
    // arr.remove(0); // []
    // arr.add(0); // [0]
    // arr.add(1); // [0, 1]
    // arr.add(4); // [0, 1, 4]
    // arr.add(2, 2); // [0, 1, 2, 4]
    // arr.add(3, 3); // [0, 1, 2, 3, 4]
    // arr.remove(0); // [1, 2, 3, 4]
    // arr.remove(3); // [1, 2, 3]
    // arr.remove(1); // [1, 3]
    // }

    // private static void testAddArray(IArray<Integer> data, int total) {
    // long start = System.currentTimeMillis();

    // for (int j = 0; j < total; j++)
    // data.add(j);

    // System.out.println(data + " testAddArray: " + (System.currentTimeMillis() -
    // start));
    // }

    // private static void testAddAtArray(IArray<Integer> data, int total) {
    // long start = System.currentTimeMillis();

    // data.add(0);

    // for (int j = 0; j < total; j++)
    // data.add(j, data.size() / 2);

    // System.out.println(data + " testAddAtArray: " + (System.currentTimeMillis() -
    // start));
    // }
}
