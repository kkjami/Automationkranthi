package resttest;


import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class RestTempletePract {


    public static void main(String[] args) {

        Transferv1Request transferv1Request = new Transferv1Request();
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://phoenix02.dev.ts:7090/topupservice/transfer";

        transferv1Request.setChannel("WSClient");
        transferv1Request.setClientId("ERS");
        transferv1Request.setClientRequestTimeout("500");
        transferv1Request.setId("DIST1");
        transferv1Request.setType("RESELLERUSER");
        transferv1Request.setUserId("webuser");
        transferv1Request.setPassword("20162016");
        transferv1Request.setSenderPrincipalId("DIST1");
        transferv1Request.setSenderPrincipalUserId("webuser");
        transferv1Request.setSenderAccountId("DIST1");
        transferv1Request.setSenderPrincipalType("RESELLERUSER");
        transferv1Request.setSenderAccountTypeId("RESELLER");
        transferv1Request.setReceiverPrincipalId("1");
        transferv1Request.setReceiverPrincipalIdType("RESELLERID");
        transferv1Request.setReceiverAccountSpecifierTypeId("RESELLER");
        transferv1Request.setProductId("TRANSFER");
        transferv1Request.setCurrency("BSD");
        transferv1Request.setValue("1000");
        transferv1Request.setPurpose("donation");


        ResponseEntity<String> response = restTemplate.postForEntity(fooResourceUrl, transferv1Request, String.class);
//    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        System.out.println(response);

    }

}
