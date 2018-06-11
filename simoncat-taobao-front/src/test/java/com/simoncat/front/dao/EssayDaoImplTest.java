package com.simoncat.front.dao;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;

import com.simoncat.front.vo.EssayListVo;

public class EssayDaoImplTest {

    private static final EssayDao dao = new EssayDaoImpl();

    @Test
    public void testLoadAll() {
        Optional<EssayListVo> results = dao.loadAll(1);
        assertTrue(results.isPresent());
    }
}
