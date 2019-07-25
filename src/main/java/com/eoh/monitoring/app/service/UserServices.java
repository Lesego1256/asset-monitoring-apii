package com.eoh.monitoring.app.service;

import com.eoh.monitoring.app.constants.Constants;
import com.eoh.monitoring.app.email.MailServer;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.eoh.monitoring.app.model.User;

import com.eoh.monitoring.app.respository.UserRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.Random;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Service
public class UserServices {

    @Autowired
    private UserRepository repo;

    //Register the user!
    public User getEmployee(Long id) {
        return repo.getOne(id);
    }

    public User createEmployee(User user) {
        String generatedPassword = generatePassword(user.getName(), user.getSurname());
        user.setDateCreated(new Date());
        user.setPassword(generatedPassword);
        user.setAssetFormStatus(1);
        user.setStatus(1);

        User createdUser = repo.save(user);
        MailServer.sendMail(user.getEmail(), user.getName(), user.getSurname(), generatedPassword, user.getRole().getRole_Type());
        return createdUser;
    }

    /*public String checkUser(User em){
		
		List<User> employs = repo.findAll();
		
		for(int i =0; i<employs.size();i++)
		{
			if((employs.get(i).getEmail().equalsIgnoreCase(em.getEmail())) ||
				(employs.get(i).getIdno().equalsIgnoreCase(em.getIdno())))
				{
					return "This user with the ID :" + em.getIdno() + "already exists";
					
				}
			else
			{
				createEmployee(em);
				return em.getName() + " has been created.";
				
			}
			
		}
		return null;
		
		
		
	}*/
    //Once the user is accepted assign user to device
    public User assignUserToDevice(User em) {

        int productSize = em.getProducts().size();

        for (int i = 0; i < productSize; i++) {
            //assigning the sql date!
            em.getProducts().get(i).setCreateDate(getDate());
        }
        return repo.save(em);

    }

    public List<User> getAllEmployees() {
        List<User> employs = repo.findAll();
        /*List<Employee> employees = new ArrayList<Employee>();
		
		for(int i = 0; i<employs.size(); i++)
		{
			if(employs.get(i).getRole().getRole_Type().equalsIgnoreCase("Employee"))
			{
				employees.add(employs.get(i));
			}
		}*/

        return employs;
    }

    public ResponseEntity<User> deleteEmployee(@PathVariable(value = "pro") User em) {

        User devvv = repo.getOne(em.getId());
        if (devvv == null) {
            return ResponseEntity.notFound().build();
        }

        repo.delete(em);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<User> updateEmployee(@PathVariable(value = "emp") User emp) {

        User empl = repo.getOne(emp.getId());
        if (empl == null) {
            return ResponseEntity.notFound().build();
        }

        repo.save(emp);

        return ResponseEntity.ok().build();
    }

    public User loginn(String email, String password) {
        //from the repo
        return repo.login(email, password);
    }

    //create the date to stored in the em prod array
    public java.sql.Date getDate() {
        Calendar calendar = Calendar.getInstance();
        java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());

        return ourJavaDateObject;
    }

    public String generatePassword(String firstName, String lastName) {
        Random rand = new Random();
        String password = firstName.substring(0, 2) + lastName.substring(0, 1);

        for (int x = 0; x < 5; x++) {
            int n = rand.nextInt(50);
            n += 1;
            password += n;
        }

        return password;
    }

}
