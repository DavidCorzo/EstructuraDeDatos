import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Stack {
    public class ObjectArray {
        String content;
        String date;
        ObjectArray(String param) {
            LocalDateTime requeriment1 = LocalDateTime.now();
            DateTimeFormatter requirement2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            this.date = requeriment1.format(requirement2).toString();
            this.content = param;
        }
    }

    ObjectArray[] Master;
    int Counter = 0;
    int CurrentElements = 1;


//    @GetMapping("/push")
//    @ResponseBody
    public String push ( String p) {
        ObjectArray temporary_insert = new ObjectArray(p);
        temporary_insert.content = p;
        this.CurrentElements += 1;
        ObjectArray[] NplusOne = new ObjectArray[this.CurrentElements];
        NplusOne[this.Counter] = temporary_insert;
        this.Master = NplusOne;
        this.Counter += 1;
        return p;
    }

//    @GetMapping("/print")
//    @ResponseBody
    public int print () {
        String s = new String();
        for ( int i = 0 ; i < this.Master.length - 1; i ++ ) {
            s = s + "[" + i + "] " + this.Master[i].content + " : " + this.Master[i].date;
            System.out.println(s);
        }
        return this.Master.length;
    }


}