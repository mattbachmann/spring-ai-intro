package guru.springframework.springaiintro.services;

import guru.springframework.springaiintro.model.Answer;
import guru.springframework.springaiintro.model.CapitalRequest;
import guru.springframework.springaiintro.model.CapitalResponse;
import guru.springframework.springaiintro.model.Question;

public interface OpenAIService {
    CapitalResponse getCapital(CapitalRequest capitalRequest);

    Answer getCapitalWithInfo(CapitalRequest capitalRequest);

    Answer getAnswer(Question question);
}
