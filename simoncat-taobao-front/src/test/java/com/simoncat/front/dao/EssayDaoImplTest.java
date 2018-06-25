package com.simoncat.front.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.simoncat.front.dto.EssayDto;

public class EssayDaoImplTest {

    private static final EssayDao dao = new EssayDaoImpl();

    @Test
    public void testLoadAll() {
        List<EssayDto> results = dao.loadAll(1);
        System.out.println(results.get(0).getEssayComments());
        assertTrue(results.size() > 0);
    }
}
