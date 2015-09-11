package TenderApplication.api;

import TenderApplication.Domain.Company;
import TenderApplication.Domain.Users;
import TenderApplication.module.UserRegistrated;
import TenderApplication.services.UserSerivce;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/25.
 */
@RestController
@RequestMapping(value="/user/**")
public class UserRegistratioPage {

    @Autowired
    private UserSerivce serivce;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public List<Company> getUserCompany(@PathVariable Long id) {return serivce.getUserCompany(id);}

    @RequestMapping(value="/user", method=RequestMethod.GET)
    public List<UserRegistrated> getUsers()
    {

        List<UserRegistrated> hateoas = new ArrayList();
        List<Users> users = serivce.getUsers();


        for (Users c: users)
        {

            UserRegistrated res = new UserRegistrated.Builder(c.getContactDetails())
                    .account(c.getAccount())
                    .address(c.getBuilding_address())
                    .company(c.getCompany())
                    .build();

            Link sheet = new Link("http://localhost:8080/user" + res.getContactDetails()+res.toString())
                    .withRel("userRegistration");
            res.add(sheet);
            hateoas.add(res);
        }

        return hateoas;
    }


  //-------------------------Retrieve all users--------------------//
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> getSubject(@PathVariable("id") long id) {
        System.out.println("Fetching Subject with id " + id);
        Users client = serivce.findById(id);
        if (client == null) {
            System.out.println("Subject with id " + id + " not found");
            return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Users>(client, HttpStatus.OK);
    }


    //-------------------Create a Subject--------------------------------------------------------

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createSubject(@RequestBody Users users,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating user " + users.getAccount());

//     USE THIS IF YOU WANT TO CHECK UNIQUE OBJECT
//      if (SubjectService.isSubjectExist(Subject)) {
//            System.out.println("A Subject with name " + Subject.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        serivce.save(users);


        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(users.getUserID()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    //------------------- Update a User --------------------------------------------------------

    @RequestMapping(value = "/user/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Users> updateSubject(@PathVariable("id") long id, @RequestBody Users users) {
        System.out.println("Updating Subject " + id);

        Users currentUser = serivce.findById(id);

        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
        }

        Users updatedUser = new Users.Builder(currentUser.getAccount())
                .copy(currentUser)
                .build();
        serivce.update(updatedUser);
        return new ResponseEntity<Users>(updatedUser, HttpStatus.OK);
    }


    //------------------- Delete a User --------------------------------------------------------

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Users> deleteSubject(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting user with id " + id);

        Users users = serivce.findById(id);
        if (users == null) {
            System.out.println("Unable to delete. Subject with id " + id + " not found");
            return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
        }

        serivce.delete(users);
        return new ResponseEntity<Users>(HttpStatus.NO_CONTENT);
    }



}
