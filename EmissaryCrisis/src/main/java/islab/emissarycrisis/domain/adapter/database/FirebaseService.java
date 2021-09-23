package islab.emissarycrisis.domain.adapter.database;

import com.google.api.core.ApiFuture;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import islab.emissarycrisis.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class FirebaseService {
    public String saveCard() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Map<String, Object> data = new HashMap<>();
        data.put("name", "試探");
        data.put("type", "密電");
        data.put("color", "black");
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("card").document().set(data);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
}
