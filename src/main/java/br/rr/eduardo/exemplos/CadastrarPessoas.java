package br.rr.eduardo.exemplos;

import java.time.LocalDate;

public class CadastrarPessoas {

    private ApiDosCorreios apiDosCorreios;

    public CadastrarPessoas(final ApiDosCorreios apiDosCorreios) {
        this.apiDosCorreios = apiDosCorreios;
    }

    public Pessoa cadastrarPessoa(String nome, String documento, LocalDate nascimento, String cep) {
        Pessoa pessoa = new Pessoa(nome, documento, nascimento);
        DadosLocalizacao dadosLocalizacao = apiDosCorreios.buscaDadosComBaseNoCep(cep);
        pessoa.adicionaDadosDeEndereco(dadosLocalizacao);
        return pessoa;
    }
}