/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laydiem;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author LongDinh
 */
public class Manage_Student {
    Student[] student_List;
    int i;
    int n = 0;
    Scanner sc = new Scanner(System.in);
    void Show_List() {
        for (i = 0; i < n; i++) student_List[i].Output();
    }
    void Insert() {
        if (exException.Check_List_Empty(n)==true){
            System.out.println("║\t╠══ Insert students to the list!\n║\t╠══ Enter information of the first student to the list ");
            n = 1;
            student_List= new Student[n];
            for (i = 0; i < n; i++) {
                student_List[n-1] = new Student();
                student_List[n-1].Input();
            }
            System.out.println("║\t╚══ Insert successfully!");
        }else {
            System.out.println("║\t╠══ Insert new student to the student list");
            do {
                Student[] copy = new Student[n+1];
                for (i = 0; i < n; i++) {
                    copy[i] = student_List[i];
                }
                n+=1;
                student_List = new Student[n];
                student_List = copy;
                student_List[n-1] = new Student();
                student_List[n-1].Input();
                System.out.println("║\t║\t╳-------------------------------------");
            }while (!student_List[n-1].p_Name.toUpperCase().equals("Done".toUpperCase())&&!student_List[n-1].StuID.toUpperCase().equals("Done".toUpperCase())&&!student_List[n-1].MajorID.toUpperCase().equals("Done".toUpperCase()));
            n -= 1;
            System.out.println("║\t╚══ Insert successfully!");
        }
    }
    Student[] Find_by_name() {
        System.out.print("║\t║\t╚══ Enter name of the student you want to find: ");
        String find_name = sc.nextLine();
        int content_found = 0;
        Student copy[] = new Student[n];
        for (i = 0; i < n; i++) {
            if (student_List[i].p_Name.toUpperCase().contains(find_name.toUpperCase())){
                copy[content_found] = student_List[i];
                content_found += 1;
            }
        }
        if (content_found == 0) return null;
        Student[] list_content_found = new Student[content_found];
        for (i = 0; i < content_found; i++) {
            list_content_found[i] = copy[i];
        }
        return list_content_found;
    }
    Student Find_by_ID() {
        System.out.print("║\t║\t╠══ Enter ID of the student you want to find: ");
        String find_ID = sc.nextLine();
        Student find = null;
        for (int i = 0; i < n; i++) {
            if (student_List[i].StuID.equals(find_ID)) {
                find = student_List[i];
                break;
            }
        }
        return find;
    }
    int Select_Option_Find() {
        int op_find = 0;
        if (exException.Check_List_Empty(n)==true) System.out.println("║\t╚══ There is no student to execute!");
        else {
            System.out.print("║\t╠══ 1. Find by name\n║\t╠══ 2. Find by ID\n║\t╠══ Your option: ");
            String op = sc.nextLine();
            while (op!=null) {
                if (exException.Check_Valid_Num(op)==false) {
                    System.out.print("║\t╠══ Error formatting option!Try again! Your option: ");
                    op = sc.nextLine();
                }
                else if (Integer.parseInt(op)!=1 && Integer.parseInt(op)!=2) {
                    System.out.print("║\t╠══ Invalid option!Try again! Your option: ");
                    op = sc.nextLine();
                }else {
                    op_find = Integer.parseInt(op);
                    break;
                }
            }
        }
        return op_find;
    }
    void Show_Find() {
        int x = Select_Option_Find();
        switch(x){
            case 1:
                Student[] find_name = Find_by_name();
                if (find_name==null) System.out.println("║\t╚══ Found Failed");
                else {
                    System.out.println("║\t║\t\t╳=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    for (Student item: find_name) {
                        item.Output();
                        System.out.println("║\t║\t\t╳----------------------------");
                    }
                    System.out.println("║\t╚══ Found successfully!");
                }
                
                break;
            case 2:
                Student find_ID = Find_by_ID();
                if (find_ID==null) System.out.println("║\tFound Failed");
                else {
                    System.out.println("║\t║\t╚══ Founded Student(s):");
                    find_ID.Output();
                    System.out.println("║\t║\t\t╳----------------------------");
                    System.out.println("║\t╚══ Found successfully!");
                }
                break;
        }
    }
    void Delete() {
        Student stu_del = Find_by_ID();
        if (stu_del==null) System.out.println("║\t╚══ There is no student in here!");
        else {
            int c;
            for (c = i = 0; i < n; i++) {
                if (student_List[i] != stu_del) {
                    student_List[c] = student_List[i];
                    c++;
                            
                }
            }
            n = c;
            System.out.println("║\t╚══ Delete successfully!");
        }
    }
    void Modify() {
        Student find_modify = Find_by_ID();
        if (find_modify == null) System.out.println("║\t╚══ There is not this student in list!");
        else {
            for (i = 0; i < n; i++) {
                if (student_List[i]==find_modify) {
                    int modify = 1;
                    while (modify==1) {
                        System.out.print("║\t║\t╠══ Which information do you want to modify?\n║\t║\t╠══ 1. Name\n║\t║\t╠══ 2. Date of birth\n║\t║\t╠══ 3. Sex\n║\t║\t╠══ 4. ID\n║\t║\t╠══ 5. Major\n║\t║\t╠══ Your choice: ");
                        String cv_ = sc.nextLine();
                        int cv = 0;
                        int loop = 1;
                        while (loop == 1) {
                            if (cv_==null) {
                                System.out.print("║\t║\t╠══ You still do not enter anything!Please try again! Your choice: ");
                                cv_ = sc.nextLine();
                            }else if (exException.Check_Valid_Num(cv_)==false || Integer.parseInt(cv_) < 1 || Integer.parseInt(cv_) > 5) {
                                System.out.print("║\t║\t╠══ Invalid data!Try again! Your choice: ");
                                cv_ = sc.nextLine();
                            }else {
                                cv = Integer.parseInt(cv_);
                                break;
                            }
                        }
                        switch(cv) {
                            case 1:
                                System.out.print("║\t║\t║\t╠══ Modify name : ");
                                student_List[i].p_Name = sc.nextLine();
                                System.out.println("║\t║\t║\t╚══ Modify successfully!");
                                break;
                            case 2:
                                System.out.print("║\t║\t║\t╠══ Modify date of birth (dd/mm/yyyy): ");
                                String p_Birth_ = sc.nextLine();
                                while (p_Birth_!=null) {
                                    if (exException.Check_Date(p_Birth_)==false||exException.Check_Month_Valid(p_Birth_)==false) {
                                        System.out.print("║\t║\t║\t╠══ Invalid date!Try again: ");
                                        p_Birth_ = sc.nextLine();
                                    }
                                    else {
                                        student_List[i].p_Birth = p_Birth_;
                                        break;
                                    }
                                }
                                System.out.println("║\t║\t║\t╚══ Modify successfully!");
                                break;
                            case 3:
                                System.out.print("║\t║\t║\t╠══ Modify sex (1. Male - 2. Female): ");
                                String p_Sex_ = sc.nextLine();
                                while (p_Sex_!=null) {
                                    if (exException.Check_Valid_Num(p_Sex_)==false) {
                                        System.out.print("║\t║\t║\t╠══ Error formatting data!Try again: ");
                                        p_Sex_ = sc.nextLine();
                                    }
                                    else if (Integer.parseInt(p_Sex_)!=1 && Integer.parseInt(p_Sex_)!=2) {
                                        System.out.print("║\t║\t║\t╠══ Invalid data!Try again : ");
                                        p_Sex_ = sc.nextLine();
                                    }else {
                                        student_List[i].p_Sex = Integer.parseInt(p_Sex_);
                                        break;
                                    }
                                }
                                System.out.println("║\t║\t║\t╚══ Modify successfully!");
                                break;
                            case 4:
                                System.out.print("║\t║\t║\t╠══ Modify ID: ");
                                student_List[i].StuID = sc.nextLine();
                                System.out.println("║\t║\t║\t╚══ Modify successfully!");
                                break;
                            case 5:
                                System.out.print("║\t║\t║\t╠══ Modify Major: ");
                                student_List[i].MajorID = sc.nextLine();
                                System.out.println("║\t║\t║\t╚══ Modify successfully!");
                                break;
                        }
                        System.out.print("║\t║\t╠══ Do you want to continue modify information of this student (1. Yes - 2. No)? ");
                        String modify_ = sc.nextLine();
                        while (modify_!=null){
                            if (exException.Check_Valid_Num(modify_)==false||(Integer.parseInt(modify_)!=1&&Integer.parseInt(modify_)!=2)) {
                                System.out.print("║\t║\t╠══ Error formating data!Try again: ");
                                modify_ = sc.nextLine();
                            }
                            else {
                                modify = Integer.parseInt(modify_);
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println("║\t╚══ Stop modifying!");
        }
    }
    int Count_Sex(int sex) {
        int count = 0;
        for (i = 0; i < n; i++) {
            if (student_List[i].p_Sex == sex) count++;
        }
        return count;
    }
    void Show_Statistic_Sex() {
        if (exException.Check_List_Empty(n)==true) System.out.println("║\t╚══ List is empty!");
        else {
            System.out.print("║\t╠══ Enter kinds of sex you want to know statistic (1. Male - 2. Female): ");
            String count_ = sc.nextLine();
            int sex = 0;
            while (count_!=null) {
                if (exException.Check_Valid_Num(count_)==false) {
                    System.out.print("║\t╠══ Error formatting data!Try again: ");
                    count_ = sc.nextLine();
                }
                else if (Integer.parseInt(count_)!=1 && Integer.parseInt(count_)!=2) {
                    System.out.print("║\t╠══ Invalid data!Try again: ");
                    count_ = sc.nextLine();
                }else {
                    sex = Integer.parseInt(count_);
                    break;
                }
            }
            if (sex==1) {
                int show = Count_Sex(sex);
                float per = (show*100)/n;
                System.out.println("║\t║\t╚═ Statistic of male: "+show+" ("+per+"%)");
            }
            else {
                int show = Count_Sex(sex);
                double per = (show*100)/n;
                System.out.println("║\t║\t╚═ Statistic of female: "+show+" ("+per+"%)");
            }
            System.out.println("║\t╚═ Done!");
        }
    }
    void Show_Statistic_Age() {
        if (exException.Check_List_Empty(n)==true) System.out.println("║\t╚═ There is no student in here!");
        else {
            int age_u25 = 0;
            for (i = 0; i < n; i++) {
                String[] info_age = student_List[i].p_Birth.split("/");
                if ((2021-Integer.parseInt(info_age[2]))<25) {
                    age_u25++;
                }
            }
            double u25_per = (age_u25*100)/n;
            System.out.println("║         ╠═ Student under 25 years old: "+age_u25+" ("+u25_per+"%)\n║         ╚═ Student upper 25 years old: "+(n-age_u25)+" ("+(100-u25_per)+"%)");
        }
    }
    void Show_Statistic_Major() {
        if (exException.Check_List_Empty(n)==true) System.out.println("║\t╚═ There is no student to calculate!");
        else {
            int count_major = 0;
            System.out.print("║\t╠═ Which major do you want to find statistic: ");
            String major_sta = sc.nextLine();
            while (major_sta!=null) {
                if (exException.Check_Name(major_sta)==true) break;
                System.out.print("║\t╠═ Invalid types of major!Try again: ");
                major_sta = sc.nextLine();
            }
            for (i = 0; i < n; i++) {
                if (student_List[i].MajorID.toUpperCase().contains(major_sta.toUpperCase())) {
                    count_major++;
                }
            }
            if (count_major < 1) System.out.println("\tThere is no student study in this field!");
            else {
                double major_per = (count_major*100)/n;
                System.out.println("║\t║\t╚═ Students who study in this major: "+count_major+" ("+major_per+"%)");
                System.out.println("║\t╚═ Done!");
            }
        }
    }
}