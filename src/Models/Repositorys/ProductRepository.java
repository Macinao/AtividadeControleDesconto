package Models.Repositorys;

import Models.Entitys.Product;
import java.util.ArrayList;

public class ProductRepository {
    private ArrayList<Product> products;

    public ProductRepository(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
    public void setProducts(Product product) {
        this.products.add(product);
    }

    public Product findByCodigo(String codigo){
        for(int i = 0; i < products.size(); i++){
            var product = products.get(i);
            if(product.getCodigo().equals(codigo)){
                return product;
            }
        }
        System.out.println("");
        System.out.println("O item nao existe!");
        System.out.println("");
        return null;
    }
}