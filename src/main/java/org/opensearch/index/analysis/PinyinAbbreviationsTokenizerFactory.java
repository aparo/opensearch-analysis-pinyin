package org.opensearch.index.analysis;

import org.apache.lucene.analysis.Tokenizer;
import org.opensearch.analysis.PinyinConfig;
import org.opensearch.common.settings.Settings;
import org.opensearch.env.Environment;
import org.opensearch.index.IndexSettings;

public class PinyinAbbreviationsTokenizerFactory extends AbstractTokenizerFactory {

    public PinyinAbbreviationsTokenizerFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, settings, name);
    }

    @Override
    public Tokenizer create() {
        PinyinConfig config=new PinyinConfig();
        config.keepFirstLetter=true;
        config.keepFullPinyin=false;
        config.keepNoneChinese=false;
        config.keepNoneChineseTogether=true;
        config.noneChinesePinyinTokenize=false;
        config.keepOriginal=false;
        config.lowercase=true;
        config.trimWhitespace=true;
        config.keepNoneChineseInFirstLetter=true;
        return new PinyinTokenizer(config);
    }
}
