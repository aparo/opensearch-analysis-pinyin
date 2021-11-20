package org.opensearch.index.analysis;


import org.apache.lucene.analysis.TokenStream;
import org.opensearch.analysis.PinyinConfig;
import org.opensearch.common.settings.Settings;
import org.opensearch.env.Environment;
import org.opensearch.index.IndexSettings;

public class PinyinTokenFilterFactory extends AbstractTokenFilterFactory {
    private PinyinConfig config;


    public PinyinTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
        super(indexSettings, name, settings);
       config=new PinyinConfig(settings);
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new PinyinTokenFilter(tokenStream, config);
    }
}
