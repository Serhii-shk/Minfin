package com.minfin.Minfin.asserts;

import com.minfin.Minfin.pageobjects.DebitCardsPO;

import java.util.ArrayList;

public class DebitCardsAssert {

    public DebitCardsAssert checkIfListIsSortedByMaintenanceFirstYearPrice() {
        int vendorCardsCount = new DebitCardsPO().getVendorCardsCount();
        for (int i = 0; i <= vendorCardsCount - 1; i++) {
            String cardByMaintenanceFirstYearPrice = new DebitCardsPO().getListCardByMaintenanceFirstYearPrice().get(i).text().replaceAll("[^0-9]", "");
            ArrayList<Integer> newListForCheckSorting = new ArrayList<>();
            if (cardByMaintenanceFirstYearPrice.length() == 0) {
                cardByMaintenanceFirstYearPrice = String.valueOf(0);
            }
            newListForCheckSorting.add(Integer.parseInt(cardByMaintenanceFirstYearPrice));
            new CardsAssert().isCollectionSorted(newListForCheckSorting);
        }
        return this;
    }

    public DebitCardsAssert checkIfListIsSortedByPercentOnBalance() {
        int vendorCardsCount = new DebitCardsPO().getVendorCardsCount();
        for (int i = 0; i <= vendorCardsCount - 1; i++) {
            String cardByPercentOnBalance = new DebitCardsPO().getListCardByPercentOnBalance().get(i).text().replaceAll("[^0-9]", "");
            ArrayList<Integer> newListForCheckSorting = new ArrayList<>();
            if (cardByPercentOnBalance.length() == 0) {
                cardByPercentOnBalance = String.valueOf(0);
            }
            newListForCheckSorting.add(Integer.parseInt(cardByPercentOnBalance));
            new CardsAssert().isCollectionSorted(newListForCheckSorting);
        }
        return this;
    }
}
