package Models.Entitys;

public class Product {
    private String codigo;
    private String descricao;
    private double acrescimo;
    private double desconto;
    private double total;

    public Product(String codigo, String descricao, double total){
        this.codigo = codigo;
        this.descricao = descricao;
        this.acrescimo = 0;
        this.desconto = 0;
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(double acrescimo) {
        if(acrescimo <= 0){
            System.out.println("");
            System.out.println("Valor do acrescimo invalido!");
            System.out.println("");
        }else{
            this.total = total + acrescimo;
            this.acrescimo += acrescimo;
            System.out.println("");
            System.out.println("Acrescimo realizado com suscesso o valor total agora e de: "+total);
            System.out.println("");
        }
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        if(desconto <= 0){
            System.out.println("");
            System.out.println("Valor do desconto invalido!");
            System.out.println("");
        } else if(desconto > total) {
            this.desconto += total;
            this.total = 0;
            System.out.println("");
            System.out.println("O desconte nao pode ser maior que o valor total agora e de: "+total);
            System.out.println("");
        }else{
            this.total = total - desconto;
            this.desconto += desconto;
            System.out.println("");
            System.out.println("Desconto realizado com suscesso o valor total agora e de: "+total);
            System.out.println("");
        }
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "codigo= " + codigo +
                ", descricao= " + descricao +
                ", acrescimo= " + acrescimo +
                ", desconto= " + desconto +
                ", total= " + total;
    }
}