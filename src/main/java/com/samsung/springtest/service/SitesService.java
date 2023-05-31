package com.samsung.springtest.service;

import com.samsung.springtest.domain.Sites;

import java.util.List;

public interface SitesService {
    Sites add(Sites sites);
    List<Sites> getAll();
    Sites getById(long id);
    Sites update(Sites sites);
    void deleteById(long id);
}
