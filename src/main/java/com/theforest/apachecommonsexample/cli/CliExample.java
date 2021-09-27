package com.theforest.apachecommonsexample.cli;

import org.apache.commons.cli.*;

/**
 * Command Line arguments parser
 */
public class CliExample {
    public static void main(String[] args) throws ParseException {
        args = new String[]{};
//        args = new String[]{"-c", "21"};
        // create Options object
//        cmdWithoutArguments(args);

        cmdWithArguments(args);
    }

    private static void cmdWithArguments(String[] args) throws ParseException {
        final Options options = new Options();
        options.addOption(new Option("d", "debug", false, "Turn on debug."));
        options.addOption(new Option("e", "extract", false, "Turn on extract."));
        options.addOption(new Option("o", "option", true, "Turn on option with argument."));
        // add c option
        options.addOption("c", true, "country code");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse( options, args);
        // get c option value
        String countryCode = cmd.getOptionValue("c");

        if(countryCode == null) {
            // print default date
            System.out.println("print default date");
        }
        else {
            // print date for country specified by countryCode
            System.out.println("print date for country specified by countryCode");

        }
    }

    private static void cmdWithoutArguments(String[] args) throws ParseException {
        Options options = new Options();

        // add t option
        options.addOption("t", false, "display current time");
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        if(cmd.hasOption("t")) {
            System.out.println("print the date and time");
        }
        else {
            System.out.println("print the date");
        }
    }
}
