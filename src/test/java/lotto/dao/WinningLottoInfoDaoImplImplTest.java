package lotto.dao;

import lotto.dao.Impl.WinningLottoDaoImpl;
import lotto.domain.Lotto;
import lotto.domain.Number;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class WinningLottoInfoDaoImplImplTest {
    private List<Number> lottoNumbers = new ArrayList<>();
    private WinningLottoDaoImpl winningLottoDaoImpl = WinningLottoDaoImpl.getInstance();

    @BeforeEach
    void setUp() {
        for (int i = 1; i <= 6; i++) {
            lottoNumbers.add(Number.of(i));
        }
    }

    @Test
    void addWinningLotto() {
        Lotto lotto = new Lotto(lottoNumbers);
        WinningLotto winningLotto = new WinningLotto(lotto, Number.of(9));
        winningLottoDaoImpl.addWinningLotto(winningLotto, 9);
    }

    @Test
    void offerWinningNumber() {
        System.out.println(winningLottoDaoImpl.offerWinningNumber(2));
    }

    @Test
    void offerBonusNumber() {
        System.out.println(winningLottoDaoImpl.offerBonusNumber(2));
    }
}