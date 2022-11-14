package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.LottoUtils;

public class User {

    private List<Lotto> lottos;
    private static List<LottoGrade> lottoGrades;
    private double profit;

    public void buyLottos(int lottoAmount){
        lottos = new ArrayList<>();

        while (lottos.size()<lottoAmount){
            List<Integer> numbers = LottoUtils.pickUniqueNumbersInRange();
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public void getLottoResults(WinningLotto winningLotto){
        lottoGrades = new ArrayList<>();

        for(Lotto lotto : lottos){
            LottoGrade lottoGrade = winningLotto.getLottoGrade(lotto);
            if(lottoGrade != null){
                lottoGrades.add(lottoGrade);
            }
        }
    }

    public static int getLottoGradeNumber(LottoGrade lottoGrade) {
        return (int) lottoGrades.stream().filter(grade -> lottoGrade.equals(grade)).count();
    }

    public String getLottoProfit(String inputPayment) {
        double payment = Double.parseDouble(inputPayment);
        for(LottoGrade lottoGrade :lottoGrades){
            profit += lottoGrade.getPrize();
        }
        return String.format("%.1f",profit/payment*100);
    }
}
