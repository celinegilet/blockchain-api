package fr.octo.blockchainapi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static fr.octo.blockchainapi.BlockchainStatsBuilder.URL_API_BLOCKCHAIN_INFO_STATS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlockchainStatsBuilderServerTest {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BlockchainStatsBuilder blockchainStatsBuilder;

    private MockRestServiceServer mockServer;

    @Before
    public void setUp() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    String responseApiBlockchain = "{\n" +
            "  \"market_price_usd\": 2138.17,\n" +
            "  \"hash_rate\": 6158947309.25,\n" +
            "  \"total_fees_btc\": 19025989619,\n" +
            "  \"n_btc_mined\": 192500000000,\n" +
            "  \"n_tx\": 220306,\n" +
            "  \"n_blocks_mined\": 154,\n" +
            "  \"minutes_between_blocks\": 8.77,\n" +
            "  \"totalbc\": 1645336250000000,\n" +
            "  \"n_blocks_total\": 476269,\n" +
            "  \"estimated_transaction_volume_usd\": 546673812.75,\n" +
            "  \"blocks_size\": 144041804,\n" +
            "  \"miners_revenue_usd\": 4522801.29,\n" +
            "  \"nextretarget\": 477791,\n" +
            "  \"difficulty\": 804525194568,\n" +
            "  \"estimated_btc_sent\": 25567278275313,\n" +
            "  \"miners_revenue_btc\": 2115,\n" +
            "  \"total_btc_sent\": 247173405030826,\n" +
            "  \"trade_volume_btc\": 96413.69,\n" +
            "  \"trade_volume_usd\": 206149596.43,\n" +
            "  \"timestamp\": 1500322725000\n" +
            "}";

    @Test
    public void testGetMessage() {
        mockServer.expect(requestTo(URL_API_BLOCKCHAIN_INFO_STATS))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(responseApiBlockchain, APPLICATION_JSON_UTF8));

        BlockchainStats blockchainStats = blockchainStatsBuilder.build();

        mockServer.verify();
        assertThat(blockchainStats.getMarketPriceBitcoinInUSD()).isEqualTo("2138.17");
    }

}
