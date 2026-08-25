# Create Quarkus Project 
Create Quarkus project: 
```shell scrpit
     mvn "io.quarkus.platform:quarkus-maven-plugin:3.2.10.Final:create"
        -DprojectGroupId="dev.ia"
        -DprojectArtifactId="agencia-viagem-ai"
        -Dextensions="quarkus-rest, quarkus-langchain4j-ollama"
```

# Common Ollama Models:
 - gpt-oss:20b >> (*Using in this project*)
 - llama3.2:latest
 - llama3.2:3b
 - nomic-embed-text:v1.5
 - nomic-embed-test:latest

### Additional Extensions:
- quarkus-langchain4j-easy-rag

# Model Applicatoin Sample:

***Command (Question):***

```shell script
curl -X POST -H "Content-Type text/plain" -d "Por favor cancele minha reserva 67890. Meu ultimo nome e Smith." http://localhost:8080/travel
```

```shell script
curl -X POST -H "Content-type: text/plain" -d "Qual a politica de cancelamento para o pacote Aventura Amazonica?" http://localhost:8080/travel
```

```shell script
curl -X POST -H "Content-Type: text/plain" -d "Estou planejando uma viagem para o Japao. Qual a melhor epoca do ano para visitar e porque? Resposta em portugues" http://localhost:8080/travel
```

***Answer:***

## 2. Qual a politica de cancelamento para o pacote Aventura Amazonica?
A política de cancelamento do Pacote **Aventura Amazônica** prevê um reembolso de **80%** se o cancelamento for feito com **30 dias de antecedência**.


## 1. Estou planejando uma viagem para o Japao. Qual a melhor epoca do ano para visitar e porque? Resposta em portugues
### Qual a melhor época do ano para visitar o Japão?
Em geral, **a primavera (final de março a início de abril) e o outono (final de setembro a início de novembro)** são consideradas as melhores épocas para explorar o Japão. Cada estação tem suas particularidades, mas ambas combinam clima agradável, paisagens incríveis e uma variedade de eventos culturais.

| Estação | Quando | Clima | O que oferece | Por que é recomendada |
|---------|--------|-------|---------------|-----------------------|
| **Primavera** | 23 março – 10 abril (pico de floração das cerejeiras) | Temperaturas entre 10 °C – 20 °C, pouco vento | **Cerejeiras (sakura)**, festivais de primavera (hanami), paisagens verdes, clima confortável | 1️⃣ A beleza das sakura é única no mundo. <br>2️⃣ Os parques e ruas ficam repletos de luzes suaves. <br>3️⃣ Os dias são longos e a maioria das atrações tem boa iluminação natural. |
| **Outono** | 23 setembro – 10 novembro (pico da folhagem vermelha) | Temperaturas entre 15 °C – 25 °C, ar seco e fresco | **Folhas de maple (koyo)**, campos de arroz, festivais de arroz, clima seco e confortável | 1️⃣ As cores do outono são intensas e fáceis de apreciar em templos, montanhas e vilarejos. <br>2️⃣ Menor umidade que na primavera. <br>3️⃣ O clima ainda permite atividades ao ar livre sem o calor intenso. |

> **Dica de Ouro** – Se você quer evitar multidões e aproveitar preços mais baixos, prefira **início de abril** ou **final de setembro**.
> **Por que não o verão ou o inverno?**
> - **Verão (junho‑agosto)**: alta umidade, chuvas de monção, temperaturas acima de 30 °C, especialmente no sul.
> - **Inverno (dezembro‑fevereiro)**: frio intenso em regiões montanhosas, risco de neve pesada em áreas do norte e do interior. Embora seja ótimo para esportes de neve, não é a melhor opção para quem busca explorar cidades e templos com facilidade.

---

## Por que escolher a primavera ou o outono?

1. **Clima Moderado**
   - **Temperaturas entre 10 °C e 25 °C** permitem caminhar por todo o dia sem calor ou frio extremos.
   - Pouca umidade, o que ajuda a manter a energia para longas caminhadas, passeios de trem ou visitas a parques.

2. **Paisagens Icônicas**
   - **Sakura**: o Japão inteiro celebra a floração das cerejeiras. Desde os parques de Tóquio até as vilas rurais, os jardins de sakura são um espetáculo visual.
   - **Folhagem**: as cores vermelhas e douradas do outono são especialmente marcantes nos templos antigos e nas trilhas de montanhas como a região de Nikko ou a região de Hakone.

3. **Eventos Culturais**
   - **Hanami**: festivais de observação de sakura, onde famílias, amigos e turistas se reúnem sob as árvores para piqueniques.
   - **Festivais de arroz**: no outono, muitas cidades celebram a colheita com barracas de comida, música e demonstrações de artesanato.
   - **Festas de verão (como Gion Matsuri)** também ocorrem no outono, mas os locais ficam mais amenizados, já que o clima está mais seco.

4. **Acessibilidade e Transporte**
   - O **JR Pass** e os trens de alta velocidade (Shinkansen) funcionam normalmente nas duas estações, com poucas interrupções climáticas.
   - Em geral, não há interrupções de vôo nem de transporte devido a chuvas intensas ou neve.

5. **Fotografia**
   - Luz suave, dias claros e cores vibrantes tornam a primavera e o outono as épocas mais fotogênicas para capturar templos, castelos e paisagens naturais.

---

## Sugestões de roteiro para cada estação

| Estação | Roteiro típico | Dicas práticas |
|---------|----------------|----------------|
| **Primavera** | 1‑2 dias em Tóquio (Shinjuku Gyoen, Ueno, Ginza) <br>1 dia em Hakone (Onsen, lago Ashi) <br>1‑2 dias em Kyoto (Templos Arashiyama, Fushimi Inari) <br>1 dia em Nara (Templo Todai‑ji, Parque de Cérvis) | Reserve hotéis perto de estações de trem. Planeje um “Hanami” no parque Ueno ou no Jardim Imperial de Tóquio. |
| **Outono** | 1‑2 dias em Tóquio (Jardim Hamarikyu, Shibuya) <br>1 dia em Nikko (Templo Toshogu, natureza ao redor) <br>1‑2 dias em Kyoto (Templos Kiyomizu‑dera, Higashiyama) <br>1 dia em Kanazawa (Jardim Kenrokuen, distrito de geishas) | Leve guarda‑roupa leve e um casaco leve para as noites. Aproveite as festas de arroz em Kanazawa ou em cidades de arroz. |

---

## Resumo

- **Primavera (final de março – início de abril)**: clima ameno, sakura em todo o país, festivais de hanami.
- **Outono (final de setembro – início de novembro)**: clima seco e fresco, folhas vermelhas e douradas, festivais de colheita.
- **Evite verão (chuvas de monção) e inverno (frio intenso e neve pesada)**, a menos que seu objetivo seja esquiar ou visitar regiões montanhosas.

Escolha a estação que mais se alinha com seus interesses: se quer a magia das cerejeiras, vá na primavera; se prefere cores vibrantes e clima seco, o outono é a escolha. Boa viagem! 🌸🍁✈️



curl -X POST -H "Content-Type: text/plain" -d "Qual a politica de cancelamento para o pacote Aventura Amazonica? Resposta em portugues." http://localhost:8080/travel















