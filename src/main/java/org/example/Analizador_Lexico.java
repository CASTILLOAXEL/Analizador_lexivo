package org.example;
import java.util.Scanner;

public class Analizador_Lexico {

    public static void main(String[] args) {
        // Inicializar un objeto Scanner para la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Menú para que el usuario seleccione una opción
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("----------------------------Seleccione una opción para que el analizador lo lea:------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("------ Oprima   1.   Para Ingresar el código fuente-----------");
            System.out.println("-------Oprima   0.  si dea Salir---------------------------------");


            // Leer la opción del usuario
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea después de nextInt()

            switch (choice) {
                case 1:
                    // Opción 1: Ingresar el código fuente y realizar el análisis léxico
                    System.out.println("Ingrese el código fuente:");
                    String sourceCode = scanner.nextLine();
                    analyze(sourceCode);
                    break;
                case 0:
                    // Opción 0: Salir del programa
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    // Opción no válida
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    public static void analyze(String code) {
        // Expresiones regulares para reconocer tokens
        String identifierPattern = "[a-zA-Z][a-zA-Z0-9]{0,14}";
        String integerConstantPattern = "0|[1-9][0-9]*|100";
        String operatorPattern = "[+\\-*/:=]";
        String relationalOperatorPattern = ">|<|>=|<=|==|<>|\\{|\\}|\\[|\\]|\\(|\\)|,|;|\\.\\.";
        String stringPattern = "\"[bfhjk]*\"";

        // Dividir el código en tokens utilizando el espacio como delimitador
        String[] tokens = code.split("\\s+");

        // Analizar cada token e imprimir su tipo
        for (String token : tokens) {
            if (isKeyword(token)) {
                System.out.println("Palabra reservada: " + token);
            } else if (token.matches(identifierPattern)) {
                if (token.length() <= 15) {
                    System.out.println("Identificador: " + token);
                } else {
                    System.out.println("Error: Identificador demasiado largo - " + token);
                }
            } else if (token.matches(integerConstantPattern)) {
                System.out.println("Constante entera: " + token);
            } else if (token.matches(operatorPattern)) {
                System.out.println("Operador: " + token);
            } else if (token.matches(relationalOperatorPattern)) {
                System.out.println("Operador relacional: " + token);



            } else if (token.matches(stringPattern)) {
                System.out.println("Cadena de caracteres: " + token);
            } else {
                System.out.println("Token no reconocido: " + token);
            }
        }
    }

    private static boolean isKeyword(String token) {
        // Lista de palabras reservadas
        String[] keywords = {"if", "else", "for", "print", "int", "bfhjk"};
        for (String keyword : keywords) {
            if (token.equals(keyword)) {
                return true;
            }
        }
        return false;
    }
}
