package com.web.tutor.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Table(name="account")
@Entity
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String lName;
	private String fName;
	private String email;
	private String password;
	@Transient
	private String password2;
	private String role;
	private String image;
	
	@ManyToMany(cascade = CascadeType.DETACH )
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
	    inverseJoinColumns = @JoinColumn(name = "role_id"))
	    private Set<Role> roles =new HashSet <Role>();

	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Addressess address;

	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<PaymentMethod> paymentMethod;

	// add one to many mapping for user and their products
	@OneToMany(mappedBy="users_id", cascade=CascadeType.ALL)
	private List<Products> products;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Addressess getAddress() {
		return address;
	}
	public void setAddress(Addressess address) {
		this.address = address;
	}
	public List<PaymentMethod> getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(List<PaymentMethod> paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}
	
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", lName=" + lName + ", fName=" + fName + ", email=" + email + ", password="
				+ password + ", password2=" + password2 + "]";
	}
	
	
	
}
