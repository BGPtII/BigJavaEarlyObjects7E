package io.github.BGPtII.ch11ioandexceptionhandling.csvreading;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class CustomersCSVAnalyzer extends CSVReader {

    public CustomersCSVAnalyzer(String filePath) {
        super(filePath);
    }

    public ArrayList<Integer> getRowIndexesContainingEarliestSubscription() throws FileNotFoundException, ParseException {
        String[] subscriptionDateColumnFields = super.getColumnFields(10);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date earliestDate = null;
        ArrayList<Integer> earliestDateIndexes = new ArrayList<>();
        for (int i = 1; i < subscriptionDateColumnFields.length; i++) {
            Date date = simpleDateFormat.parse(subscriptionDateColumnFields[i]);

            if (earliestDate == null || date.before(earliestDate)) {
                earliestDate = date;
                earliestDateIndexes.clear();
                earliestDateIndexes.add(i + 1);
            }
            else if (date.equals(earliestDate)) {
                earliestDateIndexes.add(i + 1);
            }
        }
        return earliestDateIndexes;
    }

    public HashMap<String, Integer> getNameFrequency(boolean isFirst) throws FileNotFoundException {
        int columnIndex = (isFirst) ? 2 : 3;
        HashMap<String, Integer> nameHistogram = super.getColumnFieldHistogram(columnIndex);
        nameHistogram.remove("First Name");
        return nameHistogram;
    }

}
