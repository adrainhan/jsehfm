package org.hf.jsem.serviceImp;

import org.hf.jsem.dao.AmMenuMapper;
import org.hf.jsem.entity.AmMenu;
import org.hf.jsem.entity.AmMenuExample;
import org.hf.jsem.serviceI.AmMenuServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by adramer on 2016/10/31.
 */
@Service
public class AmMenuService implements AmMenuServiceI {

    private AmMenuMapper mapper;

    @Autowired
    public void setMapper(AmMenuMapper mapper) {
        this.mapper = mapper;
    }


    public List<AmMenu> getAll() {
        return  this.mapper.selectByExample(new AmMenuExample());
    }
}
