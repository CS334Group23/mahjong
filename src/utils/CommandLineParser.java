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

// TODO: Auto-generated Javadoc
/**
 * The Class CommandLineParser.
 */
public class CommandLineParser {
    
    /** The args. */
    List <String> args = new ArrayList<>();
    
    /** The map. */
    HashMap<String, List<String>> map = new HashMap<>();
    
    /** The flags. */
    Set<String> flags = new HashSet<>();

    /**
     * Instantiates a new command line parser.
     *
     * @param arguments the arguments
     */
    public CommandLineParser(String arguments[])
    {
        this.args = Arrays.asList(arguments);
        map();
    }

    /**
     * Gets the argument names.
     *
     * @return the argument names
     */
    // Return argument names
    public Set<String> getArgumentNames()
    {
        Set<String> argumentNames = new HashSet<>();
        argumentNames.addAll(flags);
        argumentNames.addAll(map.keySet());
        return argumentNames;
    }
    
    /**
     * Gets the flag.
     *
     * @param flagName the flag name
     * @return the flag
     */
    // Check if flag is given
    public boolean getFlag(String flagName)
    {
        if(flags.contains(flagName))
            return true;
        return false;
    }

    /**
     * Gets the argument value.
     *
     * @param argumentName the argument name
     * @return the argument value
     */
    // Return argument value for particular argument name
    public String[] getArgumentValue(String argumentName)
    {
        if(map.containsKey(argumentName))
            return map.get(argumentName).toArray(new String[0]);
        else
            return null;
    }

    /**
     * Map.
     */
    // Map the flags and argument names with the values 
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

