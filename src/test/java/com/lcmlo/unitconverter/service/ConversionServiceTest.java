package com.lcmlo.unitconverter.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConversionServiceTest {

    private final ConversionService conversionService = new ConversionService();

    @ParameterizedTest(name = "Convert {0} {1} to {2} should be {3}")
    @CsvSource({
            // Input,   FromUnit,   ToUnit,     Expected
            "1.0,       meter,      centimeter, 100.0",
            "1000.0,    millimeter, meter,      1.0",
            "1.0,       kilometer,  meter,      1000.0",
            "2.0,       inch,       centimeter, 5.08",
            "0.0,       meter,      mile,       0.0"
    })
    void shouldConvertLengthCorrectly(Double input, String fromUnit, String toUnit, Double expected) {
        Double actual = conversionService.convertLength(input, fromUnit, toUnit);
        assertEquals(expected, actual, 0.001,
                "Conversion from " + input + " " + fromUnit + " to " + toUnit + " failed.");
    }

    @ParameterizedTest(name = "Convert {0} {1} to {2} should be {3}")
    @CsvSource({
            // Input,   FromUnit,   ToUnit,     Expected
            "1000.0,    gram,       kilogram,   1.0",
            "1.0,       kilogram,   gram,       1000.0",
            "1000.0,    milligram,  gram,       1.0",
            "1.0,       pound,      ounce,      16.0",
            "0.0,       ounce,      pound,      0.0"
    })
    void shouldConvertWeightCorrectly(Double input, String fromUnit, String toUnit, Double expected) {
        Double actual = conversionService.convertWeight(input, fromUnit, toUnit);
        assertEquals(expected, actual, 0.001,
                "Conversion from " + input + " " + fromUnit + " to " + toUnit + " failed.");
    }

    @ParameterizedTest(name = "Convert {0} {1} to {2} should be {3}")
    @CsvSource({
            // Input,   FromUnit,   ToUnit,         Expected
            "0.0,       celsius,    fahrenheit,     32.0",
            "100.0,     celsius,    fahrenheit,     212.0",
            "-40.0,     celsius,    fahrenheit,     -40.0",
            "273.15,    kelvin,     celsius,        0.0"
    })
    void shouldConvertTemperatureCorrectly(Double input, String fromUnit, String toUnit, Double expected) {
        Double actual = conversionService.convertTemperature(input, fromUnit, toUnit);
        assertEquals(expected, actual, 0.001);
    }
}