import java.time.LocalDate;
import java.util.Date;

public class Loan {
    double principal;
    String months;
    LocalDate creation_date;
    EMI all_emis[];
    public static void main(String[] args) {

        Loan loan=new Loan();
        loan.principal=Double.parseDouble(args[0]);
        loan.months=args[1];
        loan.creation_date=LocalDate.now();
        String[] month= loan.months.split("\\s");
        int no_of_emis=Integer.parseInt(month[0]);
        int total_months=no_of_emis;
        double total_interest_amount=loan.calc_interest(total_months,12);
        double total_amount=loan.principal+total_interest_amount;

        System.out.println("1. Loan Creation Date :" + loan.creation_date);
        System.out.println("2. Principal Amount :" + loan.principal);
        System.out.println("3. No. of EMIs :" + no_of_emis);
        System.out.println("4. Total Payable amount : " + loan.principal +" (Principal) + " + total_interest_amount +" (Interest for " + total_months + " months ) = " + total_amount);
        System.out.println("5. EMI Details");

        loan.all_emis=loan.emis(loan,total_months,total_interest_amount);
        for(int i=0 ;i<total_months;i++)
        {
            System.out.println("EMI No : "+loan.all_emis[i].no+" , Principal EMI : "+loan.all_emis[i].principal_emi+" , Interest EMI = "+loan.all_emis[i].interest_emi+" , Total EMI = "+loan.all_emis[i].total_emi+" , EMI Date : "+loan.all_emis[i].date+" , Principal remaining : "+loan.all_emis[i].principal_remaining);

        }
    }

    public EMI[] emis(Loan loan,int total_months,double total_interest_amount){
        EMI emis[] =new EMI[total_months];
        for(int i=0 ;i<total_months;i++)
        {   int emi_no=i+1;
            emis[i]=new EMI();
            emis[i].emi_calculator(emi_no,loan.principal,total_months,total_interest_amount,loan.creation_date);
        }
        return emis;
    }

    public double calc_interest(int months,int rate_of_interest){
        double year=(double)(months/(double)12);
        return (principal*(double) rate_of_interest*year)/(double)100;

    }
}
