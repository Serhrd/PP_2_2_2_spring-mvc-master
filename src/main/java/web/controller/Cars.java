package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiseImpl;
import web.service.CarServiseImpl.*;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Cars {

	@GetMapping(value = "/cars")
	public String printWelcome(ModelMap model, @RequestParam(value = "count", defaultValue = "5") String param) {
		int count = Integer.parseInt(param);
		List<Car> cars = new ArrayList<>();
		cars.add(new Car(0,"Toyota", 70));
		cars.add( new Car(1,"Audi", 3));
		cars.add( new Car(2,"Porsche", 911));
		cars.add( new Car(3,"Nissan", 13));
		cars.add( new Car(4,"BMW", 43));
		CarServiseImpl servise = new CarServiseImpl();
		if (count<5){
			cars = servise.viewCar(cars,count);
		}
		model.addAttribute("cars", cars );
		return "cars";
	}

	
}