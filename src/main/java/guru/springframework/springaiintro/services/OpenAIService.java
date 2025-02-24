package guru.springframework.springaiintro.services;

import guru.springframework.springaiintro.model.*;

public interface OpenAIService {
    CapitalResponse getCapital(CapitalRequest capitalRequest);

    CapitalWithInfoResponse getCapitalWithInfo(CapitalRequest capitalRequest);

    Answer getAnswer(Question question);
}
