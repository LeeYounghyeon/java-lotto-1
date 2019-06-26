package lotto.dao.Impl;

import lotto.dao.JDBCTemplate;
import lotto.dao.LottoStatusDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoStatusDaoImpl implements LottoStatusDao {
    private static LottoStatusDaoImpl lottoStatusDaoImpl;

    public static LottoStatusDaoImpl getInstance() {
        if (Objects.isNull(lottoStatusDaoImpl)) {
            lottoStatusDaoImpl = new LottoStatusDaoImpl();
        }
        return lottoStatusDaoImpl;
    }

    public void addResultInfo(int lottoRound, double sum, String returnRate) {
        String query = "INSERT INTO resultInfo VALUES(?,?,?)";
        JDBCTemplate jdbcTemplate = JDBCTemplate.getInstance();

        List<Object> queryValues = new ArrayList<>();

        queryValues.add(lottoRound);
        queryValues.add((int) sum);
        queryValues.add(returnRate);

        jdbcTemplate.executeUpdate(query, queryValues);
    }

    public int offerPrize(int lottoRound) {
        String query = "SELECT prize FROM resultInfo WHERE round = ?";

        List<Object> queryValues = new ArrayList<>();
        queryValues.add(lottoRound);

        JDBCTemplate jdbcTemplate = JDBCTemplate.getInstance();
        List<Map<String, Object>> results = jdbcTemplate.executeQuery(query, queryValues);

        if (results.size() == 0) {
            throw new IllegalArgumentException();
        }

        Map<String, Object> result = results.get(0);
        return (int) result.get("prize");
    }

    public double offerReturnRate(int lottoRound) {
        String query = "SELECT returnRate FROM resultInfo WHERE round = ?";
        List<Object> queryValues = new ArrayList<>();
        queryValues.add(lottoRound);

        JDBCTemplate jdbcTemplate = JDBCTemplate.getInstance();
        List<Map<String, Object>> results = jdbcTemplate.executeQuery(query, queryValues);

        if (results.size() == 0) {
            throw new IllegalArgumentException();
        }

        Map<String, Object> result = results.get(0);
        return (double) result.get("returnRate");
    }
}
