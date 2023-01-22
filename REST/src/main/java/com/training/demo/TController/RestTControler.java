package com.training.demo.TController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.training.demo.Entity.Employee;
import com.training.demo.repository.IEmployeeRepository;


@RestController
public class RestTControler {
	
	@Autowired
	IEmployeeRepository empRepo;
	

	//http://localhost:2345/getAllEmployees
	@GetMapping(path = "/getAllEmployees/{id}")
	public List<Employee> getAllEmployees(@PathVariable int id){
		
	  //List<Employee> empList = empRepo.findAll();
//		List<Employee> empList = empRepo.getAllEmployees();
		List<Employee> empList = empRepo.getAllEmployeeById(id);
		
		return empList;
	}
	@GetMapping(path = "/getAllByName/{name}")
	public List<Employee> getAllByName(@PathVariable String name){
		List<Employee> empList = empRepo.getAllByName(name);
		return empList;
	}
	
	@PostMapping(path = "/insertEmployee")
	public String insertEmployee(@RequestBody Employee emp) {
		System.out.print("Rcvd post data: "+emp);
		empRepo.save(emp);
		return "Success";
	}
	
	@PutMapping(path = "/updateEmployee")
	public String updateEmployee(@RequestBody Employee emp) {
		Optional<Employee> empOp = empRepo.findById(emp.getId());
		if(empOp.isPresent()) {
			Employee empUpdate = empOp.get();
			empUpdate.setName(emp.getName());
			empUpdate.setDept(emp.getDept());
			empUpdate.setDesig(emp.getDesig());
			empRepo.save(empUpdate);
			return "Success";
		}
		return "Fail";
	}
	
	@DeleteMapping(path = "/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		System.out.println("Given id : "+id);
		empRepo.deleteById(id);
		return "Success";
		
	}
	

	//http://localhost:2345/hello
	@RequestMapping("/hello")
	public String display() {
		return "Hello, Welcome to spring rest";
	}
	
	//http://localhost:2345/login?uid=java&pwd=java
	
	@RequestMapping("/login")
	public String login(@RequestParam String uid, @RequestParam String pwd) {
		
		System.out.print("Given data: User Id: "+uid+" Password : "+pwd);
		String str = "";
		if(uid.equals("java") && pwd.equals("java"))
			str = "Valid User.";
		else
			str = "Invalid User.";
		
		return str;	
	}
	
	@GetMapping(path ="/getEmployee")
	public Employee getEmployee() {
		Employee emp = new Employee(101,"Shivangi","IT","Full Stack Dev");
		return emp;
	}

	@PostMapping(path = "/insertData")
	public String insertData(@RequestBody Employee emp) {
		System.out.print("Rcvd post data: "+emp);
		return "Success";
	}
	
	@PutMapping(path ="/updateData")
	public String updateData(@RequestBody Employee emp) {
		System.out.print("Rcvd put data: "+emp);
		return "Success";
	}
	@DeleteMapping(path ="/deleteData")
	public String deletedata(@PathVariable int id) {
		System.out.print("deleted data: "+id);
		return "Success";
	}
}
