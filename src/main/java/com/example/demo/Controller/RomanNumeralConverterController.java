package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.RomanNumeralConverterDTO;
import com.example.demo.Service.RomanNumeralConverterService;

@RestController
@RequestMapping(value = "/romanConverter/")
public class RomanNumeralConverterController {
	
	@Autowired
	private RomanNumeralConverterService numeralConverterService;
	
	@GetMapping(value="/welcome")
	public String getPage() {
		return "Welcome";
	}
	
	@PostMapping(value="/romanToDecimal")
	public RomanNumeralConverterDTO romanToDecimal(@RequestBody RomanNumeralConverterDTO req) {
//		System.out.println("romanToDecimal: " + req.getRomanNumeralString());
		return numeralConverterService.romanToDecimal(req.getRomanNumeralString());
	}
	
	@PostMapping(value="/numberToRoman")
	public RomanNumeralConverterDTO numberToRoman(@RequestBody RomanNumeralConverterDTO req) {
//		System.out.println("numberToRoman: " + req.getNumericInt());
		return numeralConverterService.numberToRoman(req.getNumericInt());
	}

}