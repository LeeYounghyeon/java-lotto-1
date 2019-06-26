package lotto.dao.Impl;

import lotto.dao.JDBCTemplate;
import lotto.dao.WinningLottoDao;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WinningLottoDaoImpl implements WinningLottoDao {
    private static WinningLottoDaoImpl winningLottoDaoImpl;

    public static WinningLottoDaoImpl getInstance() {
        if (Objects.isNull(winningLottoDaoImpl)) {
            winningLottoDaoImpl = new WinningLottoDaoImpl();
        }
        return winningLottoDaoImpl;
    }

    public void addWinningLotto(WinningLotto winningLotto, int lottoRound) {
        String query = "INSERT INTO winningLotto VALUES (?,?,?)";
        JDBCTemplate jdbcTemplate = JDBCTemplate.getInstance();

        List<Object> queryValues = new ArrayList<>();

        queryValues.add(lottoRound);
        queryValues.add(winningLotto.toString());
        queryValues.add(winningLotto.getBonus());
        jdbcTemplate.executeUpdate(query, queryValues);
    }

    public String offerWinningNumber(int lottoRound) {
        String query = "SELECT winningLottoNumber FROM winningLotto WHERE round = ?";

        List<Object> queryValues = new ArrayList<>();
        queryValues.add(lottoRound);

        JDBCTemplate jdbcTemplate = JDBCTemplate.getInstance();
        List<Map<String, Object>> results = jdbcTemplate.executeQuery(query, queryValues);

        if (results.size() == 0) {
            throw new IllegalArgumentException();
        }

        Map<String, Object> result = results.get(0);
        return (String) result.get("winningLottoNumber");
    }

    public int offerBonusNumber(int lottoRound) {
        String query = "SELECT bonus FROM winningLotto WHERE round = ?";

        List<Object> queryValues = new ArrayList<>();
        queryValues.add(lottoRound);

        JDBCTemplate jdbcTemplate = JDBCTemplate.getInstance();
        List<Map<String, Object>> results = jdbcTemplate.executeQuery(query, queryValues);

        if (results.size() == 0) {
            throw new IllegalArgumentException();
        }

        Map<String, Object> result = results.get(0);
        return (int) result.get("bonus");
    }

}
