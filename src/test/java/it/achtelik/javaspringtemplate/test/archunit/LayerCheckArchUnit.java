package it.achtelik.javaspringtemplate.test.archunit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition;

@AnalyzeClasses(packages = "it.achtelik.javaspringtemplate")
class LayerCheckArchUnit {

    @ArchTest
    public static final ArchRule onionRule = Architectures.onionArchitecture()
            .domainModels("..domains.models..")
            .domainServices("..domains.services..","..domains.adapters..")
            .applicationServices("..applications.services..")
            .adapter("rest", "..entrypoints..")
            .adapter("mongo", "..dataproviders..");
}
