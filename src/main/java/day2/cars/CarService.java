package day2.cars;

public class CarService {
    private CarsDao carsDao = new CarDaoImp();

    void setCarsDao(CarsDao carsDao) {
        this.carsDao = carsDao;
    }

    public String getCarDescr(int carId) {
      Car car = carsDao.getCar(carId);
      if(car == null){
          throw new CarException("Błędne dane");
      }
      return String.format("Samochód %d posiada nazwę %s i jest koloru %s", car.getId(), car.getName(), car.getColor());

    }
}
