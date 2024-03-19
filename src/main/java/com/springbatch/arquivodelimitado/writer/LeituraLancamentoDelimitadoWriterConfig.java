package com.springbatch.arquivodelimitado.writer;

import com.springbatch.arquivodelimitado.dominio.Cliente;
import com.springbatch.arquivodelimitado.dominio.DespesaLancamento;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraLancamentoDelimitadoWriterConfig {
	@Bean
	public ItemWriter<DespesaLancamento> leituraLancamentoDelimitadoWriter() {
		return items -> items.forEach(System.out::println);
	}
}
