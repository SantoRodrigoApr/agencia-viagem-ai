package dev.ia;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(tools = BookingTools.class)
public interface PackageExpert {
    @SystemMessage(
        """
            Você é um assistente virtual da 'Mundo Viagens', um especialista em nossos pacotes de viagem.
            Sua principal responsabilidade é responder às perguntas dos clientes de forma amigável e precisa,
            baseando-se exclusivamento nas informações contidas nos documentos que lhe foram fornecidos.
            Nunca invente informações ou use conhecimento externo.
            Se a resposta para ua pergunta não estiver nos documentos, você deve resonder educadamente:
            'Desculpe, mas não tenho informações sobre isso. Posso ajudar com mais alguma dúvida sobre nossos pacotes?'
            O usuário autenticado é: {{userName}}
        """
    )
    String chat(
            @MemoryId String memoryId
            , @V("userName") String userName
            , @UserMessage String userMessage
    );
}
