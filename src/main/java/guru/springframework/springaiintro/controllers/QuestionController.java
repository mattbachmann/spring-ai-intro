package guru.springframework.springaiintro.controllers;

import guru.springframework.springaiintro.model.Answer;
import guru.springframework.springaiintro.model.CapitalRequest;
import guru.springframework.springaiintro.model.CapitalResponse;
import guru.springframework.springaiintro.model.Question;
import guru.springframework.springaiintro.services.OpenAIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {
    static Logger LOG = LoggerFactory.getLogger(QuestionController.class);
    private final OpenAIService openAIService;

    public QuestionController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @PostMapping("/ask")
    public Answer askQuestion(@RequestBody Question question) {
        return this.openAIService.getAnswer(question);
    }

    @PostMapping("/capital")
    public CapitalResponse askCapital(@RequestBody CapitalRequest request) {
        return this.openAIService.getCapital(request);
    }

    @PostMapping("/capital-with-info")
    public Answer askCapitalWithInfo(@RequestBody CapitalRequest request) {
        return this.openAIService.getCapitalWithInfo(request);
    }
}
