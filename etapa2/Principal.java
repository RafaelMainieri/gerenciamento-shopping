package lab1.zDesafio.etapa2;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Loja loja = null;
        Produto produto = null;

        int selecao = 0;
        while (selecao != 3) {
            System.out.println("(1) Criar uma loja");
            System.out.println("(2) Criar um produto");
            System.out.println("(3) Sair");
            System.out.print("Selecione uma opção: ");
            selecao = input.nextInt();
            input.nextLine();

            if (selecao == 1) {
                System.out.print("Insira o nome da loja: ");
                String nome = input.nextLine();
                System.out.print("Insira a quantidade de funcionários: ");
                int quantidadeFuncionarios = input.nextInt();
                System.out.print("Insira o salário base dos funcionários: ");
                double salarioBaseFuncionarios = input.nextDouble();
                input.nextLine();

                System.out.println(">> ENDEREÇO DA LOJA << ");
                System.out.print("Rua: ");
                String rua = input.nextLine();
                System.out.print("Cidade: ");
                String cidade = input.nextLine();
                System.out.print("Estado: ");
                String estado = input.nextLine();
                System.out.print("País: ");
                String pais = input.nextLine();
                System.out.print("CEP: ");
                String cep = input.nextLine();
                System.out.print("Número: ");
                String numero = input.nextLine();
                System.out.print("Complemento: ");
                String complemento = input.nextLine();
                Endereco endereco = new Endereco(rua, cidade, estado, pais, cep, numero, complemento);

                System.out.println(">> DATA DE FUNDAÇÃO << ");
                System.out.print("Dia: ");
                int dia = input.nextInt();
                System.out.print("Mes: ");
                int mes = input.nextInt();
                System.out.print("Ano: ");
                int ano = input.nextInt();
                Data dataLoja = new Data(dia, mes, ano);

                loja = new Loja(nome, quantidadeFuncionarios, salarioBaseFuncionarios, endereco, dataLoja);

                System.out.println("Loja criada com sucesso!");
                System.out.println("-----");
                System.out.println(loja.toString());
                System.out.println("\n");

            } else if (selecao == 2) {
                System.out.print("Insira o nome do produto: ");
                String nome = input.nextLine();
                System.out.print("Insira o preço do produto: ");
                double preco = input.nextDouble();
                input.nextLine();

                System.out.println(" >> DATA DE VALIDADE <<:");
                System.out.print("Dia: ");
                int dia = input.nextInt();
                System.out.print("Mes: ");
                int mes = input.nextInt();
                System.out.print("Ano: ");
                int ano = input.nextInt();
                Data dataProduto = new Data(dia, mes, ano);

                produto = new Produto(nome, preco, dataProduto);

//                System.out.println("Produto criado com sucesso!");
//                System.out.println("-----");
//                System.out.println(produto.toString());

                if (produto.estaVencido(new Data(20, 10, 2023))) {
                    System.out.println("PRODUTO VENCIDO");
                } else {
                    System.out.println("PRODUTO NÃO VENCIDO");
                }

                System.out.println(" ");
            } else if (selecao == 3) {
                return;
            } else {
                System.out.println("Opção inválida");
            }
        }

    }
}
