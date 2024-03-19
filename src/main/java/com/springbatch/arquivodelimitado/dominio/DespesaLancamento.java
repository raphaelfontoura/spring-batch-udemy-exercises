package com.springbatch.arquivodelimitado.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DespesaLancamento {
    private Integer codigoNaturezaDespesa;
    private String descricaoNaturezaDespesa;
    private String descricaoLancamento;
    private String dataLancamento;
    private Double valorLancamento;

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

    public String getDescricaoLancamento() {
        return descricaoLancamento;
    }

    public void setDescricaoLancamento(String descricaoLancamento) {
        this.descricaoLancamento = descricaoLancamento;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
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
        return "DespesaLancamento{" +
                "codigoNaturezaDespesa=" + codigoNaturezaDespesa +
                ", descricaoNaturezaDespesa='" + descricaoNaturezaDespesa + '\'' +
                ", descricaoLancamento='" + descricaoLancamento + '\'' +
                ", dataLancamento=" + dataLancamento +
                ", valorLancamento=" + valorLancamento +
                '}';
    }
}
