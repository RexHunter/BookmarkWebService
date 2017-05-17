package com.rexxie.OfflineBookmarksWebService.web.controllers;

import org.junit.Before;
import org.junit.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;

@SpringBootTest
public class APITest {

    @Rule
    public JUnitRestDocumentation restDocumentation =
            new JUnitRestDocumentation("src/main/resources/snippets");

    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
        this.mockMvc =
                MockMvcBuilders
                        .webAppContextSetup(this.context)
                        .apply(documentationConfiguration(this.restDocumentation))
                        .build();
    }
}
