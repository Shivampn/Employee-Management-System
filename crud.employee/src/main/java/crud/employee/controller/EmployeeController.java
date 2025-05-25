package crud.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import crud.employee.entities.Employee;
import crud.employee.services.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	@GetMapping("/openAdd")
	public String openAdd() {
		return "add_employee";
	}
	@PostMapping("/register")
	public String register(@ModelAttribute Employee emp) {
		service.addEmployee(emp);
		return "index";
	}
	
	@GetMapping("/openUpdate")
	public String openUpdate() {
		return "update_employee";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute Employee emp) {
		service.updateEmployee(emp);
		return "index";
	}
	
	@GetMapping("/openDelete")
	public String openDelete() {
		return "delete_employee";
	}
	@PostMapping("/delete")
	public String delete(@RequestParam int id) {
		service.deleteEmployee(id);
		return "index";
	}
	
	@GetMapping("/openSearch")
	public String openSearch() {
		return "search_employee";
	}
	@PostMapping("/search")
	public String search(@RequestParam int id,Model m) {
		Employee emp=service.searchEmployee(id);
		m.addAttribute("employee",emp);
		return "show_employee";
	}
	
	@GetMapping("/openList")
	public String openList(Model m) {
		List<Employee> emp=service.fetchAllEmployees();
		m.addAttribute("employee",emp);
		return "show_list";
	}
}
