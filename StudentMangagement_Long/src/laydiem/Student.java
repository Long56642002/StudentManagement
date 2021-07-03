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
public class Student extends Person{
    String StuID;
    String MajorID;
    Scanner sc = new Scanner(System.in);
    @Override
    void Input() {
        super.Input();
        if (p_Name.toUpperCase().equals("Done".toUpperCase())) {
            System.out.println("║\t║\t╚══ -*-Stop adding data and finish!-*-");
        }
        else {
            System.out.print("║\t║\t╠══ Enter student ID (Enter \"Done\" to STOP): ");
            StuID = sc.nextLine();
            if (StuID.toUpperCase().equals("Done".toUpperCase())) System.out.println("║\t║\t╠══ Done!\n║\t║\t╚══ -*-Stop adding data and finish!-*-");
            else {
                System.out.print("║\t║\t╠══ Enter major ID (Enter \"Done\" to STOP): ");
                MajorID = sc.nextLine();
                if (MajorID.toUpperCase().equals("Done".toUpperCase())) System.out.println("║\t║\t╠══ Done!\n║\t║\t╚══ -*-Stop adding data and finish!-*-");
            }
        }
    }
    @Override
    void Output() {
        super.Output();
        System.out.println("║\t║\t\t╠══ ID: "+StuID);
        System.out.println("║\t║\t\t╠══ Major: "+MajorID);
    }
}