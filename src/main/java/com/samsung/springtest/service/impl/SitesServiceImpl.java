package com.samsung.springtest.service.impl;

import com.samsung.springtest.repository.SitesRepository;
import com.samsung.springtest.domain.Sites;
import com.samsung.springtest.service.SitesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SitesServiceImpl implements SitesService {

    private final SitesRepository sitesDao;

    @Override
    public Sites add(Sites sites) {
        return sitesDao.save(sites);
    }

    @Override
    public List<Sites> getAll() {
        return sitesDao.findAll();
    }

    @Override
    public Sites getById(long id) {
        return sitesDao.findById(id).orElse(null);
    }

    @Override
    public Sites update(Sites sites) {
        return sitesDao.save(sites);
    }

    @Override
    public void deleteById(long id) {
        sitesDao.deleteById(id);
    }
}
