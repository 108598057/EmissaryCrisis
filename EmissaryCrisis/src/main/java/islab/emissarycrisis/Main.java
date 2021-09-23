package islab.emissarycrisis;

import islab.emissarycrisis.domain.adapter.database.FirebaseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutionException;

@SpringBootApplication //@SpringBootApplication 標記代表這是啟動 Spring Boot 的類別
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        //SpringApplication.run 會進行啟動的動作
    }
}
