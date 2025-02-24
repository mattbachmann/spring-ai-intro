package guru.springframework.springaiintro.services;

import guru.springframework.springaiintro.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OpenAIServiceImpl implements OpenAIService {
    static Logger LOG = LoggerFactory.getLogger(OpenAIServiceImpl.class);

    private final ChatModel chatModel;

    @Value("classpath:templates/capital-prompt.st")
    private Resource capitalPrompt;

    public OpenAIServiceImpl(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @Override
    public CapitalResponse getCapital(CapitalRequest capitalRequest) {
        LOG.info("getCapital called");
        BeanOutputConverter<CapitalResponse> converter = new BeanOutputConverter<>(CapitalResponse.class);
        String format = converter.getFormat();
        LOG.info("format: {}", format);
        PromptTemplate promptTemplate = new PromptTemplate(capitalPrompt);
        Prompt prompt = promptTemplate.create(Map.of("stateOrCountry", capitalRequest.stateOrCountry(),
                "format", format));
        ChatResponse response = chatModel.call(prompt);

        return converter.convert(response.getResult().getOutput().getContent());
    }

    @Override
    public CapitalWithInfoResponse getCapitalWithInfo(CapitalRequest capitalRequest) {
        LOG.info("getCapitalWithInfo called");
        BeanOutputConverter<CapitalWithInfoResponse> converter = new BeanOutputConverter<>(CapitalWithInfoResponse.class);
        String format = converter.getFormat();
        LOG.info("format: {}", format);
        PromptTemplate promptTemplate = new PromptTemplate(capitalPrompt);
        Prompt prompt = promptTemplate.create(Map.of("stateOrCountry", capitalRequest.stateOrCountry(),
                "format", format));
        ChatResponse response = chatModel.call(prompt);

        return converter.convert(response.getResult().getOutput().getContent());
    }

    @Override
    public Answer getAnswer(Question question) {
        LOG.info("GetAnswer called");
        PromptTemplate promptTemplate = new PromptTemplate(question.question());
        Prompt prompt = promptTemplate.create();

        ChatResponse response = chatModel.call(prompt);

        return new Answer(response.getResult().getOutput().getContent());
    }
}
