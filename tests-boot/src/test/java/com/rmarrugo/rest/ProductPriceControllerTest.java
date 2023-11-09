package com.rmarrugo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rmarrugo.domain.ProductPrice;
import com.rmarrugo.exception.NotFoundException;
import com.rmarrugo.faker.TestConstant;
import com.rmarrugo.port.in.ProductPriceFinder;
import com.rmarrugo.rest.controller.ProductPriceController;
import com.rmarrugo.rest.mapper.ProductPriceRestMapper;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProductPriceControllerTest {

    private static final String V2_PATH = "/v2/product-prices";

    @Mock
    ProductPriceFinder finder;

    @Mock
    ProductPriceRestMapper mapper;

    @InjectMocks
    ProductPriceController controller;

    MockMvc mockMvc;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new ControllerAdvisor()).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testFindByIdentificationInDatabaseOk() throws Exception {
        final String path = V2_PATH + "/{identificationType}/{identificationNumber}";
        EasyRandom easyRandom = new EasyRandom();
        var productPrice = easyRandom.nextObject(ProductPrice.class);
        Mockito.when(finder.findByBrandAndProductAndDate( any(), any(), any()))
                .thenReturn(productPrice);
        this.mockMvc.perform(get(path, "C", TestConstant.IDENTIFICATION_NUMBER)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }

    @Test
    void testFindByIdentificationInDatabaseBadRequest() throws Exception {
        final String path = V2_PATH + "/{identificationType}/{identificationNumber}";
        EasyRandom easyRandom = new EasyRandom();
        var productPrice = easyRandom.nextObject(ProductPrice.class);
        Mockito.when(finder.findByBrandAndProductAndDate( any(), any(), any()))
                .thenReturn(productPrice);
        this.mockMvc.perform(get(path, "C", "34r546fd")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    void testFindByIdentificationInDatabaseNotFound() throws Exception {
        final String path = V2_PATH + "/{identificationType}/{identificationNumber}";
        Mockito.when(finder.findByBrandAndProductAndDate( any(), any(), any()))
                .thenThrow(new NotFoundException(""));
        this.mockMvc.perform(get(path, "C", TestConstant.IDENTIFICATION_NUMBER)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotFound());
    }


    @Test
    void testFindAllInDatabaseOk() throws Exception {
        this.mockMvc.perform(get(V2_PATH, "C", TestConstant.IDENTIFICATION_NUMBER)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }

}
