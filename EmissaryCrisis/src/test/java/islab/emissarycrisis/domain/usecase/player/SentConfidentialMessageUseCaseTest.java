package islab.emissarycrisis.domain.usecase.player;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SentConfidentialMessageUseCaseTest {

    @BeforeAll
    public static void setup(){
    }

    @Test
    public void sentConfidentialMessageUseCase() {
        SentConfidentialMessageUseCase sentConfidentialMessageUseCase = new SentConfidentialMessageUseCase();
        SentConfidentialMessageUseCaseInput input = new SentConfidentialMessageUseCaseInput();
        SentConfidentialMessageUseCaseOutput output = new SentConfidentialMessageUseCaseOutput();

        input.setFromPlayerId("1");
        input.setToPlayerId("2");
        input.setGameCardId("123");

        sentConfidentialMessageUseCase.execute(input, output);

        assertEquals(Integer.valueOf(4), output.getHandcardCount());
    }
}
