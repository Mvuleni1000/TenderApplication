package TenderApplication.api;

import TenderApplication.Domain.Company;
import TenderApplication.Domain.Contracts;
import TenderApplication.Domain.Department;
import TenderApplication.Domain.Users;
import TenderApplication.module.DepartmentsRegistered;
import TenderApplication.module.UserRegistrated;
import TenderApplication.services.DepartmentService;
import TenderApplication.services.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/17.
 */


@RestController
@RequestMapping(value="/department/**")
public class DepartmentPage {

    @Autowired
    private DepartmentService serivce;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public List<Contracts> getContractor(@PathVariable Long id) {return serivce.getContractor(id);}

    @RequestMapping(value="/department", method=RequestMethod.GET)
    public List<DepartmentsRegistered> getDepartments()
    {

        List<DepartmentsRegistered> hateoas = new ArrayList();
        List<Department> d = serivce.getDepartments();


        for (Department c: d)
        {

            DepartmentsRegistered res = new DepartmentsRegistered
                    .Builder(c.getProjects())
                    .foundedBy(c.getFounder())
                    .contractID(c.getContractID())
                    .build();

            Link sheet = new Link("http://localhost:8080/user" + res.getFounder()+res.toString())
                    .withRel("departmentRegistered");
            res.add(sheet);
            hateoas.add(res);
        }

        return hateoas;
    }


    //-------------------------Retrieve all users--------------------//
    @RequestMapping(value = "/department/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Department> getDepartment(@PathVariable("id") long id) {
        System.out.println("Fectching the departments available:" + id);
        Department client = serivce.findById(id);
        if (client == null) {
            System.out.println("Subject with id " + id + " not found");
            return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Department>(client, HttpStatus.OK);
    }


    //-------------------Create a Subject--------------------------------------------------------

    @RequestMapping(value = "/department/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createDepartment(@RequestBody Department d, UriComponentsBuilder ucBuilder) {
        System.out.println("Founder of the Project: " + d.getFounder());
        serivce.save(d);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/department/{id}").buildAndExpand(d.getDepartmentNo()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }



    //------------------- Update a User --------------------------------------------------------

    @RequestMapping(value = "/department/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Department> updateDepartment(@PathVariable("id") long id, @RequestBody Department d) {
        System.out.println("Updating Department available " + id);

        Department currentDepartment = serivce.findById(id);

        if (currentDepartment==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
        }

        Department updatedUser = new Department
                .Builder(currentDepartment.getProjects())
                .copy(currentDepartment)
                .build();
        serivce.update(updatedUser);
        return new ResponseEntity<Department>(updatedUser, HttpStatus.OK);
    }


    //------------------- Delete a User --------------------------------------------------------

    @RequestMapping(value = "/department/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Department> deleteDepartment(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting user with id " + id);

        Department d = serivce.findById(id);
        if (d == null) {
            System.out.println("Unable to delete. Subject with id " + id + " not found");
            return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
        }

        serivce.delete(d);
        return new ResponseEntity<Department>(HttpStatus.NO_CONTENT);
    }


}
