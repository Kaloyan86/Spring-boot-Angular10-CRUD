package com.springbackend.init;

import com.springbackend.models.Employee;
import com.springbackend.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    public DataInit(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        this.employeeRepository.save(new Employee("Kaloyan","Kostadinov","kaloqn_kostadinow@abv.bg"));
        this.employeeRepository.save(new Employee("John","Smith","smith@abv.bg"));
        this.employeeRepository.save(new Employee("Gosho","Goshev","goshko@abv.bg"));
        this.employeeRepository.save(new Employee("Ivan","Ivanov","Ivan_Ivanov@abv.bg"));
        this.employeeRepository.save(new Employee("Peter","Kostadinov","peter_kostadinow@abv.bg"));
    }
}
