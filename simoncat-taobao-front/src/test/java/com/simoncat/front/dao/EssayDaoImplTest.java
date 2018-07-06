package com.simoncat.front.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.simoncat.front.dto.EssayDto;
import com.simoncat.front.utils.HibernateUtil;

public class EssayDaoImplTest {

    private static final EssayDao dao = new EssayDaoImpl();

    @Test
    public void testLoadAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<EssayDto> results = dao.loadAllByCreation(session, 1);
            System.out.println(results.get(0).getEssayComments());
            assertTrue(results.size() > 0);
        }
    }
}
