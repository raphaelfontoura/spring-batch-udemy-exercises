package com.springbatch.arquivodelimitado.reader;

import com.springbatch.arquivodelimitado.dominio.DespesaLancamento;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Configuration
public class JdbcPagingLancamentosReaderConfig {

    @Bean
    public JdbcPagingItemReader<DespesaLancamento> jdbcPagingLancamentosReader(
            @Qualifier("xptoDataSource") DataSource dataSource,
            PagingQueryProvider queryProvider
    ) {
        return new JdbcPagingItemReaderBuilder<DespesaLancamento>()
                .name("jdbcLancamentosReader")
                .dataSource(dataSource)
                .queryProvider(queryProvider)
                .pageSize(2)
                .rowMapper(new BeanPropertyRowMapper<>(DespesaLancamento.class))
                .build();
    }

    @Bean
    public SqlPagingQueryProviderFactoryBean queryProvider(
            @Qualifier("xptoDataSource") DataSource dataSource
    ) {
        SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();
        queryProvider.setDataSource(dataSource);
        queryProvider.setSelectClause("select *");
        queryProvider.setFromClause("from lancamento");
        queryProvider.setSortKey("codigoNaturezaDespesa");

        return queryProvider;
    }
}
