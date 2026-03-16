package com.lcmlo.unitconverter.controller;

import com.lcmlo.unitconverter.model.ConversionRequest;
import com.lcmlo.unitconverter.service.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConverterController {

    private final ConversionService conversionService;

    public ConverterController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @GetMapping("/")
    public String showLengthConverter(Model model) {
        model.addAttribute("request", new ConversionRequest());
        model.addAttribute("activeTab", "length");
        return "index";
    }

    @PostMapping("/convert-length")
    public String processLengthConversion(@ModelAttribute("request") ConversionRequest request, Model model) {
        Double result = conversionService.convertLength(
                request.getValue(),
                request.getFromUnit(),
                request.getToUnit()
        );

        request.setResult(result);

        model.addAttribute("request", request);
        model.addAttribute("activeTab", "length");
        return "index";
    }

    @GetMapping("/weight")
    public String showWeightConverter(Model model) {
        model.addAttribute("request", new ConversionRequest());
        model.addAttribute("activeTab", "weight");
        return "index";
    }

    @PostMapping("/convert-weight")
    public String processWeightConversion(@ModelAttribute("request") ConversionRequest request, Model model) {
        Double result = conversionService.convertWeight(
                request.getValue(),
                request.getFromUnit(),
                request.getToUnit()
        );

        request.setResult(result);

        model.addAttribute("request", request);
        model.addAttribute("activeTab", "weight");
        return "index";
    }

    @GetMapping("/temperature")
    public String showTemperatureConverter(Model model) {
        model.addAttribute("request", new ConversionRequest());
        model.addAttribute("activeTab", "temperature");
        return "index";
    }

    @PostMapping("/convert-temperature")
    public String processTemperatureConversion(@ModelAttribute("request") ConversionRequest request, Model model) {
        Double result = conversionService.convertTemperature(
                request.getValue(),
                request.getFromUnit(),
                request.getToUnit()
        );

        request.setResult(result);

        model.addAttribute("request", request);
        model.addAttribute("activeTab", "temperature");
        return "index";
    }
}