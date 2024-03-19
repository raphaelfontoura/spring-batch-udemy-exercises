package com.springbatch.arquivodelimitado.repository;

import com.springbatch.arquivodelimitado.dominio.DespesaLancamento;
import com.springbatch.arquivodelimitado.dominio.Lancamento;
import com.springbatch.arquivodelimitado.dominio.NaturezaDespesa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class NaturezaDespesaRepository {

    private static final Set<NaturezaDespesa> naturezaDespesas = new HashSet<>();

    public static Set<NaturezaDespesa> getAllNaturezaDespesa(List<DespesaLancamento> despesaLancamentos) {
        despesaLancamentos.forEach(despesaLancamento -> {
            Optional<NaturezaDespesa> actual = naturezaDespesas.stream().filter(naturezaDespesa ->
                    Objects.equals(naturezaDespesa.getCodigoNaturezaDespesa(), despesaLancamento.getCodigoNaturezaDespesa())
            ).findFirst();
            if (actual.isPresent()) {
                Lancamento lancamento = new Lancamento();
                lancamento.setDataLancamento(LocalDate.parse(despesaLancamento.getDataLancamento(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                lancamento.setDescricaoLancamento(despesaLancamento.getDescricaoLancamento());
                lancamento.setValorLancamento(despesaLancamento.getValorLancamento());
                actual.get().getLancamentos().add(lancamento);
            } else {
                naturezaDespesas.add(new NaturezaDespesa(despesaLancamento));
            }
        });

        return naturezaDespesas;
    }
}
