package jira;

import com.atlassian.jira.rest.client.api.IssueRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
import com.atlassian.jira.rest.client.api.SearchRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.SearchResult;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateReport {
    static List<String> customers;
    public static void main(String[] args) {
        System.out.println("START");
        final String jiraUser = "kranthi.jami";
        final String jiraPassword = "9492851007";
        final String jiraBaseURL = "http://jira.dev.ts";
        URI jiraServerUri = null;
        JiraRestClient client = null;
        List<String> finalmsgs = new ArrayList<>();
        customers = Arrays.asList("af-mtn",
                "bf-telecel",
                "bitRefill",
                "bj-glo",
                "bj-mtn",
                "BP",
                "br-dt",
                "bs-newco",
                "cd-lin",
                "cg-mtn",
                "ci-mtn",
                "dj-evt",
                "ers-std",
                "fi-dna",
                "fr-evodial",
                "gb-mtn",
                "gh-glo",
                "gh-mtn",
                "gn-mtn",
                "internal",
                "ir-mci",
                "lr-mtn",
                "lv-lettel",
                "ng-glo",
                "ro-seqr",
                "rw-mtn",
                "sd-mtn",
                "se-banksystem",
                "se-evd",
                "se-mrs",
                "se-seqr",
                "se-vt",
                "sn-expresso",
                "ss-mtn",
                "starlink",
                "swz-mobile",
                "sy-mtn",
                "th-gosoft",
                "ye-mtn",
                "zm-mtn");

        try {
            jiraServerUri = new URI(jiraBaseURL);
            JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
            client = factory.createWithBasicHttpAuthentication(jiraServerUri, jiraUser, jiraPassword);
            IssueRestClient issueClient = client.getIssueClient();
            SearchRestClient searchClient = client.getSearchClient();
            //CONSTRUIMOS LA PETICION

            /*SearchResult result = searchClient.searchJql("reporter=kranthi.jami").claim();

            for(Issue issue : result.getIssues()){

                System.out.println(issue.getKey());

            }*/

            String first = LocalDate.now().with(ChronoField.MONTH_OF_YEAR, Month.JULY.getValue()).with(TemporalAdjusters.firstDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE);
            String last = LocalDate.now().with(ChronoField.MONTH_OF_YEAR, Month.JULY.getValue()).with(TemporalAdjusters.lastDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE);

//            for (String customer : customers) {
//                String total = "(project = 'ERS Standard Automation' OR customer = " + customer + " ) and issuetype = Bug AND created >= 2017-01-01 and status!=Closed";
//                String closed = "(project = \"ERS Standard Automation\" OR customer = " + customer + " ) and issuetype = Bug AND status = Closed AND resolved >= " + first + " AND resolved <= " + last;
//                String open = "(project = \"ERS Standard Automation\" OR customer =" + customer + ") and issuetype = Bug AND created >= " + first + " AND created <= " + last;
//
//                finalmsgs.add(customer
//                        + " " + searchClient.searchJql(total).claim().getTotal()
//                        + " " + searchClient.searchJql(open).claim().getTotal()
//                        + " " + searchClient.searchJql(closed).claim().getTotal());
//
//            }

            for (String customer : customers) {
                String openjuly = "(project = \"ERS Standard Automation\" OR customer =" + customer + ") and issuetype = Bug AND created >= " + getFirst(Month.JULY) + " AND created <= " + getLast(Month.JULY);
                String openjune = "(project = \"ERS Standard Automation\" OR customer =" + customer + ") and issuetype = Bug AND created >= " + getFirst(Month.JUNE) + " AND created <= " + getLast(Month.JUNE);
                String openmay = "(project = \"ERS Standard Automation\" OR customer =" + customer + ") and issuetype = Bug AND created >= " + getFirst(Month.MAY) + " AND created <= " + getLast(Month.MAY);

                finalmsgs.add(customer
                        + " " + searchClient.searchJql(openjuly).claim().getTotal()
                        + " " + searchClient.searchJql(openjune).claim().getTotal()
                        + " " + searchClient.searchJql(openmay).claim().getTotal());

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (String line : finalmsgs) {
            System.out.println(line);

        }
        System.out.println("END");
    }
    static private String getLast(Month month){
        return LocalDate.now().with(ChronoField.MONTH_OF_YEAR, month.getValue()).with(TemporalAdjusters.lastDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
    static private String getFirst(Month month){
        return LocalDate.now().with(ChronoField.MONTH_OF_YEAR, month.getValue()).with(TemporalAdjusters.firstDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
