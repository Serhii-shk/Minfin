package com.minfin.Minfin.asserts;

import com.minfin.Minfin.pageobjects.CreditCardsPO;

import java.util.ArrayList;

public class CreditCardsAssert {

    public CreditCardsAssert checkIfListIsSortedByLoanLimit() {
        int vendorCardsCount = new CreditCardsPO().getVendorCardsCount();
        for (int i = 0; i <= vendorCardsCount - 1; i++) {
            String cardByLoanLimit = new CreditCardsPO().getListCardByLoanLimit().get(i).text().replaceAll("[^0-9]", "");
            ArrayList<Integer> newListForCheckSorting = new ArrayList<>();
            if(cardByLoanLimit.length()==0) {
                cardByLoanLimit = String.valueOf(0);
            }
            newListForCheckSorting.add(Integer.parseInt(cardByLoanLimit));
            new CardsAssert().isCollectionSorted(newListForCheckSorting);
        }
        return this;
    }

    public CreditCardsAssert checkIfListIsSortedByGracePeriod() {
        int vendorCardsCount = new CreditCardsPO().getVendorCardsCount();
        for (int i = 0; i <= vendorCardsCount - 1; i++) {
            String cardByGracePeriod = new CreditCardsPO().getListCardByGracePeriod().get(i).text().replaceAll("[^0-9]", "");
            ArrayList<Integer> newListForCheckSorting = new ArrayList<>();
            if(cardByGracePeriod.length()==0) {
                cardByGracePeriod = String.valueOf(0);
            }
            newListForCheckSorting.add(Integer.parseInt(cardByGracePeriod));
            new CardsAssert().isCollectionSorted(newListForCheckSorting);
        }
        return this;
    }
}
