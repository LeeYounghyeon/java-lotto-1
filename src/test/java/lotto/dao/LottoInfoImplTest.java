package lotto.dao;

import lotto.dao.Impl.LottoInfoDaoImpl;
import lotto.domain.*;
import lotto.domain.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LottoInfoImplTest {
    private List<Lotto> lotto;
    private LottoInfoDaoImpl lottoInfoImpl = LottoInfoDaoImpl.getInstance();

    @BeforeEach
    void setUp() {
        List<Number> lottoNumbers = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            lottoNumbers.add(Number.of(i));
        }

        lotto = new ArrayList<>();
        lotto.add(new Lotto(lottoNumbers));
        lotto.add(new Lotto(lottoNumbers));
    }

    @Test
    void addLotto() {
        UserLotto userLotto = new UserLotto(lotto, 4, new LottoNumberGenerator());
        lottoInfoImpl.addLotto(userLotto, 1);
    }

    @Test
    void offerMaxRound() {
        System.out.println(lottoInfoImpl.offerMaxRound());
    }

    @Test
    void offerUserLottoNumber() {
        System.out.println(lottoInfoImpl.offerUserLottoNumber(1));
    }
}