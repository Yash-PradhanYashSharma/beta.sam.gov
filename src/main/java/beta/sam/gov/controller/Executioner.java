package beta.sam.gov.controller;

import beta.sam.gov.entites.QueryParams;
import beta.sam.gov.entites.ResultsWrapper;
import beta.sam.gov.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class Executioner {

    /*
     *
     * https://beta.sam.gov/api/prod/sgs/v1/search/?index=opp&q=dla&page=0&sort=-relevance&mode=search&is_active=true&naics=51,54,55&notice_type=r,p,o&set_aside=SBA,SDVOSBC
     *
     * */

    @Autowired
    Utility utility;

    @GetMapping("/")
    public void pullRecords() {
        try {
            List<QueryParams> queryParams = utility.getQueryParams();
            queryParams.forEach(queryParam -> {
                ResultsWrapper wrapper = utility.getResultsWrapper(queryParam);
                utility.generateSpreadSheet(wrapper, queryParam);
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
