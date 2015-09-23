package TenderApplication.apiTest.intergationTest;

import TenderApplication.Domain.Department;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by student on 2015/09/17.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = TenderApplication.class)
//@WebAppConfiguration
//@IntegrationTest({"server.port=8080"})

public class DepartmentAPI {

   final String BASE_URL = "http://localhost:8080/";
    private RestTemplate template;

    //@Before
    public void setUp() throws Exception {
        template = new TestRestTemplate();
    }

   /* @Test
    public void testRead() throws Exception
    {
        ResponseEntity<String> response =template.getForEntity(BASE_URL+"api/department", String.class);

        System.out.println("The response is "+response.getBody());
    }*/


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
        Department department = restTemplate.getForObject(REST_SERVICE_URI+"/department/1", Department.class);
        System.out.println(department);
    }

    /* PUT */
    private static void updateUser() {
        System.out.println("Testing update department API----------");
        RestTemplate restTemplate = new RestTemplate();
        Department department  =  new Department.Builder("Mvuleni").projects("Agriculture Trender").build();
        restTemplate.put(REST_SERVICE_URI+"/department/update/1", department);
        System.out.println(department);
    }

    /* DELETE */
    private static void deleteUser() {
        System.out.println("Testing delete department API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/department/delete/3");
    }

}
