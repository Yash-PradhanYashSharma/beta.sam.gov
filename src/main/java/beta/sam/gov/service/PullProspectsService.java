/*
 *
 * https://beta.sam.gov/api/prod/sgs/v1/search/?index=opp&q=dla&page=0&sort=-relevance&mode=search&is_active=true&naics=51,54,55&notice_type=r,p,o&set_aside=SBA,SDVOSBC
 *
 */
package beta.sam.gov.service;

import beta.sam.gov.entites.QueryParams;
import beta.sam.gov.entites.ResultsWrapper;
import beta.sam.gov.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class PullProspectsService {

    @Autowired
    Utility utility;

    @Scheduled(cron = "${cron}")
    public void pullRecords() {
        try {
            List<QueryParams> queryParams = utility.getQueryParams();
            ExecuteService(queryParams);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void ExecuteService(List<QueryParams> queryParams) {
        queryParams.forEach(queryParam -> {
            ResultsWrapper wrapper = utility.getResultsWrapper(queryParam);
            utility.generateSpreadSheet(wrapper, queryParam);
        });
    }
}
