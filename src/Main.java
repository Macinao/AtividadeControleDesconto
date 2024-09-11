import Models.Entitys.Product;
import Models.Repositorys.ProductRepository;
import Models.Services.ProductService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> productArrayList = new ArrayList<>();
        ProductRepository productRepository = new ProductRepository(productArrayList);
        ProductService productService = new ProductService(productRepository);
        Scanner scanner = new Scanner(System.in);
        while(true){
            int opcao = 0;
            System.out.println("Inserir item no carrinho: 1");
            System.out.println("Acrescimo de item: 2");
            System.out.println("Desconto de item: 3");
            System.out.println("Acrescimo total: 4");
            System.out.println("Desconto total: 5");
            System.out.println("Finalizar venda: 6");
            System.out.print("Oque deseja fazer: ");
            opcao = scanner.nextInt();

            switch (opcao){
                case(1):
                    System.out.print("Insira o codigo do item: ");
                    String codigoCriar = scanner.next();
                    System.out.print("Insira a descricao do item: ");
                    String descricao = scanner.next();
                    System.out.print("Insira o valor total do item: ");
                    double total = scanner.nextDouble();
                    Product product = new Product(codigoCriar,descricao,total);
                    productService.creatProdut(product);
                    break;
                case(2):
                    System.out.print("Insira o codigo do produto: ");
                    String codigoAcrescimo = scanner.next();
                    System.out.print("Quando deseja acrescentar: ");
                    double acrescimo = scanner.nextDouble();
                    productService.addAcrescimo(codigoAcrescimo,acrescimo);
                    break;
                case(3):
                    System.out.print("Insira o codigo do produto: ");
                    String codigoDesconto = scanner.next();
                    System.out.print("Qual o desconto do item: ");
                    double desconto = scanner.nextDouble();
                    productService.addDesconto(codigoDesconto,desconto);
                    break;
                case(4):
                    System.out.print("Qual o acrescimo total: ");
                    double acrescimoTotal = scanner.nextDouble();
                    productService.acrescimoTotal(acrescimoTotal);
                    break;
                case(5):
                    System.out.print("Qual o desconto total: ");
                    double descontoTotal = scanner.nextDouble();
                    productService.descontoTotal(descontoTotal);
                    break;
                case(6):
                    productService.finalizarVenda();
                    return;
            }
        }
    }
}