package com.eoh.monitoring.app.service;

import com.eoh.monitoring.app.model.Device;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.eoh.monitoring.app.model.Product;
import com.eoh.monitoring.app.respository.ProductRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Service
public class DeviceServices {

    @Autowired
    private ProductRepository repo;

    //Get All products!
    public List<Product> getAllProduct() {
        System.out.println("Inside get Method");
        return repo.findAll();
    }

    public Product loginn(String serialNumber) {
        //from the repo
        return repo.getDevice(serialNumber);
    }

    //Save Product!!
    public Product saveProduct(Product pro) {
        System.out.println("Save product!");
        // java.sql.Date
        Calendar calendar = Calendar.getInstance();
        java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
        pro.setCreateDate(ourJavaDateObject);
        return repo.save(pro);
    }

    //done
    public ResponseEntity<Product> deleteProduct(@PathVariable(value = "pro") Product pro) {

        Product devvv = repo.getOne(pro.getId());
        if (devvv == null) {
            return ResponseEntity.notFound().build();
        }
        repo.delete(pro);
        return ResponseEntity.ok().build();
    }

    //Update the product!
    //Done!
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "pro") Product pro) {

        Product devvv = repo.getOne(pro.getId());
        if (devvv == null) {
            return ResponseEntity.notFound().build();
        }

        // java.sql.Date
        Calendar calendar = Calendar.getInstance();
        java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());

        pro.setCreateDate(ourJavaDateObject);

        repo.save(pro);

        return ResponseEntity.ok().build();
    }

    public List<Product> getAllUnAssigned(String status) {
        return repo.getUnassignedDevice(status);
    }

    public Integer countAllProducts() {
        return repo.countAll();
    }

    public Map dashboardInfo() {

        List<Product> prodcList = repo.findAll();
        Map map = createMap(prodcList);

        return map;

    }

    public Map createMap(List<Product> prodcList) {
        Map map = new HashMap();

        Integer countMonitor = 0;
        Integer countOther = 0;
        Integer countLaptop = 0;
        Integer countAssigned = 0;
        Integer countEFL = 0;
        Integer countNotAssigned = 0;
        Integer countDead = 0;
        Integer countStolen = 0;
        Integer countAll = 0;

        for (Product product : prodcList) {
            if (product.getDevice().getDeviceType().equalsIgnoreCase("Laptop")) {
                countLaptop += 1;
            } else if (product.getDevice().getDeviceType().equalsIgnoreCase("Monitor")) {
                countMonitor += 1;
            } else if (product.getStatus() == 2) {
                countAssigned += 1;
            } else if (product.getStatus() == 3) {
                countEFL += 1;
            } else if (product.getStatus() == 4) {
                countDead += 1;
            } else if (product.getStatus() == 5) {
                countStolen += 1;
            } else if (product.getDevice().getDeviceType().equalsIgnoreCase("other")) {
                countOther += 1;
            } else {
                countOther += 1;

            }
            countAll += 1;
        }

        map.put("countMonitor", countMonitor);
        map.put("countOther", countOther);
        map.put("countLaptop", countLaptop);
        map.put("countAssigned", countAssigned);
        map.put("countEFL", countEFL);
        map.put("countNotAssigned", countNotAssigned);
        map.put("countDead", countDead);
        map.put("countStolen", countStolen);
        map.put("countAll", countAll);

        return map;
    }
}
