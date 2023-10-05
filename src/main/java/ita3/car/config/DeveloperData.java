package ita3.car.config;

import ita3.car.entity.Car;
import ita3.car.entity.Member;
import ita3.car.repository.ICarRepository;
import ita3.car.repository.IMemberRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;


@Controller
public class DeveloperData implements ApplicationRunner {

       ICarRepository carrepo;
    IMemberRepository memberrepo;

    public DeveloperData(ICarRepository carrepo, IMemberRepository memberrepo) {
        this.carrepo = carrepo;
        this.memberrepo = memberrepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //creating a new car object
        carrepo.save(new Car("Volvo", "84", 200, 12));
        carrepo.save(new Car("Toyota", "Camry", 180, 10));
        carrepo.save(new Car("Ford", "Mustang", 300, 15));
        carrepo.save(new Car("Honda", "Civic", 150, 8));
        carrepo.save(new Car("Tesla", "Model 3", 250, 20));
        carrepo.save(new Car("BMW", "X5", 280, 18));
        carrepo.save(new Car("Mercedes-Benz", "C-Class", 240, 16));
        carrepo.save(new Car("Audi", "A4", 210, 14));


        memberrepo.save(new Member("hello12", "12345", "hello12@gmail.com", "Adam", "Smith", "Elmegade", "Nørrebro", "2200"));
        memberrepo.save(new Member("user456", "pass456", "user456@email.com", "Jane", "Smith", "456 Elm St", "Sometown", "67890"));
        memberrepo.save(new Member("user202", "123abc", "user202@email.com", "Sophia", "Brown", "202 Cedar St", "Newtown", "24680"));
        memberrepo.save(new Member("user789", "secret789", "user789@email.com", "Michael", "Johnson", "789 Oak St", "Othertown", "54321"));
        memberrepo.save(new Member("user101", "pass101", "user101@email.com", "Emily", "Williams", "101 Pine St", "Differenttown", "13579"));
        memberrepo.save(new Member("user303", "p@ssw0rd", "user303@email.com", "David", "Lee", "303 Birch St", "Yourtown", "97531"));
    }







}
