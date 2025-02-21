package jmu.zx.service.impl;

import jmu.zx.mapper.RevertMapper;
import jmu.zx.pojo.Revert;
import jmu.zx.service.RevertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevertServiceImpl implements RevertService {

    @Autowired
    RevertMapper revertMapper;

    @Override
    public void add(Revert revert) {
        revertMapper.add(revert);
    }

    @Override
    public void deleteByRevertId(Integer revertId) {
        revertMapper.deleteByRevertId(revertId);
    }

    @Override
    public void update(Revert revert) {
        revertMapper.updateRevert(revert);
    }

    @Override
    public List<Revert> searchByMessageId(Integer messageId) {
        List<Revert> list = revertMapper.searchByMessageId(messageId);
        return list;
    }
}
