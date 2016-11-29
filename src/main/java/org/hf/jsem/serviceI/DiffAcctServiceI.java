package org.hf.jsem.serviceI;

import org.hf.jsem.entity.SscfDiffAccounts;

import java.util.List;

/**
 * Created by adramer on 2016/11/4.
 */
public interface DiffAcctServiceI {

    void save(SscfDiffAccounts diffAccounts);

    void saveBatch(List<SscfDiffAccounts> diffAccountses);

}
