package com.springbatch.arquivodelimitado.reader;

import com.springbatch.arquivodelimitado.dominio.DespesaLancamento;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Configuration
public class JdbcLancamentosReaderConfig {

    @Bean
    public JdbcCursorItemReader<DespesaLancamento> jdbcLancamentosReader(
            @Qualifier("xptoDataSource") DataSource dataSource
    ) {
        return new JdbcCursorItemReaderBuilder<DespesaLancamento>()
                .name("jdbcLancamentosReader")
                .dataSource(dataSource)
                .sql("select * from lancamento")
                .rowMapper(new BeanPropertyRowMapper<>(DespesaLancamento.class))
                .build();
    }

}
