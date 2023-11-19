
package model.bean;


public class TabelaOS {
    
private int Ordem ;
private int dataOrdem ;
private String Servico ;
private float Preco  ;
private float tempoObra ;
private String Endereco ;
private int idclientes;

    public int getOrdem() {
        return Ordem;
    }

    public void setOrdem(int Ordem) {
        this.Ordem = Ordem;
    }

    public int getDataOrdem() {
        return dataOrdem;
    }

    public void setDataOrdem(int dataOrdem) {
        this.dataOrdem = dataOrdem;
    }

    public String getServico() {
        return Servico;
    }

    public void setServico(String Servico) {
        this.Servico = Servico;
    }

    public float getPreco() {
        return Preco;
    }

    public void setPreco(float Preco) {
        this.Preco = Preco;
    }

    public float getTempoObra() {
        return tempoObra;
    }

    public void setTempoObra(float tempoObra) {
        this.tempoObra = tempoObra;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public int getIdclientes() {
        return idclientes;
    }

    public void setIdclientes(int idclientes) {
        this.idclientes = idclientes;
    }

   
    
}
