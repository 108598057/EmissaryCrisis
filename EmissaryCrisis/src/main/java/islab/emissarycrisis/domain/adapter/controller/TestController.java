package islab.emissarycrisis.domain.adapter.controller;

import islab.emissarycrisis.domain.adapter.database.FirebaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.ExecutionException;

@Controller
public class TestController {

    @RequestMapping("/test")
    public String getProduct(@RequestParam(value="title", required=false, defaultValue="xiao") String id) {
        FirebaseService firebaseService = new FirebaseService();
        try {
            firebaseService.saveCard();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test/test";
    }
}
