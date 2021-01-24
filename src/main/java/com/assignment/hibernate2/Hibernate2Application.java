package com.assignment.hibernate2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.assignment.hibernate2.model.Gender;
import com.assignment.hibernate2.model.User;
import com.assignment.hibernate2.model.UserProfile;
import com.assignment.hibernate2.repository.UserProfileRepository;
import com.assignment.hibernate2.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
@EnableAutoConfiguration(exclude = {WebMvcAutoConfiguration.class })
@ComponentScan("com.assignment.hibernate2")
@SpringBootApplication
public class Hibernate2Application implements CommandLineRunner{

	
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    public static void main(String[] args) {
    	 SpringApplication.run(Hibernate2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       
//        userProfileRepository.deleteAllInBatch();
//        userRepository.deleteAllInBatch();

        
        
        
        
        
        
        while(true)
        {
        	System.out.println("**************************************************************************************************");
        	System.out.println("1.Add User\n\n3.Find User by Id \n4.Update User \n5.Delete User \nEnter Option");
        	 Scanner sc = new Scanner(System.in);
            int option= sc.nextInt();
           
        	switch(option) {
        	
        	case 1: {
        		System.out.println("Enter User FirstName\n");
        		sc.nextLine();String fname=sc.next();
        		System.out.println("Enter User LastName\n");
        		String lname=sc.next();
        		System.out.println("Enter User Password\n");
        		String pwd=sc.next();
        		System.out.println("Enter User Phone Number\n");
        		String phn=sc.next();
        		System.out.println("Enter User Gender\n");
        		String g=sc.next(); Gender gen = Gender.valueOf(g.toUpperCase());
        		System.out.println("Enter User DOb\n");
        		String dob=sc.next(); Date db=new SimpleDateFormat("dd/MM/yyyy").parse(dob);  
        		System.out.println("Enter User Address1\n");
        		String add1=sc.next();
        		System.out.println("Enter User Address2\n");
        		String add2=sc.next();
        		System.out.println("Enter User Street\n");
        		String street=sc.next();
        		System.out.println("Enter User City\n");
        		String city=sc.next();
        		System.out.println("Enter User State\n");
        		String state=sc.next();
        		System.out.println("Enter User Country\n");
        		String country=sc.next();
        		System.out.println("Enter User Zip\n");
        		String zip=sc.next();
        		User user1 = new User(fname,lname,pwd);
        		UserProfile up = new UserProfile(phn,gen,db,add1,add2,street,city,state,country,zip);
        		// Set child reference(userProfile) in parent entity(user)
                user1.setUserProfile(up);

                // Set parent reference(user) in child entity(userProfile)
                up.setUser(user1);

                // Save Parent Reference (which will save the child as well)
                userRepository.save(user1);

        		break;
        	}
        	
        	case 3:{
        		System.out.println("Enter User ID");
        		Long Id=sc.nextLong();
        		User u = userRepository.findUserById(Id);
        		System.out.println(u);
        		break;
        		
        	}
        	case 4:{
        		System.out.println("Enter User ID");
        		Long Id=sc.nextLong();
        		User u = userRepository.findUserById(Id);
        		System.out.println("Enter User Name");
        		sc.nextLine();
        		String fname=sc.nextLine();
	        	u.setFirstName(fname);
	        	userRepository.save(u);
	        	System.out.println("Updated Successfully");
	        	
	        	break;
        		
        	}
        	case 5:{
        		System.out.println("Enter User ID");
        		Long Id=sc.nextLong();
        		User u = (User)userRepository.findUserById(Id);
        		userRepository.delete(u);
        		break;
        	}
        	default:break;
        	
        	}
        }
    }
       
    }

