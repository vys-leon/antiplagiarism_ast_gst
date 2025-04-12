package org.example;

import com.nlputil.gst.*;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String path = "data/submission1.java";

        List<TokenInfo> Submission1Tokens = TokenCollector.collectTokensFromFile("data/another_task/s686549426.java");
        List<TokenInfo> Submission2Tokens = TokenCollector.collectTokensFromFile("data/s041396743.java");

        StringBuilder submissionBuild1 = new StringBuilder();
        for (TokenInfo token : Submission1Tokens) {
            submissionBuild1.append((char) token.type);
        }
        String submission1 = submissionBuild1.toString();

        StringBuilder submissionBuild2 = new StringBuilder();
        for (TokenInfo token : Submission2Tokens) {
            submissionBuild2.append((char) token.type);
        }
        String submission2 = submissionBuild2.toString();

        PlagResult res = GreedyStringTiling.run(submission1, submission2, 1, 0.8f);
        System.out.println(res);
        //System.out.println(submission1);
        //System.out.println(submission2);
    }
}
