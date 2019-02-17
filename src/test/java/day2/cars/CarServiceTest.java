package day2.cars;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CarServiceTest {
    CarService carService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getCarDescr() {
        CarsDao carsDao = mock(CarsDao.class);
        when(carsDao.getCar(1)).thenReturn(new Car("BMW",1,"black"));
        carService = new CarService();
        carService.setCarsDao(carsDao);
        Assertions.assertThat(carService.getCarDescr(1))
                .contains("BMW")
                .startsWith("Sam")
                .endsWith("black");
        verify(carsDao).getCar(1);
    }

    @Test
    void getCarDescr1() {
        CarsDao carsDao = mock(CarsDao.class);
        when(carsDao.getCar(1)).thenReturn(null);
        carService = new CarService();
        carService.setCarsDao(carsDao);

        CarException carException = assertThrows(CarException.class,
                () -> carService.getCarDescr(1));
        assertEquals("Błędne dane", carException.getMessage());
    }

}