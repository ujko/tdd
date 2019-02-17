package day2.mockTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaxCountTest1 {

    EmployeeDao employeeDao = mock(EmployeeDao.class);
    TaxCount taxCount;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getUpperCaseName() {
        when(employeeDao.getEmployee(4)).thenReturn(new Employee(4, "Jan Nowak", 100.0));
        taxCount = new TaxCount(employeeDao);
        assertThat(taxCount.getUpperCaseName(4))
                .startsWith("JAN")
                .endsWith("WAK")
                .contains(" ");
    }
    @Test
    void getUpperCaseName1() {
        when(employeeDao.getEmployee(4)).thenReturn(null);
        taxCount = new TaxCount(employeeDao);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            taxCount.getUpperCaseName(4);
        });
        assertThat(illegalArgumentException.getMessage()).isEqualTo("Błędny argument");
    }
}