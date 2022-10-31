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


    

}