package edu.iis.mto.testreactor.coffee;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import edu.iis.mto.testreactor.coffee.milkprovider.MilkProvider;

class CoffeeMachineTest {

    @Mock
    private Grinder grinder;

    @Mock
    private MilkProvider milkProvider;

    @Mock
    private CoffeeReceipes receipes;

    private CoffeeMachine coffeeMachine;

    @BeforeEach
    void setUp() {
        coffeeMachine = new CoffeeMachine(grinder, milkProvider, receipes);
    }

    @Test
    public void itCompiles() {
        assertThat(true, Matchers.equalTo(true));
    }

}
