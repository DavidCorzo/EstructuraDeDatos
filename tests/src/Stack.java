public class Stack {
    double[] some_double = new double[25];

    public String ret() {
        String s = new String();
        for ( int i = 0 ; i < some_double.length - 10 ; i ++ ) {
            some_double[i] = i;
            System.out.println(some_double[i]);
        }
        for ( int i = 0 ; i < some_double.length ; i ++ ) {
            System.out.println(some_double[i]);
        }
        return s;
    }
}