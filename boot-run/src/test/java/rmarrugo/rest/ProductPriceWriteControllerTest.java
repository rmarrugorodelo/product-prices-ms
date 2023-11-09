package rmarrugo.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import rmarrugo.config.BaseTest;

import static com.rmarrugo.constant.RouteConstant.V1_PATH;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProductPriceWriteControllerTest extends BaseTest {


    @ParameterizedTest
    @ValueSource(strings = {
            "request/product_price_with_invalid_date.json",
            "request/product_price_with_invalid_brand_id.json"
    })
    void cratingProductPrices_whenInvalidData_thenStatus400(String requestPath) throws Exception {
        String request = readFileToString(requestPath);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post(V1_PATH)
                                .content(request)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                ).andExpect(status().isBadRequest());
    }

    @Test
    void cratingProductPrices_whenValidData_thenStatus200() throws Exception {
        String request = readFileToString("request/product_price.json");
        this.mockMvc.perform(
                MockMvcRequestBuilders.post(V1_PATH)
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
    }

    @Test
    void cratingProductPrices_whenBrandNotFound_thenStatus404() throws Exception {
        String request = readFileToString("request/product_price_with_brand_not_found.json");
        this.mockMvc.perform(
                MockMvcRequestBuilders.post(V1_PATH)
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isNotFound());
    }

}
