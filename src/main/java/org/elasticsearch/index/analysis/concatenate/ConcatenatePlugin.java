package org.elasticsearch.index.analysis.concatenate;

import org.elasticsearch.plugins.AbstractPlugin;

public class ConcatenatePlugin extends AbstractPlugin {
    @Override
    public String name() {
        return "ConcatenatePlugin";
    }

    @Override
    public String description() {
        return "Plugin that provides a Token Filter that recombines all of the tokens in a token stream back into one.";
    }
}
