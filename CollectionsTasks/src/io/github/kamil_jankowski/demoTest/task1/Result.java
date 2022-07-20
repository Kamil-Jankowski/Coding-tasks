package io.github.kamil_jankowski.demoTest.task1;

import java.util.*;

class Result {

    /*
     * Complete the 'processLogs' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY logs
     *  2. INTEGER threshold
     */

    public static List<String> processLogs(List<String> logs, int threshold) {
        List<String> users = new ArrayList<>();
        Map<Integer, Integer> numberOfTransactions = new TreeMap<>();   // Using TreeMap to provide sorted set of users.

        // For each log passed in list of logs perform split by empty spaces.
        for (String log : logs) {
            String[] transaction = log.split("\\s++");

            // Parse provided string to integer value, so the sorting in ascending order is done correctly.
            int from = Integer.parseInt(transaction[0]);
            int to = Integer.parseInt(transaction[1]);
        /*
        Increase the number of transactions for each user,
        or place it into the map if not yet present.
        For recipient, verify if it is not the same as sender, to avoid double calculation.
        */
            numberOfTransactions.put(from, numberOfTransactions.getOrDefault(from, 0) + 1);
            if (from != to) numberOfTransactions.put(to, numberOfTransactions.getOrDefault(to, 0) + 1);
        }

        /*
        Iterate over sorted set of users.
        If number of transactions for a user exceeds or is equal to a given threshold,
        add the user to the result list.
        */
        for (int user : numberOfTransactions.keySet()) {
            if (numberOfTransactions.get(user) >= threshold){
                users.add(String.valueOf(user));
            }
        }
        System.out.println(users);
        return users;
    }
}
