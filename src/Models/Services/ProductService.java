package Models.Services;

import Models.Entitys.Product;
import Models.Repositorys.ProductRepository;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void creatProdut(Product product){
        boolean valor = validationProduct(product);
        if(valor){
            System.out.println("");
            System.out.println("Produto adicionado com suscesso!");
            System.out.println("");
            this.productRepository.setProducts(product);
        }else{
            System.out.println("");
            System.out.println("Alguns dos valores esta invalido tente novamente!");
            System.out.println("");
        }
    }

    boolean validationProduct(Product product){
        var productslist = productRepository.getProducts();
        if(product.getTotal() < 0){
            return false;
        }
        for(int i = 0; i < productslist.size(); i++){
            var valor = productslist.get(i);
            if(valor.getCodigo().equals(product.getCodigo())){
                return false;
            }
        }
        return true;
    }
    public void addAcrescimo(String codigo, double acrescimo){
         Product productAcrescimo = productRepository.findByCodigo(codigo);
         if(productAcrescimo != null) {
             productAcrescimo.setAcrescimo(acrescimo);
         }
    }

    public void addDesconto(String codigo, double desconto){
        Product productDesconto = productRepository.findByCodigo(codigo);
        if(productDesconto != null) {
            productDesconto.setDesconto(desconto);
        }
    }

    public void acrescimoTotal(double acrescimo){
        var list = productRepository.getProducts();
        double divide = acrescimo / list.size();
        for(int i = 0; i < list.size(); i++){
            list.get(i).setAcrescimo(divide);
        }
    }

    public void descontoTotal(double desconto){
        var list = productRepository.getProducts();
        double divide = desconto / list.size();
            for(int i = 0; i < list.size(); i++){
            list.get(i).setDesconto(divide);
        }
    }

    public void finalizarVenda(){
        var list = productRepository.getProducts();
        double descontoTotal = 0;
        double acrescimoTotal = 0;
        double valorTotal = 0;
        for(int i = 0; i < list.size(); i++){
            int contador = i + 1;
            System.out.println("item: " + contador);
            System.out.println(list.get(i));
            descontoTotal += list.get(i).getDesconto();
            acrescimoTotal += list.get(i).getAcrescimo();
            valorTotal += list.get(i).getTotal();
        }
        valorTotal = valorTotal + acrescimoTotal - descontoTotal;
        System.out.println("Desconto total: " + descontoTotal);
        System.out.println("Acrescimo total: " + acrescimoTotal);
        System.out.println("Valor total: " + valorTotal);
    }
}