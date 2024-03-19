package com.springbatch.arquivodelimitado.dominio;

import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class NaturezaDespesa {
    private Integer codigoNaturezaDespesa;
    private String descricaoNaturezaDespesa;

    private final List<Lancamento> lancamentos = new ArrayList<>();

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

    public List<Lancamento> getLancamentos() {
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
                + descricaoNaturezaDespesa + " - R$ " + formatter.format(getTotalLancamentos())
                + "\n"
                + lancamentos;
    }
}
