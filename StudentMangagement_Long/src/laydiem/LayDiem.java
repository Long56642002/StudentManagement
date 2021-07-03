/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laydiem;
import java.util.Scanner;
/**
 *
 * @author LongDinh
 */
public class LayDiem {
    static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int option = 1;
        Manage_Student manage = new Manage_Student();
        System.out.println((char)27+"[31m╔════════════╗\n║"+(char)27+"[31mStudent Management║\n"+(char)27+"[31m╠════════════╝");
        while(option==1){
            int choice = 0;
            System.out.print((char)27+"[31m╠═══"+(char)27+"[32m 1. Insert\n"+(char)27+"[31m╠═══ "+(char)27+"[33m2. Find\n"+(char)27+"[31m╠═══ "+(char)27+"[34m3. Delete\n"+(char)27+"[31m╠═══ "+(char)27+"[35m4. Modify\n"+(char)27+"[31m╠═══ "+(char)27+"[36m5. Statistic of sex\n"+(char)27+"[31m╠═══ "+(char)27+"[36m6. Statistic of age\n"+(char)27+"[31m╠═══ "+(char)27+"[36m7. Statistic of major\n"+(char)27+"[31m╠═══ "+(char)27+"[39m8. Exit\n"+(char)27+"[31m╠═══ Choice: ");
            String choice_ = sc.nextLine();
            while (choice_!=null) {
                if (exException.Check_Valid_Num(choice_) == false) {
                    System.out.print("╠══ Invalid input! Try again! Choice: ");
                    choice_ = sc.nextLine();
                }else if (Integer.parseInt(choice_) < 1 || Integer.parseInt(choice_)> 8) {
                    System.out.print("╠══ Out of this operator! Try again! Choice: ");
                    choice_ = sc.nextLine();
                }
                else {
                    choice = Integer.parseInt(choice_);
                    break;
                }
            }
            switch(choice) {
                case 1:
                    manage.Insert();
                    break;
                case 2:
                    manage.Show_Find();
                    break;
                case 3:
                    manage.Delete();
                    break;
                case 4:
                    manage.Modify();
                    break;
                case 5:
                    manage.Show_Statistic_Sex();
                    break;
                case 6:
                    manage.Show_Statistic_Age();
                    break;
                case 7:
                    manage.Show_Statistic_Major();
                    break;
                case 8:
                    option = 2;
                    break;
            }
        }
        System.out.println((char)27+"[31m╠══════════════════╗\n"+(char)27+"[31m║    Goodbye and see you soon!   ║\n"+(char)27+"[31m╚══════════════════╝");
    }
}