package com.lighthouse.luncher;

import com.lighthouse.luncher.App.Luncher;
import com.lighthouse.luncher.Configuration.Configuration;

public class Main {
    public static void main(String[] args) {
        try {
            Configuration configuration = new Configuration();
            configuration.load();
            Luncher luncher = new Luncher(configuration);
            String selection = luncher.run();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
