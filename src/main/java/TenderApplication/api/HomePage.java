package TenderApplication.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by student on 2015/07/30.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage
{
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String index()
    {
        return "This is Home Page.";
    }
}
