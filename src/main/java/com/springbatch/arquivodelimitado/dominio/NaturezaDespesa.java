package com.springbatch.arquivodelimitado.dominio;

import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.util.*;

public class NaturezaDespesa {
    private Integer codigoNaturezaDespesa;
    private String descricaoNaturezaDespesa;

    private final Set<Lancamento> lancamentos = new HashSet<>();

    public NaturezaDespesa() {
    }

    public NaturezaDespesa(DespesaLancamento despesaLancamento) {
        this.codigoNaturezaDespesa = despesaLancamento.getCodigoNaturezaDespesa();
        this.descricaoNaturezaDespesa = despesaLancamento.getDescricaoNaturezaDespesa();
    }

    public Integer getCodigoNaturezaDespesa() {
        return codigoNaturezaDespesa;
    }

    public void setCodigoNaturezaDespesa(Integer codigoNaturezaDespesa) {
        this.codigoNaturezaDespesa = codigoNaturezaDespesa;
    }

    public String getDescricaoNaturezaDespesa() {
        return descricaoNaturezaDespesa;
    }

    public void setDescricaoNaturezaDespesa(String descricaoNaturezaDespesa) {
        this.descricaoNaturezaDespesa = descricaoNaturezaDespesa;
    }

    public Set<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public Double getTotalLancamentos() {
        return lancamentos.stream()
                .map(Lancamento::getValorLancamento)
                .reduce(0.0, Double::sum);
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return "[" + codigoNaturezaDespesa + "] "
                + descricaoNaturezaDespesa + " - " + formatter.format(getTotalLancamentos())
                + "\n"
                + lancamentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NaturezaDespesa that = (NaturezaDespesa) o;
        return Objects.equals(codigoNaturezaDespesa, that.codigoNaturezaDespesa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoNaturezaDespesa);
    }
}
