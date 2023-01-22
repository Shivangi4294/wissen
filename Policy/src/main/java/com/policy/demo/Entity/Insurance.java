package com.policy.demo.Entity;
import javax.persistence.*;

//@Entity
//@Table (name ="policy")

@Entity(name ="policy")

public class Insurance {
	@Id
	int pid;
	@Column(name = "pname")
	String pname;
	@Column(name = "totalsum")
	int totalsum;
	@Column(name = "paymethod")
	String paymethod;
	
	public Insurance() {}
	
	public Insurance(int pid, String pname, int totalsum, String paymethod) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.totalsum = totalsum ;
		this.paymethod = paymethod;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getTotalsum() {
		return totalsum;
	}

	public void setTotalsum(int totalsum) {
		this.totalsum = totalsum;
	}

	public String getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	@Override
	public String toString() {
		return "Insurance [pid=" + pid + ", pname=" + pname + ", totalsum=" + totalsum + ", paymethod=" + paymethod
				+ "]";
	}

}
