package jmu.zx.service;

import jmu.zx.pojo.Revert;

import java.util.List;

public interface RevertService {
    void add(Revert revert);

    void deleteByRevertId(Integer revertId);

    void update(Revert revert);

    List<Revert> searchByMessageId(Integer messageId);
}
