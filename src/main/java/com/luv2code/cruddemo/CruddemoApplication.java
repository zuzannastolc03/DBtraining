package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//            createInstructor(appDAO);
//            findInstructor(appDAO, 2);
//            deleteInstructor(appDAO, 1);
//            findInstructorDetail(appDAO, 2);
            deleteInstructorDetail(appDAO, 7);
        };
    }

    private void deleteInstructorDetail(AppDAO appDAO, int id) {
        System.out.println("Deleting instructor detail id: " + id);
        appDAO.deleteInstructorDetailById(id);
        System.out.println("Done");
    }

    private void findInstructorDetail(AppDAO appDAO, int id) {
        // get the instructor detail object
        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(id);
        // print the instructor detail
        System.out.println("tempInstructorDetail: " + tempInstructorDetail);
        // print the associated instructor
        System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

        System.out.println("Done!");
    }

    private void deleteInstructor(AppDAO appDAO, int id) {
        System.out.println("Deleting instructor at id: " + id);
        appDAO.deleteInstructorById(id);
        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO, int id) {
        System.out.println("Finding instructor at id: " + id);
        Instructor tempInstructor = appDAO.findInstructorById(id);
        System.out.println("Temp instructor: " + tempInstructor);
        System.out.println("the associated instructor details only: " + tempInstructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {
//        // create the instructor
//        Instructor tempInstructor =
//                new Instructor("Chad", "Darby", "darby@luv2code.com");
//
//        // create the instructor detail
//        InstructorDetail tempInstructorDetail =
//                new InstructorDetail(
//                        "http://luv2code.come/youtube",
//                        "Luv 2 code!!!");

        // create the instructor
        Instructor tempInstructor =
                new Instructor("Madhu", "Patel", "madhu@luv2code.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail =
                new InstructorDetail(
                        "http://luv2code.come/youtube",
                        "Guitar");


        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor
        //
        // NOTE: this will also save the details object
        // because of CascadeType.ALL
        //
        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);
        System.out.println("Done!");
    }
}
