/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: CommandLineParser.java </p> 
 * @author TeamCS3343 </a>
 */
package utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * The Class CommandLineParser.
 * The Class CommandLineParser to parse the command line arguments.
 */
public class CommandLineParser {
    
    /** The args to store seperated commnad line arguments. */
    List <String> args = new ArrayList<>();
    
    /** The hash map option name and its parameters. */
    HashMap<String, List<String>> map = new HashMap<>();
    
    /** The flags. */
    Set<String> flags = new HashSet<>();

    /**
     * Instantiates a new command line parser.
     *
     * @param arguments the arguments array
     */
    public CommandLineParser(String arguments[])
    {
        this.args = Arrays.asList(arguments);
        map();
    }

    /**
     * Gets the argument value according to a option name
     *
     * @param argumentName the argument name
     * @return the argument value
     */
    public String[] getArgumentValue(String argumentName)
    {
        if(map.containsKey(argumentName))
            return map.get(argumentName).toArray(new String[0]);
        else
            return null;
    }

    /**
     * Map the flags and argument names with the values.
     */
    public void map()
    {
        for(String arg: args)
        {
            if(arg.startsWith("-"))
            {
                if (args.indexOf(arg) == (args.size() - 1))
                {
                    flags.add(arg.replace("-", ""));
                }
                else if (args.get(args.indexOf(arg)+1).startsWith("-"))
                {
                    flags.add(arg.replace("-", ""));
                }
                else
                {
                    //List of values (can be multiple)
                    List<String> argumentValues = new ArrayList<>();
                    int i = 1;
                    while(args.indexOf(arg)+i != args.size() && !args.get(args.indexOf(arg)+i).startsWith("-"))
                    {
                        argumentValues.add(args.get(args.indexOf(arg)+i));
                        i++;
                    }
                    map.put(arg.replace("-", ""), argumentValues);
                }
            }
        }
    }
}

