package day2.mockTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoFramework;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaxCountTest {
    private TaxCount taxCount;

    @Mock
    EmployeeDao employeeDao; // = mock(EmployeeDao.class);

    @BeforeEach
    void setUp() {
        taxCount = new TaxCount();
    }

    @Test
    void getTax() {
        when(employeeDao.getEmployee(1)).thenReturn(new Employee(1, "Darek", 100.0));
        TaxCount taxCount = new TaxCount(employeeDao);
        assertThat(taxCount.getTax(1)).isEqualTo(19);
    }

    @Test
    void getTax1() {
        when(employeeDao.getEmployee(1)).thenReturn(null);
        TaxCount taxCount = new TaxCount(employeeDao);
        assertThrows(IllegalArgumentException.class, () ->
                taxCount.getTax(1));
    }
}