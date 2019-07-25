package com.eoh.monitoring.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String idno;
    private String name;
    private String surname;
    private String email;
    
    @JsonIgnore
    private String password;
    private String title;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    List<Product> products;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAcceptedAssetForm;
    private Integer status;
    private Integer assetFormStatus;

    public User() {
    }

    public User(Long id, String idno, String name, String surname, String email, String password, String title, Role role, List<Product> products, Date dateCreated, Date dateAcceptedAssetForm) {
        this.id = id;
        this.idno = idno;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.title = title;
        this.role = role;
        this.products = products;
        this.dateCreated = dateCreated;
        this.dateAcceptedAssetForm = dateAcceptedAssetForm;
    }

    public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateAcceptedAssetForm() {
		return dateAcceptedAssetForm;
	}

	public void setDateAcceptedAssetForm(Date dateAcceptedAssetForm) {
		this.dateAcceptedAssetForm = dateAcceptedAssetForm;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAssetFormStatus() {
        return this.assetFormStatus;
    }

    public void setAssetFormStatus(Integer assetFormStatus) {
        this.assetFormStatus = assetFormStatus;
    }

}
