package com.springbatch.arquivodelimitado.step;

import com.springbatch.arquivodelimitado.dominio.DespesaLancamento;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraLancamentosStepConfig {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step leituraLancamentosStep(ItemReader<DespesaLancamento> jdbcLancamentosReader,
                                       ItemWriter<DespesaLancamento> leituraLancamentoDelimitadoWriter) {
        return stepBuilderFactory
                .get("leituraLancamentosStep")
                .<DespesaLancamento, DespesaLancamento>chunk(1)
                .reader(jdbcLancamentosReader)
                .writer(leituraLancamentoDelimitadoWriter)
                .build();
    }
}

