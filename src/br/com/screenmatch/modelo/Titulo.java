package br.com.screenmatch.modelo;

import br.com.screenmatch.excecao.ErroDeConversaoDeAnoException;

public class Titulo implements Comparable<Titulo> {

    private String nome;
    private int anoDeLancamento;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    private int duracaoEmMinutos;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();

        if (meuTituloOmdb.year().length() > 4){
            throw new ErroDeConversaoDeAnoException("Não consegui converter o ano porque tem mais de 04 caracteres.");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 2));
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica() {
        System.out.println("Nome do br.com.screenmatch.modelo.Filme " + nome);
        System.out.println("Ano de Lancamento" + anoDeLancamento);
        System.out.println("Duração do filmes " + duracaoEmMinutos);
        System.out.println("Esta incluso no plano " + incluidoNoPlano);
    }

    public void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;

    }

    public double pegaMedia() {

        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }


    @Override
    public String toString() {
        return "(nome = " + nome +
                ", anoDeLancamento = " + anoDeLancamento + "," +
                " duração = " + duracaoEmMinutos + ")";
    }
}
