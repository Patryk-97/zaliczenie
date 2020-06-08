package edu.iis.mto.testreactor.coffee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import edu.iis.mto.testreactor.coffee.milkprovider.MilkProvider;

@ExtendWith(MockitoExtension.class)
class CoffeeMachineTest {

    @Mock
    private Grinder grinder;

    @Mock
    private MilkProvider milkProvider;

    @Mock
    private CoffeeReceipes receipes;

    @Mock
    private CoffeeReceipe receipe;

    private CoffeeMachine coffeeMachine;
    private CoffeeSize unrelevantCoffeeSize = CoffeeSize.SMALL;
    private CoffeType unrelevantCoffeeType = CoffeType.CAPUCCINO;

    @BeforeEach
    void setUp() {
        coffeeMachine = new CoffeeMachine(grinder, milkProvider, receipes);
        unrelevantCoffeeSize = CoffeeSize.SMALL;
        unrelevantCoffeeType = CoffeType.CAPUCCINO;
        Mockito.when(grinder.canGrindFor(unrelevantCoffeeSize))
               .thenReturn(true);
        Mockito.when(receipes.getReceipe(unrelevantCoffeeType))
               .thenReturn(receipe);
    }

    @Test
    public void ShouldCallGrinderAndMilkProviderandCoffeeMachine() {
        CoffeeSize unrelevantCoffeeSize = CoffeeSize.SMALL;
        CoffeType unrelevantCoffeeType = CoffeType.CAPUCCINO;
        CoffeOrder coffeeOrder = coffeeOrder(unrelevantCoffeeSize, unrelevantCoffeeType);
        Coffee coffee = coffeeMachine.make(coffeeOrder);
    }

    private CoffeOrder coffeeOrder(CoffeeSize unrelevantCoffeeSize, CoffeType unrelevantCoffeeType) {
        return CoffeOrder.builder()
                         .withSize(unrelevantCoffeeSize)
                         .withType(unrelevantCoffeeType)
                         .build();
    }

}
