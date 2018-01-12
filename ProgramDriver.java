import java.util.Scanner;

public class ProgramDriver {
    public static void main(String[] args){
        HashTable<Integer,String> table = new HashTable<>();
        Scanner kbIn = new Scanner(System.in);

        for(int i = 0; i < 3; i++){
            System.out.println("Yo, enter a key. Ya stupid mutt");
            int key = kbIn.nextInt();
            kbIn.nextLine();
            System.out.println("Yo, enter a value. Ya stupid mutt");
            String value = kbIn.nextLine();

            table.add(key,value);
        }

        System.out.println("Done! Now enter a key to get a value");

        while(true){
            int key = kbIn.nextInt();

            System.out.println(table.find(key));

            System.out.println("Enter a key to get a value");
        }
    }
}
