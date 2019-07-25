package com.eoh.monitoring.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.Data;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@Entity
public class Device implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String color;
    private double price;
    private Integer monitorSize;
    private String deviceType;
    private String graphics;
    private String CPU; // cores
    private String hardDrive; // 1 tb or 500 gb
    private String laptopBag;
    private String ram; // processor
    private String operatingSystem; //the device operating system

    private String tagType;

    private String cores;

    private String monitorType;

    private String imei_number;

    private String sim_Number;

    private String msisdn_number;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "issueId")
    private List<Issue> issues;
    
    public Device() {
        super();
//        this.deviceType = "-";
//        this.operatingSystem = "-";
//        this.tagType = "-";
//        this.cores = "-";
//        this.monitorType = "-";
//        this.imei_number = "-";
//        this.sim_Number = "-";
//        this.msisdn_number = "-";

    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getMonitorSize() {
		return monitorSize;
	}

	public void setMonitorSize(Integer monitorSize) {
		this.monitorSize = monitorSize;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getGraphics() {
		return graphics;
	}

	public void setGraphics(String graphics) {
		this.graphics = graphics;
	}

	public String getCPU() {
		return CPU;
	}

	public void setCPU(String cPU) {
		CPU = cPU;
	}

	public String getHardDrive() {
		return hardDrive;
	}

	public void setHardDrive(String hardDrive) {
		this.hardDrive = hardDrive;
	}

	public String getLaptopBag() {
		return laptopBag;
	}

	public void setLaptopBag(String laptopBag) {
		this.laptopBag = laptopBag;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getTagType() {
		return tagType;
	}

	public void setTagType(String tagType) {
		this.tagType = tagType;
	}

	public String getCores() {
		return cores;
	}

	public void setCores(String cores) {
		this.cores = cores;
	}

	public String getMonitorType() {
		return monitorType;
	}

	public void setMonitorType(String monitorType) {
		this.monitorType = monitorType;
	}

	public String getImei_number() {
		return imei_number;
	}

	public void setImei_number(String imei_number) {
		this.imei_number = imei_number;
	}

	public String getSim_Number() {
		return sim_Number;
	}

	public void setSim_Number(String sim_Number) {
		this.sim_Number = sim_Number;
	}

	public String getMsisdn_number() {
		return msisdn_number;
	}

	public void setMsisdn_number(String msisdn_number) {
		this.msisdn_number = msisdn_number;
	}

	public List<Issue> getIssues() {
		return issues;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}
    
    

}
