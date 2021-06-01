import java.util.Scanner;
public class CheckBill {
    double amountBill ;

    public CheckBill(double amount){
        System.out.println("Please choose your checkbill type \n1.Cash \n2.PromtPay \n3.Credit");
        Scanner sc = new Scanner(System.in);
        int ct = sc.nextInt();
        switch(ct){
            case 1: 
            Cash.billCash();
            
            case 2:
            PromtPay.billPromtPay();

            case 3: 
            Credit.billCredit();

    }
}
