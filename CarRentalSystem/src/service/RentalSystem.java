package service;

import model.Car;
import model.Customer;
import model.Reservation;
import payment.CreditCardPaymentProcessor;
import payment.PaymentProcessor;
import repositories.CarRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RentalSystem {
    private static RentalSystem instance;
    private final Map<String, Car> cars;
    private final Map<String, Reservation> reservations;
    private final PaymentProcessor paymentProcessor;
    private CarRepository carRepository;

    private RentalSystem() {
        cars = new ConcurrentHashMap<>();
        reservations = new ConcurrentHashMap<>();
        paymentProcessor = new CreditCardPaymentProcessor();
        carRepository=new CarRepository();
    }

    public static synchronized RentalSystem getInstance() {
        if (instance == null) {
            instance = new RentalSystem();
        }
        return instance;
    }

    public void addCar(Car car) {
        cars.put(car.getLicensePlate(), car);
    }

    public void removeCar(String licensePlate) {
        cars.remove(licensePlate);
    }

    public List<Car> searchCars(String make, String model, LocalDate startDate, LocalDate endDate) {
        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars.values()) {
            if (car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model) && car.isAvailable()) {
                if (isCarAvailable(car, startDate, endDate)) {
                    availableCars.add(car);
                }
            }
        }
        return availableCars;
    }

    private boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate) {
        for (Reservation reservation : reservations.values()) {
            if (reservation.getCar().equals(car)) {
                //14-17
                //18 20
                //13 -15
                //14-16

                if (startDate.isBefore(reservation.getEndDate()) && endDate.isAfter(reservation.getStartDate())) {
                    return false;
                }
            }
        }
        return true;
    }

    public synchronized Reservation makeReservation(Customer customer, Car car, LocalDate startDate, LocalDate endDate) {
        if (isCarAvailable(car, startDate, endDate)) {
            String reservationId = generateReservationId();
            Reservation reservation = new Reservation(reservationId, customer, car, startDate, endDate);
            reservations.put(reservationId, reservation);
            car.setAvailable(false);
            return reservation;
        }
        return null;
    }

    public synchronized void cancelReservation(String reservationId) {
        Reservation reservation = reservations.remove(reservationId);
        if (reservation != null) {
            reservation.getCar().setAvailable(true);
        }
    }

    public boolean processPayment(Reservation reservation) {
        return paymentProcessor.processPayment(reservation.getTotalPrice());
    }

    private String generateReservationId() {
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public Reservation bookcarOnRent(LocalDate startDate,
                                     LocalDate endDate,
     String make,
     String model)
    {

        //check car is available
        //create the reservation
        //do payment
        //reservation successful

        Car car=carRepository.getCarbyMakeModel(make, model);

        if(isCarAvailable(car,startDate,endDate)) {
            makeReservation(null,car,startDate,endDate);
        }
        else
        {
            System.out.print("car is not available");
        }
    }
}
