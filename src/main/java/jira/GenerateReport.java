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

public class GenerateReport {

    public static void main(String[] args) {
        System.out.println("START");
        final String jiraUser = "usename";
        final String jiraPassword = "password";
        final String jiraBaseURL = "http://jira.dev.ts";
        URI jiraServerUri = null;
        JiraRestClient client = null;
        try{
            jiraServerUri = new URI(jiraBaseURL);
            JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
            client = factory.createWithBasicHttpAuthentication(jiraServerUri, jiraUser, jiraPassword);
            IssueRestClient issueClient = client.getIssueClient();
            SearchRestClient searchClient = client.getSearchClient();
            //CONSTRUIMOS LA PETICION

            SearchResult result = searchClient.searchJql("reporter=kranthi.jami").claim();

            for(Issue issue : result.getIssues()){

                System.out.println(issue.getKey());

            }


        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("END");
    }
}
