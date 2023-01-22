package com.policy.demo.PolicyController;
import com.policy.demo.Entity.Insurance;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.policy.demo.repository.PolicyRepository;

@RestController
public class policyController {

	@Autowired
	PolicyRepository pRepo;
	
	@GetMapping(path = "/getAllPolicies")
	public List<Insurance> getAllPolicies(){
		List<Insurance> pList = pRepo.getAllPolicies();
		return  pList;
	}
	
	@GetMapping(path = "/getPolicyByNumber/{pId}")
	public List<Insurance> getPolicyByNumber(@PathVariable int pId){
		List<Insurance> pList = pRepo.getPolicyByNumber(pId);
		return  pList;
	}
	
	@GetMapping(path ="/getPolicyByName/{pName}")
	public List<Insurance>  getPolicyByName(@PathVariable String pName){
		List<Insurance> pList = pRepo.getPolicyByName(pName);
		return pList;
	}
	
	@PostMapping(path ="/addPolicy")
	public String addPolicy(@RequestBody Insurance in) {
		System.out.print("Post data: "+in);
		pRepo.save(in);
		return "Success";
	}
	
	@PutMapping(path = "/updatePolicy")
	public String updatePolicy(@RequestBody Insurance in) {
		Optional<Insurance> op = pRepo.findById(in.getPid());
		if(op.isPresent()) {
			Insurance inUpdate = op.get();
			inUpdate.setPname(in.getPname());
			inUpdate.setTotalsum(in.getTotalsum());
			inUpdate.setPaymethod(in.getPaymethod());
			pRepo.save(inUpdate);
			return "Success";
		}
		return "Fail";
	}
	
	@DeleteMapping(path = "/deletePolicy/{pId}")
	public String deletePolicy(@PathVariable int pId) {
		System.out.print("given data: "+pId);
		pRepo.deleteById(pId);
		return "Success";
	}
	
}
