package fr.octo.blockchainapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BlockchainStatsBuilder {

    @Autowired
    private RestTemplate restTemplate;

    public static final String URL_API_BLOCKCHAIN_INFO_STATS = "https://api.blockchain.info/stats";

    public BlockchainStats build() {
        return restTemplate.getForObject(URL_API_BLOCKCHAIN_INFO_STATS, BlockchainStats.class);
    }

}
