package dev.ia;

import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface TravelAgentAssistant {

    /**
     * O metodo 'chat' recebe uma mensagem do usuario e retorna a resposta do LLM.
     * @param userMessage A mensagem do usuario
     * @return A resposta gerada pelo modelo de linguagem
     */
    String chat(String userMessage);
}