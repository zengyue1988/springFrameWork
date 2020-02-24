package com.moon.integration.fileChannelAdapter;

import java.io.File;

public class Printer {
	
    public File print(File content){
        System.out.println(content.getName());
        return content;
    }
    
}