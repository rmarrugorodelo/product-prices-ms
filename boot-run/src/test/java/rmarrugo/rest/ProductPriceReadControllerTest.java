package rmarrugo.rest;

import rmarrugo.config.BaseTest;
import rmarrugo.faker.TestConstant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.rmarrugo.constant.RouteConstant.BRAND_ID;
import static com.rmarrugo.constant.RouteConstant.DATE;
import static com.rmarrugo.constant.RouteConstant.PRODUCT_ID;
import static com.rmarrugo.constant.RouteConstant.V1_PATH;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProductPriceReadControllerTest extends BaseTest {


    @ParameterizedTest
    @CsvSource({
            "2020-06-14 10:00:00, response/product_prices_with_date_2020_06_14_10_00_00.json",
            "2020-06-14 16:00:00, response/product_prices_with_date_2020_06_14_16_00_00.json",
            "2020-06-14 21:00:00, response/product_prices_with_date_2020_06_14_21_00_00.json",
            "2020-06-15 10:00:00, response/product_prices_with_date_2020_06_15_10_00_00.json",
            "2020-06-16 21:00:00, response/product_prices_with_date_2020_06_16_21_00_00.json"
    })
    void givenProductPrices_whenGetProductPrices_thenStatus200(final String date, final String responsePath) throws Exception {
        String response = readFileToString(responsePath);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(V1_PATH)
                                .queryParam(BRAND_ID, TestConstant.BRAND_ID.toString())
                                .queryParam(PRODUCT_ID, TestConstant.PRODUCT_ID.toString())
                                .queryParam(DATE, date)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(response, true));
    }

    @Test
    void givenProductPrices_whenGetProductPrices_thenStatus400() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(V1_PATH)
                                .queryParam(BRAND_ID, TestConstant.BRAND_ID.toString())
                                .queryParam(PRODUCT_ID, TestConstant.PRODUCT_ID.toString())
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest());
    }


}
