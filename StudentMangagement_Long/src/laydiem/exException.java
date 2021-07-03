/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laydiem;
import java.util.Date;
/**
 *
 * @author LongDinh
 */
public class exException {
    public static boolean Check_Month_Valid(String s) {
        String[] check_ = s.split("/");
        int[] check = new int[check_.length];
        for (int i = 0; i < check.length;i++) {
            check[i] = Integer.parseInt(check_[i]);
        }
        if (check[1] > 12 || check[1] < 1) return false;
        else if (check[1]==1||check[1]==3||check[1]==5||check[1]==7||check[1]==8||check[1]==10||check[1]==12) {
            if (check[0] > 31) return false;
        }else if (check[1]==4||check[1]==6||check[1]==9||check[1]==11) {
            if (check[0] > 30) return false;
        }else if (check[1]==2) {
            if (check[0]==29){
                if (check[2]%4!=0||check[2]%100==0&&check[2]%400!=0) return false;
            }else if (check[0] > 28) return false;
        }
        return true;
    }
    public static boolean Check_Date(String c) {
        try {
            Date cc = new Date(c);
        }catch (Exception e) {
            return false;
        }
        return true;
    }
    public static boolean Check_Valid_Num(String p_Sex_) {
        try {
                p_Sex_.equals("");
                Integer.parseInt(p_Sex_);
        } catch (Exception e) {
                return false;
            }
        return true;
    }
    public static boolean Check_Name(String s) {
        if (s.equals("")) return false;
        else {
            String[] arr = s.split(" ");
            for (int i = 0; i < arr.length; i++) {
                String che = arr[i];
                for (int j = 0; j < che.length(); j++) {
                    if (Character.isLetter(che.charAt(j))==false) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static boolean Check_List_Empty(int n) {
        if (n == 0) return true;
        return false;
    }
//    public static int Inputnum() throws Exception{
//        int a=-1;
//        Scanner p=new Scanner(System.in);
//        int f=0;
//        do{
//            try{
//                System.out.println("Input a int number: ");
//                a=p.nextInt();
//                f=1;  
//            }catch(Exception e){
//                System.out.println("Input again. Press [Enter] to continue");
//                p.nextLine();
//            }    
//        }while(f!=1);
//        return a;
//    }
//    public static String InputString() throws Exception {
//        String s = "";
//        int f=0;
//        Scanner in = new Scanner(System.in);
//        do{
//            try {
//                System.out.print("Input a string: ");
//                s = in.nextLine();
//                if (s.equals("")) {
//                    throw new Exception("Information must not empty");
//                }
//                f=1;
//            } catch (Exception e) {
//                System.out.println("Input again. Press [Enter] to continue");
//                in.nextLine();
//            }
//        }while(f!=1);        
//        return s;
//    }
}
