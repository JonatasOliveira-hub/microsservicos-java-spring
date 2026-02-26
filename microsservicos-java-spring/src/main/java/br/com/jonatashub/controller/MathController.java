package br.com.jonatashub.controller;

import java.util.regex.Pattern;
import br.com.jonatashub.exception.handler.CustomEntityResponseHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jonatashub.exception.UnsuportedMathOperationException;

@RestController
@RequestMapping("/math")
public class MathController {

    private final CustomEntityResponseHandler customEntityResponseHandler;

	private static final Pattern DOUBLE_PATTERN = Pattern
			.compile("[+-]?((\\d+\\.\\d*)|(\\.\\d+)|(\\d+))(?:[eE][+-]?\\d+)?");

    MathController(CustomEntityResponseHandler customEntityResponseHandler) {
        this.customEntityResponseHandler = customEntityResponseHandler;
    }

	@GetMapping("/sum/{num1}/{num2}")
	public Double sum(@PathVariable String num1, @PathVariable String num2) throws Exception {

		if (isValidDouble(num1) && isValidDouble(num2)) {
			return Double.valueOf(num1) + Double.valueOf(num2);
		}
		throw new UnsuportedMathOperationException("Informe um valor numérico");

	}
	
	@GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        if (isValidDouble(numberOne) && isValidDouble(numberTwo)) {
        	return Double.valueOf(numberOne) - Double.valueOf(numberTwo);
        }
    	throw new UnsuportedMathOperationException("Please set a numeric value!");

    }
    
    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
    	 if (isValidDouble(numberOne) && isValidDouble(numberTwo)) {
         	return Double.valueOf(numberOne) * Double.valueOf(numberTwo);
         }
     	throw new UnsuportedMathOperationException("Please set a numeric value!");
       
    }
    
    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
    	 if (isValidDouble(numberOne) && isValidDouble(numberTwo)) {
         	return Double.valueOf(numberOne) / Double.valueOf(numberTwo);
         }
     	throw new UnsuportedMathOperationException("Please set a numeric value!");
        
    }
    
    @GetMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
    	 if (isValidDouble(numberOne) && isValidDouble(numberTwo)) {
         	return (Double.valueOf(numberOne) + Double.valueOf(numberTwo))/2;
         }
     	throw new UnsuportedMathOperationException("Please set a numeric value!");
        
    }
    
    @GetMapping("/squareRoot/{number}")
    public Double squareRoot(@PathVariable String number) throws Exception {
    	 if (isValidDouble(number)) {
    		final  Double result = Math.sqrt(Double.valueOf(number));
    		return result;
         }
     	throw new UnsuportedMathOperationException("Please set a numeric value!");
        
    }

	public static boolean isValidDouble(String str) {
		if (str == null || str.isBlank())
			return false;
		return DOUBLE_PATTERN.matcher(str).matches();
	}

}
