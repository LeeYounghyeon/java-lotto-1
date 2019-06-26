package lotto.dao;

import lotto.dao.Impl.LottoStatusDaoImpl;
import org.junit.jupiter.api.Test;

public class LottoStatusDaoImplTest {
    private LottoStatusDaoImpl lottoStatusDaoImpl = LottoStatusDaoImpl.getInstance();

    @Test
    void addResultInfo() {
        lottoStatusDaoImpl.addResultInfo(4, 2.0, "300000");
    }

    @Test
    void offerPrize() {
        System.out.println(lottoStatusDaoImpl.offerPrize(1));
    }

    @Test
    void offerReturnRate() {
        System.out.println(lottoStatusDaoImpl.offerReturnRate(1));
    }
}
