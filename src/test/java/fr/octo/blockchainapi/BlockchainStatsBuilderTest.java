package fr.octo.blockchainapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

import static fr.octo.blockchainapi.BlockchainStatsBuilder.URL_API_BLOCKCHAIN_INFO_STATS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BlockchainStatsBuilderTest {

    @InjectMocks
    private BlockchainStatsBuilder blockchainStatsBuilder;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void build() {
        // Given
        BlockchainStats blockchainStats = new BlockchainStats();
        blockchainStats.setMarketPriceBitcoinInUSD(new BigDecimal(2138.17d));
        when(restTemplate.getForObject(URL_API_BLOCKCHAIN_INFO_STATS, BlockchainStats.class)).thenReturn(blockchainStats);

        // When
        BlockchainStats result = blockchainStatsBuilder.build();

        // Then
        assertThat(result.getMarketPriceBitcoinInUSD()).isEqualTo(new BigDecimal(2138.17));
    }

}