package com.tangbear.springbootmvc.service;

import com.tangbear.springbootmvc.entity.Employee;
import com.tangbear.springbootmvc.repository.EmployeeRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    final private EmployeeRepository repository;

    public List<Employee> find() {
        return repository.findAll();
    }

    public Employee insert(Employee employee) {
        return repository.save(employee);
    }

    public Employee findById(Long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Record"));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
