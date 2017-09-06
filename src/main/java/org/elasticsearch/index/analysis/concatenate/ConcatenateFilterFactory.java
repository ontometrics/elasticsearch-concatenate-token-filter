package org.elasticsearch.index.analysis.concatenate;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.util.Version;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;

import static org.elasticsearch.index.analysis.concatenate.ConcatenateFilter.DEFAULT_INCREMENT_GAP;

public class ConcatenateFilterFactory extends AbstractTokenFilterFactory {
    private Settings settings;
    public ConcatenateFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
        super(indexSettings, name, settings);
        this.settings = settings;
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new ConcatenateFilter(Version.LUCENE_6_5_1, tokenStream, settings.get("tokenSeparator"),
                settings.getAsInt("incrementGap", DEFAULT_INCREMENT_GAP));
    }
}
