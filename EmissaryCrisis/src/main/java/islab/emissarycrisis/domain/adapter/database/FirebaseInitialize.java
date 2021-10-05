package islab.emissarycrisis.domain.adapter.database;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Service
@Configuration
public class FirebaseInitialize {


    @PostConstruct
    public void initialize() throws IOException {
//        FileInputStream serviceAccount =
//                new FileInputStream("src/main/resources/static/serviceAccount.json");
        FileInputStream serviceAccount =
              new FileInputStream(ResourceUtils.getFile("classpath:static/serviceAccount.json"));


        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);
    }
}
