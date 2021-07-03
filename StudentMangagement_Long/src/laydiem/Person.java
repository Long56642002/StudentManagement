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
public class Person {
    Scanner sc = new Scanner(System.in);
    String p_Name = "";
    String p_Birth;
    int p_Sex = 0;
    void Input() {
        System.out.print("║\t║\t╠══ Enter name (Enter \"Done\" to STOP): ");
        p_Name = sc.nextLine();
        while(true){
            if(exException.Check_Name(p_Name)==true) break;
            else {
                System.out.print("║\t║\t╠══ Invalid name!Try again : ");
                p_Name = sc.nextLine();
            }
        }
        if (p_Name.toUpperCase().equals("Done".toUpperCase())) System.out.println("║\t║\t╠══ Done!");
        else {
            System.out.print("║\t║\t╠══ Enter date of birth (dd/mm/yyyy): ");
            String p_Birth_ = sc.nextLine();
            while (p_Birth_!=null) {
                if (exException.Check_Date(p_Birth_)==false||exException.Check_Month_Valid(p_Birth_)==false) {
                    System.out.print("║\t║\t╠══ Invalid date!Try again : ");
                    p_Birth_ = sc.nextLine();
                }
                else {
                    p_Birth = p_Birth_;
                    break;
                }
            }
            System.out.print("║\t║\t╠══ 1. Male - 2. Female: ");
            String p_Sex_ = sc.nextLine();
            while (p_Sex_!=null) {
                if (exException.Check_Valid_Num(p_Sex_)==false) {
                    System.out.print("║\t║\t╠══ Error formatting data!Try again : ");
                    p_Sex_ = sc.nextLine();
                }
                else if (Integer.parseInt(p_Sex_)!=1 && Integer.parseInt(p_Sex_)!=2) {
                    System.out.print("║\t║\t╠══ Invalid data!Try again : ");
                    p_Sex_ = sc.nextLine();
                }else {
                    p_Sex = Integer.parseInt(p_Sex_);
                    break;
                }
            }
        }
    }
    void Output() {
        System.out.println("║\t║\t\t╠══ Name: "+p_Name);
        System.out.println("║\t║\t\t╠══ Date of birth: "+p_Birth);
        if (p_Sex == 1) System.out.println("║\t║\t\t╠══ Sex: Male");
        else System.out.println("║\t║\t\t╠══ Sex: Female");
    }
}