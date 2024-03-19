package com.springbatch.arquivodelimitado.dominio;

import org.springframework.format.datetime.DateFormatter;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Lancamento {
    private String descricaoLancamento;
    private LocalDate dataLancamento;
    private Double valorLancamento;

    public String getDescricaoLancamento() {
        return descricaoLancamento;
    }

    public void setDescricaoLancamento(String descricaoLancamento) {
        this.descricaoLancamento = descricaoLancamento;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Double getValorLancamento() {
        return valorLancamento;
    }

    public void setValorLancamento(Double valorLancamento) {
        this.valorLancamento = valorLancamento;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        return "[" + dataLancamento.format(dateFormatter) + "] "
                + descricaoLancamento + " - "
                + numberFormat.format(valorLancamento) + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lancamento that = (Lancamento) o;
        return Objects.equals(descricaoLancamento, that.descricaoLancamento) && Objects.equals(dataLancamento, that.dataLancamento) && Objects.equals(valorLancamento, that.valorLancamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricaoLancamento, dataLancamento, valorLancamento);
    }
}
