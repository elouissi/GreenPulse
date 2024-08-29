import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main (String[] args){
        String name = "Yassin";
        System.out.println(Math.max(5,6));
        System.out.println(name.length());
        System.out.print("heel"+ name.toLowerCase());
        LocalDateTime    now = LocalDateTime.now();
        System.out.println(now.getMinute());

        boolean isTrue = true;
        boolean isFalse = false;
        System.out.println(isTrue || isFalse);
        System.out.println(isTrue && isFalse);
    }
}