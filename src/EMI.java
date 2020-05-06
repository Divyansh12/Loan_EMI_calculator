import java.time.LocalDate;
import java.util.Date;

public class EMI {
    int no;
    double principal_emi;
    double interest_emi;
    double total_emi;
    Date date;
    double principal_remaining;

    public void emi_calculator(int emi_no, double principal, int months, double total_interest, LocalDate creation_date){
        no=emi_no;
        double total_amount=principal+total_interest;
        principal_emi=(double) (principal/months);
        interest_emi=(double)(total_interest/months);
        total_emi=principal_emi+interest_emi;
        date=java.sql.Date.valueOf(creation_date.plusMonths(no));
        principal_remaining=total_amount-(double)(no*total_emi);

    }
}
