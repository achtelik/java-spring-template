package it.achtelik.javaspringtemplate.test.archunit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition;

@AnalyzeClasses(packages = "it.achtelik.javaspringtemplate")
class CycleCheckArchUnit {

    @ArchTest
    public static final ArchRule cycleRule = SlicesRuleDefinition.slices()
            .matching("it.achtelik.javaspringtemplate.(**)").should().beFreeOfCycles();
}
