package br.ce.wcaquino.config;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import io.cucumber.java.ParameterType;

public class RegistryCucumber {

    @ParameterType(".*")
    public Date data(String s) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date retorno = format.parse(s);
            return retorno;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @ParameterType(".*") // Registrar o tipo de parâmetro {data}
    public Date dataParameter(String s) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date retorno = format.parse(s);
            return retorno;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @ParameterType(".*") // Registrar o tipo de parâmetro {data}
    public Date dataParameter2(String s) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date retorno = format.parse(s);
            return retorno;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    // ... outros tipos de parâmetros personalizados e métodos

    public Locale locale() {
        return Locale.ENGLISH;
    }
}
