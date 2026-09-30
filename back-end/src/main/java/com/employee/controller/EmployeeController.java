package com.employee.controller;

import com.employee.Entity.Employee;
import com.employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(maxAge = 3360) // Permite requisições de outros domínios, útil para integração com front-end
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/api/v1/employees")                            // ResponseEntity permite retornar uma resposta
    public ResponseEntity<List<Employee>> fetchAllEmployees(){    //  HTTP com status(ok -> 200, notFound -> 400) e body(lista de empregados em Json)
        return ResponseEntity.ok(employeeService.fetchAllEmployees());
    }
    @PostMapping("/api/v1/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){    // RequestBody pega o corpo da requisição (o JSON enviado pelo cliente)
        return ResponseEntity.ok(employeeService.createEmployee(employee));            // e converte automaticamente num objeto Java
    }
    @PutMapping("/api/v1/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable ("id") Long id,@RequestBody Employee employee){    // PathVariable extrai o ID da requisição URL,
        return ResponseEntity.ok(employeeService.updateEmployee(employee));                                         // para assim poder atualizar o registro correto
    }
    @DeleteMapping("/api/v1/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable ("id") Long id){
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }

}
