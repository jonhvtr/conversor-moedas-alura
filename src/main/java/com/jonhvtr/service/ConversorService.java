package com.jonhvtr.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.jonhvtr.domain.dto.ConversorDTO;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversorService {

    public void cotacao() {
        Dotenv dotenv = Dotenv.load();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("Moeda de origem:");
            String base_code = scan.nextLine().toUpperCase();
            System.out.println("Moeda de destino:");
            String target_code = scan.nextLine().toUpperCase();

            String api_key = dotenv.get("API_KEY");
            String url_pair = "https://v6.exchangerate-api.com/v6/" + api_key
                    + "/pair/" + base_code + "/" + target_code;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url_pair))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            ConversorDTO conversorDTO = gson.fromJson(json, ConversorDTO.class);

            System.out.printf("Conversão escolhida: [%s ➜ %s]%n", base_code, target_code);
            System.out.printf("Taxa de conversão atual: %.4f\n", conversorDTO.conversion_rate());
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro na conexaõ com a API: " + e.getMessage());
        } catch (JsonSyntaxException e) {
            System.out.println("Erro ao interpretar a resposta da API (JSON inválido): " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Use números onde for necessário");
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    public void conversorMoedas() {
        Dotenv dotenv = Dotenv.load();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Seja bem-vindo ao Conversor de Moeda =]");
            System.out.println();
            System.out.println("1) Dólar ==> Peso Argentino");
            System.out.println("2) Peso Argentino ==> Dólar");
            System.out.println("3) Dólar ==> Real Brasileiro");
            System.out.println("4) Real Brasileiro ==> Dólar");
            System.out.println("5) Dólar ==> Peso Colombiano");
            System.out.println("6) Peso Colombiano ==> Dólar");
            System.out.println("7...) Sair");
            System.out.println("Escolha uma opção válida:");
            System.out.println("==============================================");
            int opcao = scan.nextInt();

            String base_code = "";
            String target_code = "";

            try {
                if (opcao == 1) {
                    base_code = "USD";
                    target_code = "ARS";
                } else if (opcao == 2) {
                    base_code = "ARS";
                    target_code = "USD";
                } else if (opcao == 3) {
                    base_code = "USD";
                    target_code = "BRL";
                } else if (opcao == 4) {
                    base_code = "BRL";
                    target_code = "USD";
                } else if (opcao == 5) {
                    base_code = "USD";
                    target_code = "COP";
                } else if (opcao == 6) {
                    base_code = "COP";
                    target_code = "USD";
                } else {
                    System.out.println("Saindo...");
                    break;
                }
                System.out.println("Digite o valor que deseja converter:");

                double amount_to_convert = scan.nextDouble();
                String api_key = dotenv.get("API_KEY");
                String url_pair_value = "https://v6.exchangerate-api.com/v6/" + api_key
                        + "/pair/" + base_code + "/" + target_code + "/" + amount_to_convert;

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url_pair_value))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                ConversorDTO conversorDTO = gson.fromJson(json, ConversorDTO.class);

                System.out.printf("Convertendo %.2f %s para %s...\n", amount_to_convert, base_code, target_code);
                System.out.printf("Taxa de conversão atual: %.4f\n", conversorDTO.conversion_rate());
                System.out.printf("Resultado: %.2f %s\n", conversorDTO.conversion_result(), target_code);

            } catch (IOException | InterruptedException e) {
                System.out.println("Erro na conexaõ com a API: " + e.getMessage());
            } catch (JsonSyntaxException e) {
                System.out.println("Erro ao interpretar a resposta da API (JSON inválido): " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Use números onde for necessário");
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }
    }

}
