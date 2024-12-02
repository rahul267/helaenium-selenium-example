package com.epam.healenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.URL;

public class LocalPage {
    private final WebDriver driver;
    private final URL url = getClass().getClassLoader().getResource("checkout/index.html");
    public LocalPage(WebDriver driver) {
        this.driver = driver;
    }


    public void navigate() {
        driver.navigate().to(url);
    }


}
