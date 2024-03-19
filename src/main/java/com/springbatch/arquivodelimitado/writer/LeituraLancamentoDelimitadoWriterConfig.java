package com.springbatch.arquivodelimitado.writer;

import com.springbatch.arquivodelimitado.dominio.*;
import com.springbatch.arquivodelimitado.repository.NaturezaDespesaRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LeituraLancamentoDelimitadoWriterConfig {
	@Bean
	public ItemWriter<DespesaLancamento> leituraLancamentoDelimitadoWriter() {
		return items -> NaturezaDespesaRepository.getAllNaturezaDespesa((List<DespesaLancamento>) items).forEach(item -> {
			System.out.println("---- Demonstrativo orçamentário ----");
			System.out.println(item);
		});
	}
}
