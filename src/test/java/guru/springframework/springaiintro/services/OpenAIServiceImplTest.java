package guru.springframework.springaiintro.services;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OpenAIServiceImplTest {
    Logger LOG = LoggerFactory.getLogger(OpenAIServiceImplTest.class);

    @Autowired
    OpenAIServiceImpl openAIService;

    @Test
    void getAnswer() {
        String answer = openAIService.getAnswer("Tell me a dad joke.");
        LOG.info("Answer: {}", answer);
        assertNotNull(answer);
        assertNotEquals("", answer);
    }
}