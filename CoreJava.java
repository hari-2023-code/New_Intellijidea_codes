import java.util.HashSet;
public class CoreJava {
    public static void main (String[] args){
        HashSet<String> HashSet=
                new HashSet <String>();
        HashSet.add("john");
        HashSet.add ("kevin");
        HashSet.add("sam");
        HashSet.add(" ");
        HashSet.remove ("sam");
        for (String name: HashSet){
            System.out.println(name);
        }
    }
}
