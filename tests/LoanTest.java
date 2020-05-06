import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LoanTest {

    @Test
    void calc_interest() {
        double expected=120.0;
        Loan loan=new Loan();
        loan.principal=1000.0;
        double actual=loan.calc_interest(12,12);
        assertEquals(expected,actual);
    }


    @Test
    void emis() {
        EMI expexted_emis[]=new EMI[2];
        expexted_emis[0]=new EMI();
        expexted_emis[1]=new EMI();
        expexted_emis[0].no=1;expexted_emis[0].principal_emi=500.0;expexted_emis[0].interest_emi=10.0;expexted_emis[0].total_emi=510.0;expexted_emis[0].date=java.sql.Date.valueOf(LocalDate.now().plusMonths(1));expexted_emis[0].principal_remaining=510.0;
        expexted_emis[1].no=2;expexted_emis[1].principal_emi=500.0;expexted_emis[1].interest_emi=10.0;expexted_emis[1].total_emi=510.0;expexted_emis[1].date=java.sql.Date.valueOf(LocalDate.now().plusMonths(2));expexted_emis[1].principal_remaining=0.0;
        EMI actual_emis[]=new EMI[2];
        Loan loan=new Loan();
        loan.principal=1000.0;
        loan.creation_date=LocalDate.now();
        actual_emis=loan.emis(loan,2,20.0);
        for(int i=0 ;i<2;i++)
        {
            System.out.println("EMI No : "+actual_emis[i].no+" , Principal EMI : "+actual_emis[i].principal_emi+" , Interest EMI = "+actual_emis[i].interest_emi+" , Total EMI = "+actual_emis[i].total_emi+" , EMI Date : "+actual_emis[i].date+" , Principal remaining : "+actual_emis[i].principal_remaining);
            System.out.println("EMI No : "+expexted_emis[i].no+" , Principal EMI : "+expexted_emis[i].principal_emi+" , Interest EMI = "+expexted_emis[i].interest_emi+" , Total EMI = "+expexted_emis[i].total_emi+" , EMI Date : "+expexted_emis[i].date+" , Principal remaining : "+expexted_emis[i].principal_remaining);

        }
        assertArrayEquals(expexted_emis,actual_emis);

    }
}