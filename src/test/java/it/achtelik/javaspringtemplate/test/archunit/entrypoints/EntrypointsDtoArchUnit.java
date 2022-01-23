package it.achtelik.javaspringtemplate.test.archunit.entrypoints;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import it.achtelik.javaspringtemplate.test.archunit.ArchUnitConstants;

@AnalyzeClasses(packages = ArchUnitConstants.BASE_PATH + "..entrypoints",
        importOptions = {ImportOption.DoNotIncludeTests.class})
public class EntrypointsDtoArchUnit {
    @ArchTest
    public static final ArchRule naming = ArchRuleDefinition.classes().that()
            .resideInAPackage("..entrypoints.rest..").should()
            // Common naming convention
            // Dtos are simple values for the data transfer.
            .haveSimpleNameEndingWith("Dto")
            // DtoMapper converts domain objects and dtos into each other.
            .orShould().haveSimpleNameEndingWith("DtoMapper")
            // Controllers contains or wraps the base entrypoint logic.
            .orShould().haveSimpleNameEndingWith("Controller");

}
