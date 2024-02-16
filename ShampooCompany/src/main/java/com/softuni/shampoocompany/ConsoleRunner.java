package com.softuni.shampoocompany;

import com.softuni.shampoocompany.services.IngredientService;
import com.softuni.shampoocompany.services.LabelService;
import com.softuni.shampoocompany.services.ShampooService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final IngredientService ingredientService;
    private final LabelService labelService;
    private final ShampooService shampooService;

    @Autowired
    public ConsoleRunner(IngredientService ingredientService, LabelService labelService, ShampooService shampooService) {
        this.ingredientService = ingredientService;
        this.labelService = labelService;
        this.shampooService = shampooService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        final Scanner scanner = new Scanner(System.in);

        //Task 1
        shampooService.findAllBySizeOrderById(scanner.nextLine()).forEach(System.out::println);

        //Task 2
        shampooService.findAllBySizeOrLabelId(scanner.nextLine(), scanner.nextLine()).forEach(System.out::println);

        //Task 3
        shampooService.findByPriceGreaterThanOrderByPriceDesc(scanner.nextLine()).forEach(System.out::println);

        //Task 4
        ingredientService.findAllByNameStartingWith(scanner.nextLine()).forEach(System.out::println);

        //Task 5
        ingredientService.findAllByNameInOrderByPriceAsc(getListOfInputData(scanner)).forEach(System.out::println);

        //Task 6
        System.out.println(shampooService.countAllByPriceLessThan(scanner.nextLine()));

        //Task7
        shampooService.findAllByIngredients(getListOfInputData(scanner)).forEach(System.out::println);

        //Task8
//        shampooService.findByIngredientsCountLessThan(scanner.nextLine()).forEach(System.out::println);

        //Task 9
        ingredientService.deleteByName(scanner.nextLine());

        //Task 10
        ingredientService.updateAllPrice();

        //Task 11
        ingredientService.updatePriceByName(getListOfInputData(scanner));
    }

    private static List<String> getListOfInputData(Scanner scanner) {
        final List<String> inputDataList = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.isBlank()) {
            inputDataList.add(input);
            input = scanner.nextLine();
        }

        return inputDataList;
    }
}
