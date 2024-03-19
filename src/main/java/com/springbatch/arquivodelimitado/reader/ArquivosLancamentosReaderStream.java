package com.springbatch.arquivodelimitado.reader;

import com.springbatch.arquivodelimitado.dominio.DespesaLancamento;
import org.springframework.batch.item.*;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.core.io.Resource;

public class ArquivosLancamentosReaderStream implements ItemStreamReader<DespesaLancamento>, ResourceAwareItemReaderItemStream<DespesaLancamento> {

    private final FlatFileItemReader<DespesaLancamento> delegate;

    public ArquivosLancamentosReaderStream(FlatFileItemReader<DespesaLancamento> delegate) {
        this.delegate = delegate;
    }

    @Override
    public void setResource(Resource resource) {
        delegate.setResource(resource);
    }

    @Override
    public DespesaLancamento read() throws Exception {
        return delegate.read();
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        delegate.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        delegate.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        delegate.close();
    }
}
