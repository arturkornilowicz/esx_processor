package org.mizar.esx.design;

import org.mizar.esx.article.EsxElement;

public interface EsxElementProcessingStrategy {

    void before(EsxElement element);

    void after(EsxElement element);
}
