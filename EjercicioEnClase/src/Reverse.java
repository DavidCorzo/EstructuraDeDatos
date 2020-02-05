public class Reverse {
    char[] source;
    char[] destination;

    Reverse(){
        source = new char[11]{"H","e","l","l","o"," ","W","o","r","l","d"};
        destination = new char[11];
    }

    public char[] swap(){
        int decrease = this.source.length;
        for ( int i = 0 ; i < this.source.length ; i ++ ) {
            this.destination[decrease] = this.source[i];
            decrease += 1;
        }
        return this.destination;
    }

    public void print(){
        for ( int i = 0 ; i < this.destination.length ; i ++ )
            System.out.println(this.destination[i]);
    }
}
