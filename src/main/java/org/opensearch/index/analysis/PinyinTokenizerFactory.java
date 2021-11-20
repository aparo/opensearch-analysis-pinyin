package org.opensearch.index.analysis;

import org.apache.lucene.analysis.Tokenizer;
import org.opensearch.analysis.PinyinConfig;
import org.opensearch.common.settings.Settings;
import org.opensearch.env.Environment;
import org.opensearch.index.IndexSettings;

public class PinyinTokenizerFactory extends AbstractTokenizerFactory {

    private PinyinConfig config;

    public PinyinTokenizerFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, settings, name);
        config=new PinyinConfig(settings);
    }

    @Override
    public Tokenizer create() {
            return new PinyinTokenizer(config);
    }
}

