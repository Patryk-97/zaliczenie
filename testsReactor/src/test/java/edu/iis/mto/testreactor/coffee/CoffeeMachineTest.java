package edu.iis.mto.testreactor.coffee;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import edu.iis.mto.testreactor.coffee.milkprovider.MilkProvider;
import edu.iis.mto.testreactor.coffee.milkprovider.MilkProviderException;

@ExtendWith(MockitoExtension.class)
class CoffeeMachineTest {

    @Mock
    private Grinder grinder;

    @Mock
    private MilkProvider milkProvider;

    @Mock
    private CoffeeReceipes receipes;

    private CoffeeMachine coffeeMachine;
    private CoffeeSize unrelevantCoffeeSize = CoffeeSize.SMALL;
    private CoffeeType unrelevantCoffeeType = CoffeeType.CAPUCCINO;

    @BeforeEach
    void setUp() {
        coffeeMachine = new CoffeeMachine(grinder, milkProvider, receipes);
        unrelevantCoffeeSize = CoffeeSize.SMALL;
        unrelevantCoffeeType = CoffeeType.CAPUCCINO;
        Mockito.when(grinder.canGrindFor(unrelevantCoffeeSize))
               .thenReturn(true);
        Map<CoffeeSize, Integer> waterAmounts = new HashMap<>();
        waterAmounts.put(unrelevantCoffeeSize, Integer.valueOf(2));
        CoffeeReceipe coffeeReceipe = CoffeeReceipe.builder()
                                                   .withMilkAmount(2)
                                                   .withWaterAmounts(waterAmounts)
                                                   .build();
        Mockito.when(receipes.getReceipe(unrelevantCoffeeType))
               .thenReturn(coffeeReceipe);
    }

    @Test
    public void makeMethodTestCoffeeShouldBeNotNull() {
        CoffeeOrder coffeeOrder = coffeeOrder(unrelevantCoffeeSize, unrelevantCoffeeType);
        Coffee coffee = coffeeMachine.make(coffeeOrder);
        assertNotNull(coffee);
    }

    @Test
    void makeFunctionTestShouldCallGrinderAndMilkProviderAndCofeeReceipes() throws MilkProviderException {
        CoffeeOrder coffeeOrder = coffeeOrder(unrelevantCoffeeSize, unrelevantCoffeeType);
        coffeeMachine.make(coffeeOrder);

        Mockito.verify(grinder)
               .canGrindFor(unrelevantCoffeeSize);
        Mockito.verify(milkProvider)
               .heat();
    }

    private CoffeeOrder coffeeOrder(CoffeeSize unrelevantCoffeeSize, CoffeeType unrelevantCoffeeType) {
        return CoffeeOrder.builder()
                          .withSize(unrelevantCoffeeSize)
                          .withType(unrelevantCoffeeType)
                          .build();
    }

}
