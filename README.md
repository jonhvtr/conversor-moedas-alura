# 💱 Conversor de Moedas - Java

Aplicação simples em Java que permite converter valores entre moedas usando
a [ExchangeRate-API](https://www.exchangerate-api.com/). O usuário pode escolher a direção da conversão (ex: BRL → USD
ou USD → BRL) e informar o valor que deseja converter. A taxa de câmbio é consultada em tempo real via API.

---

## 🚀 Funcionalidades

- Escolha da direção de conversão com base em um menu.
- Entrada do valor a ser convertido via teclado.
- Consulta da taxa de câmbio atual via requisição HTTP.
- Exibição da taxa e do valor convertido.
- Tratamento de erros comuns (ex: falha na conexão, entrada inválida, erro de parsing JSON).

---

## 📷 Exemplo de Uso

```
Escolha a conversão:
1 - BRL para USD
2 - USD para BRL
Opção: 1
Digite o valor a ser convertido: 100
Convertendo 100.00 BRL para USD...
Taxa de conversão atual: 0.1987
Resultado: 19.87 USD
```

---

## 🛠️ Tecnologias Utilizadas

- Java 11+
- [Gson](https://github.com/google/gson) (para parsing de JSON)
- `HttpClient` (para requisição à API)
- `Scanner` (para entrada via teclado)

---

## 📦 Como Executar

1. **Clone o repositório:**

```bash
git clone https://github.com/jonhvtr/conversor-moedas-alura.git
cd conversor-moedas-alura
```

2. **Adicione sua chave da API:**

1- Crie o arquivo .env na src/main/resources/

````.dotenv
    API_KEY="sua_api_key"
````

🔐 Importante: Nunca compartilhe sua chave. Adicione src/main/resources/.env ao seu .gitignore.

chave válida obtida em [https://www.exchangerate-api.com/](https://www.exchangerate-api.com/).

2- Adicione a dependência do dotenv-java:
Se estiver usando Maven:

`````xml

<dependency>
    <groupId>io.github.cdimascio</groupId>
    <artifactId>dotenv-java</artifactId>
    <version>3.0.0</version>
</dependency>

`````

3. **Compile e execute:**
   **Maven**
   No terminal, na raiz do projeto:

- Compilar:

```bash
mvn compile
```

- Executar:

```bash
mvn exec:java -Dexec.mainClass="com.jonhvtr.Main"

```

---

## 📄 Exemplo de Estrutura JSON da API

```json
{
  "base_code": "BRL",
  "target_code": "USD",
  "conversion_rate": 0.1987,
  "conversion_result": 19.87
}
```

---

## ⚠️ Observações

- Certifique-se de estar conectado à internet para que a requisição à API funcione.
- Verifique os limites da sua conta gratuita na ExchangeRate-API (número de requisições por mês).

---

## 📚 Créditos

Desenvolvido por [João Victor/JonhVtr]  
Baseado na API pública da [ExchangeRate-API](https://www.exchangerate-api.com/)
