package com.springbatch.arquivodelimitado.reader;

import com.springbatch.arquivodelimitado.dominio.DespesaLancamento;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class LeituraMultiplosArquivosLancamentoConfig {

    @Bean
    @StepScope
    public MultiResourceItemReader leituraMultiplosArquivosLancamento(
            @Value("#{jobParameters['arquivosLancamentos']}") Resource[] arquivosLancamentos,
            FlatFileItemReader<DespesaLancamento> leituraLancamentoDelimitadoReader
    ) {
        return new MultiResourceItemReaderBuilder<DespesaLancamento>()
                .name("leituraMultiplosArquivosLancamento")
                .resources(arquivosLancamentos)
                .delegate(new ArquivosLancamentosReaderStream(leituraLancamentoDelimitadoReader))
                .build();
    }
}
