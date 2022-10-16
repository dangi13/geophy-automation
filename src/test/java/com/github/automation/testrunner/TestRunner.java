package com.github.automation.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/Features" }, glue = {
		"com.github.automation.stepdefinitions" }, monochrome = true, publish = true, snippets = CucumberOptions.SnippetType.CAMELCASE, plugin = {
				"pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm" })
public class TestRunner {
	

}
