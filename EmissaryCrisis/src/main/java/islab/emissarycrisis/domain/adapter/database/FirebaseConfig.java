package islab.emissarycrisis.domain.adapter.database;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirebaseConfig {
    @Bean
    Firestore getDb() {
        return FirestoreClient.getFirestore();
    }
}
