package jupai.dataprep;

import joinery.DataFrame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JoineryExample {
    public static void main(String args[]) {
        try {

            DataFrame<Object> df1 = DataFrame.readCsv ("src/main/resources/data/titanic.csv")
                    .retain ("pclass",	"survived",	"name",	"sex",	"age",	"sibsp")
            .describe ();
             System.out.println (df1.toString ());
            System.out.println ("=========================================================================================");
             System.in.read();
              System.out.println ("Mean Survived For each gender ");
            DataFrame<Object> df = DataFrame.readCsv ("src/main/resources/data/titanic.csv")
                    .retain ("survived","sex")
                    .groupBy (row -> row.get (1))
                    .mean ();

            System.out.println (df.toString ());
            System.out.println ("================================adding column to data frame=========================================================");
               System.in.read();
              System.out.println ("Counting Survived For each age ");
            DataFrame<Object> df2 = DataFrame.readCsv ("src/main/resources/data/titanic.csv")
                    .retain ("survived","age")
                    .groupBy (row -> row.get (1))
                    .count()
                    .sortBy("age");

            System.out.println (df2.toString ());
            /*DataFrame<Object> df2 = DataFrame.readCsv ("src/main/resources/data/titanic.csv")
                    .retain ("pclass", "survived", "name", "sex", "age");
            List<Integer> newValues = new ArrayList<> ();
            List<Object> values = df2.col ("sex");
            for (Object obj : values) {
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str != null && str.equals ("female"))
                        newValues.add (1);
                    else
                        newValues.add (0);
                }

            }
            df2.add ("Gender",newValues);

           System.out.println (df2.head (10));*/
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
