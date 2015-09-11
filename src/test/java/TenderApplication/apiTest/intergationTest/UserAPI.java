package TenderApplication.apiTest.intergationTest;

import TenderApplication.Domain.Users;
import TenderApplication.TenderApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by student on 2015/09/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TenderApplication.class)
@WebAppConfiguration
@IntegrationTest({"server.port=8080"})
public class UserAPI {

    final String BASE_URL = "http://localhost:8080/";
    private RestTemplate template;

    @Before
    public void setUp() throws Exception {
        template = new TestRestTemplate();
    }

    @Test
    public void testRead() throws Exception {
        ResponseEntity<String> response =template.getForEntity(BASE_URL+"api/subject/readall", String.class);

        System.out.println("The response is "+response.getBody());
    }


    public static final String REST_SERVICE_URI = "http://localhost:8080/api";


    @SuppressWarnings("unchecked")
    private static void listAllSubjects(){
        System.out.println("Testing listAllSubjects API-----------");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> SubjectsMap = restTemplate.getForObject(REST_SERVICE_URI+"/subjects/", List.class);

        if(SubjectsMap!=null){
            for(LinkedHashMap<String, Object> map : SubjectsMap){
                System.out.println("user : id="+map.get("id")+", account="+map.get("account")+", Age="+map.get("age")+", Salary="+map.get("salary"));;
            }
        }else{
            System.out.println("No user exist----------");
        }
    }

    /* GET */
    private static void getUser(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        Users users = restTemplate.getForObject(REST_SERVICE_URI+"/user/1", Users.class);
        System.out.println(users);
    }

    /* PUT */
    private static void updateUser() {
        System.out.println("Testing update users API----------");
        RestTemplate restTemplate = new RestTemplate();
        Users users  =  new Users.Builder("100").account("ABSA bank").build();
        restTemplate.put(REST_SERVICE_URI+"/user/update/1", users);
        System.out.println(users);
    }

    /* DELETE */
    private static void deleteUser() {
        System.out.println("Testing delete user API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/user/delete/3");
    }

}
