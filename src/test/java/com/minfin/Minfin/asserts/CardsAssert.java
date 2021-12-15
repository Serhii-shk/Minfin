package com.minfin.Minfin.asserts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CardsAssert {

    public CardsAssert isCollectionSorted(List<Integer> list) {
        List<Integer> copy = new ArrayList<>(list);
        Collections.sort(copy);
        step("check Collection sorted ", ()->
                assertThat(copy.equals(list))
                        .as("Expected that list " + copy + " are sorted")
                        .isTrue());
        return this;
    }

    public CardsAssert checkCountCardsWithFastFilter(int countExpected, int countActual) {
        step("check Count Cards ", ()->
                assertThat(countActual)
                        .as("Expected ui cards count " + countExpected + " But found " + countActual)
                        .isEqualTo(countExpected));
        return this;
    }
}
