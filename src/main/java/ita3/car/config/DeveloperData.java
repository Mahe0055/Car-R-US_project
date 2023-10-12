package ita3.car.config;

import ita3.car.entity.Car;
import ita3.car.entity.Member;
import ita3.car.entity.Reservation;
import ita3.car.repository.ICarRepository;
import ita3.car.repository.IMemberRepository;
import ita3.car.repository.IReservationRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;


@Configuration
public class DeveloperData implements ApplicationRunner {

       ICarRepository carrepo;
       IMemberRepository memberrepo;
       IReservationRepository reservationrepo;


    public DeveloperData(ICarRepository carrepo, IMemberRepository memberrepo, IReservationRepository reservationrepo) {
        this.carrepo = carrepo;
        this.memberrepo = memberrepo;
        this.reservationrepo = reservationrepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Car car1 = carrepo.save(new Car("Volvo", "84", 200, 12));
        Car car2 = carrepo.save(new Car("Toyota", "Camry", 180, 10));
        Car car3 = carrepo.save(new Car("Ford", "Mustang", 300, 15));
        Car car4 = carrepo.save(new Car("Honda", "Civic", 150, 8));
        carrepo.save(new Car("Tesla", "Model 3", 250, 20));
        carrepo.save(new Car("BMW", "X5", 280, 18));
        carrepo.save(new Car("Mercedes-Benz", "C-Class", 240, 16));
        carrepo.save(new Car("Audi", "A4", 210, 14));

        Member member1 = memberrepo.save(new Member("hello12", "12345", "hello12@gmail.com", "Adam", "Smith", "Elmegade", "Nørrebro", "2200"));
        Member member2 = memberrepo.save(new Member("user456", "pass456", "user456@email.com", "Jane", "Smith", "456 Elm St", "Sometown", "67890"));
        Member member3 = memberrepo.save(new Member("user202", "123abc", "user202@email.com", "Sophia", "Brown", "202 Cedar St", "Newtown", "24680"));
        Member member4 = memberrepo.save(new Member("user789", "secret789", "user789@email.com", "Michael", "Johnson", "789 Oak St", "Othertown", "54321"));
        memberrepo.save(new Member("user101", "pass101", "user101@email.com", "Emily", "Williams", "101 Pine St", "Differenttown", "13579"));
        memberrepo.save(new Member("user303", "p@ssw0rd", "user303@email.com", "David", "Lee", "303 Birch St", "Yourtown", "97531"));


        //creating reservation
        LocalDate reservationDate1 = LocalDate.of(2023, 10, 5);
        LocalDate reservationDate2 = LocalDate.of(2023, 10, 10);
        LocalDate reservationDate3 = LocalDate.of(2021, 2, 17);
        LocalDate reservationDate4 = LocalDate.of(2022, 8, 4);

        //connecting the reservations with cars and members
        reservationrepo.save(new Reservation(reservationDate1, car1, member1));
        reservationrepo.save(new Reservation(reservationDate2, car2, member2));
        reservationrepo.save(new Reservation(reservationDate3, car3, member3));
        reservationrepo.save(new Reservation(reservationDate4, car4, member4));

    }
}
