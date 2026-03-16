package com.lcmlo.unitconverter.service;

import org.springframework.stereotype.Service;

@Service
public class ConversionService {

    private Boolean isValid(Double value, String fromUnit, String toUnit) {
        return value != null && fromUnit != null && toUnit != null;
    }

    public Double convertLength(Double value, String fromUnit, String toUnit) {
        if (isValid(value, fromUnit, toUnit)){
            if(value<0) return 0.0;
            if (fromUnit.equals(toUnit)) return value;

            double fromFactor = getLengthFactor(fromUnit);
            double toFactor = getLengthFactor(toUnit);

            return value * (fromFactor / toFactor);
        }
        return 0.0;
    }

    //To simplify I use meter as the base for the calculations
    private double getLengthFactor(String unit) {
        return switch (unit.toLowerCase()) {
            case "meter" -> 1.0;
            case "millimeter" -> 0.001;
            case "centimeter" -> 0.01;
            case "kilometer" -> 1000.0;
            case "inch" -> 0.0254;
            case "yard" -> 0.9144;
            case "ft" -> 0.3048;
            case "mile" -> 1609.344;
            default -> throw new IllegalArgumentException("Unknown length unit: " + unit);
        };
    }

    public Double convertWeight(Double value, String fromUnit, String toUnit) {
        if(value<0) return 0.0;
        if (isValid(value, fromUnit, toUnit)){
            if (fromUnit.equals(toUnit)) return value;

            double fromFactor = getWeightFactor(fromUnit);
            double toFactor = getWeightFactor(toUnit);

            return value * (fromFactor / toFactor);
        }
        return 0.0;
    }

    private double getWeightFactor(String unit) {
        return switch (unit.toLowerCase()) {
            case "gram" -> 1.0;
            case "milligram" -> 0.001;
            case "kilogram" -> 1000.0;
            case "ounce" -> 28.3495;
            case "pound" -> 453.592;
            default -> throw new IllegalArgumentException("Unknown weight unit: " + unit);
        };
    }

    public Double convertTemperature(Double value, String fromUnit, String toUnit) {
        if (isValid(value, fromUnit, toUnit)){
            if (fromUnit.equals(toUnit)) return value;

            switch (fromUnit.toLowerCase()) {
                case "fahrenheit" -> value = farenheitToCelsius(value);
                case "kelvin" -> value = kelvinToCelsius(value);
            }

            switch (toUnit.toLowerCase()) {
                case "fahrenheit" -> value = celsiusToFarenheit(value);
                case "kelvin" -> value = celsiusToKelvin(value);
            }
            return value;
        }
        return 0.0;
    }

    private Double celsiusToFarenheit(Double value) {
        return value * 1.8 + 32;
    }

    private Double farenheitToCelsius(Double value) {
        return (value - 32) * (5.0/9.0);
    }

    private Double celsiusToKelvin(Double value) {
        return value + 273.15;
    }

    private Double kelvinToCelsius(Double value) {
        return value - 273.15;
    }
}