package com.springbatch.arquivodelimitado.reader;

import com.springbatch.arquivodelimitado.dominio.Cliente;
import com.springbatch.arquivodelimitado.dominio.DespesaLancamento;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.Resource;

@Configuration
public class LeituraLancamentoDelimitadoReaderConfig {

	@StepScope
	@Bean
	public FlatFileItemReader<DespesaLancamento> leituraLancamentoDelimitadoReader(
			@Value("#{jobParameters['lancamentos']}")Resource lancamentos
	) {
		return new FlatFileItemReaderBuilder<DespesaLancamento>()
				.name("leituraLancamentoDelimitadoReader")
				.resource(lancamentos)
				.delimited()
				.names("codigoNaturezaDespesa",
						"descricaoNaturezaDespesa",
						"descricaoLancamento",
						"dataLancamento",
						"valorLancamento")
				.fieldSetMapper(new BeanWrapperFieldSetMapper<>())
				.targetType(DespesaLancamento.class)
				.build();
    }
}
