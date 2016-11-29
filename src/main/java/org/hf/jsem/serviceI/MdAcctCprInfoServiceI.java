package org.hf.jsem.serviceI;

import org.hf.jsem.entity.*;

import java.sql.Date;
import java.util.List;

/**
 * Created by adramer on 2016/11/29.
 */
public interface MdAcctCprInfoServiceI {
    List<SscfLnmtCaafverDtl> getLnmtCaafverDtls(Date dataDate);

    List<SscfLnmtReadpyDtl> getLnmtReadpyDtls(Date dataDate);

    List<SscfLnmtDiffDeco> getLnmtDiffDeco(Date dataDate);

    List<SscfLnmtInsrepDtl> getLnmtInsrepDtl(Date dataDate);

    List<SscfLnmtLoanDtl> getLnmtLoanDtl(Date dataDate);

    List<SscfLnmtRepayDtl> getLnmtRepayDtl(Date dataDate);

}
