package yangbo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/consumer")
@RestController
public class ConsumerController {

    private String restTemplateUrl = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consul")
    public String getPaymentConsul(){
        return restTemplate.getForObject(restTemplateUrl + "/payment/consul", String.class);
    }
}
