package fr.octo.blockchainapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockchainApiController {

    @Autowired
    private BlockchainStatsBuilder blockchainStatsBuilder;

    @RequestMapping("/blockchain-stats")
    public BlockchainStats blockchainStats() {
        return blockchainStatsBuilder.build();
    }

}
