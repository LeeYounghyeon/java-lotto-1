package lotto.controller;

import lotto.dto.RoundInfoDto;
import lotto.service.LottoService;
import spark.Request;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static spark.Spark.get;
import static spark.Spark.post;

public class LottoController implements Controller {
    private static LottoController lottoController;
    private LottoService lottoService = LottoService.getInstance();

    private LottoController() {
    }

    public static LottoController getInstance() {
        if (Objects.isNull(lottoController)) {
            return new LottoController();
        }

        return lottoController;
    }

    public void init() {
        get("/", (req, res) -> lottoController.mainPage());

        post("/lotto", (req, res) -> lottoController.lottoPage(req));

        post("/winLotto", (req, res) -> lottoController.winningPage(req));

        get("/result", (req, res) -> lottoController.resultPage(req));

        get("/hits", (req, res) -> lottoController.hitsPage(req));

        post("/lottoHits", (req, res) -> lottoController.lottoHitsPage(req));
    }

    public String mainPage() {
        return render(lottoService.offerLottoRounds(), "main.html");
    }

    public String lottoPage(Request req) {
        int money = Integer.parseInt(req.queryParams("money"));
        int manualRound = Integer.parseInt(req.queryParams("manualRound"));
        String manualNumbers = req.queryParams("manualNumbers");
        int lottoRound = Integer.parseInt(req.queryParams("lottoRound"));

        return render(lottoService.offerLottoInfo(money, manualRound, manualNumbers, lottoRound), "lotto.html");
    }

    public String winningPage(Request req) {
        int round = Integer.parseInt(req.queryParams("round"));
        String userLottoString = req.queryParams("userLotto");
        int lottoRound = Integer.parseInt(req.queryParams("lottoRound"));

        return render(lottoService.offerUserLottoInfo(round, userLottoString, lottoRound), "winNumber.html");
    }

    public String resultPage(Request req) {
        String winNumbers = req.queryParams("winNumbers");
        String bonusNumber = req.queryParams("bonusNumber");
        int round = Integer.parseInt(req.queryParams("round"));
        String userLottoString = req.queryParams("userLotto");
        int lottoRound = Integer.parseInt(req.queryParams("lottoRound"));
        RoundInfoDto roundInfoDto = new RoundInfoDto(winNumbers, bonusNumber, userLottoString, round, lottoRound);
        return render(lottoService.offerResults(roundInfoDto), "result.html");
    }

    public String hitsPage(Request req) {
        Map<String, Object> model = new HashMap<>();
        return render(model, "hits.html");
    }

    public String lottoHitsPage(Request req) {
        int lottoRound = Integer.parseInt(req.queryParams("hitsRound"));
        return render(lottoService.offerHitsStatus(lottoRound), "hitsResult.html");
    }
}
