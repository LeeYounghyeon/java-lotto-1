package lotto.dto;

import lotto.domain.Lotto;

import java.util.List;

public class LottoDto {
    private final int round;
    private final int manualRound;
    private final int autoRound;
    private final List<Lotto> userLotto;
    private final String[] numbers;
    private final int lottoRound;

    public LottoDto(int round, int manualRound, int autoRound, List<Lotto> userLotto, String[] numbers, int lottoRound) {
        this.round = round;
        this.manualRound = manualRound;
        this.autoRound = autoRound;
        this.userLotto = userLotto;
        this.numbers = numbers;
        this.lottoRound = lottoRound;
    }

    public int getRound() {
        return round;
    }

    public int getManualRound() {
        return manualRound;
    }

    public int getAutoRound() {
        return autoRound;
    }

    public List<Lotto> getUserLotto() {
        return userLotto;
    }

    public String[] getNumbers() {
        return numbers;
    }

    public int getLottoRound() {
        return lottoRound;
    }
}
