/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Livraria;

/**
 *
 * @author danub
 */
public class Livro {

    private String titulo;
    private String autor;
    private int totalPag;
    private int pagAtual;
    private boolean aberto;
    private Pessoa leitor;

    Livro(String _titulo, String _autor, int _totalPag, int _pagAtual, boolean _aberto, Pessoa _leitor){
        setTitulo(_titulo);
        setTotalPag(_totalPag);
        setPagAtual(_pagAtual);
        setAberto(_aberto);
        setLeitor(_leitor);
    }
    private String getTitulo() {
        return titulo;
    }

    private void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    private String getAutor() {
        return autor;
    }

    private void setAutor(String autor) {
        this.autor = autor;
    }

    private int getTotalPag() {
        return totalPag;
    }

    private void setTotalPag(int totalPag) {
        this.totalPag = totalPag;
    }

    private int getPagAtual() {
        return pagAtual;
    }

    private void setPagAtual(int pagAtual) {
        this.pagAtual = pagAtual;
    }

    private boolean isAberto() {
        return aberto;
    }

    private void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    private Pessoa getLeitor() {
        return leitor;
    }

    private void setLeitor(Pessoa leitor) {
        this.leitor = leitor;
    }
       
    public void detalhes(){
        System.out.println("-----Livros:");
        System.out.println("Titulo         :"+ getTitulo());
        System.out.println("Feito por      :"+getAutor());
        System.out.println("Possui "+getTotalPag()+" paginas");
        System.out.println("Quem esta lendo:"+getLeitor().getNome());
        System.out.println("e esta na pagina:"+getPagAtual());

  
    } 
    
}
