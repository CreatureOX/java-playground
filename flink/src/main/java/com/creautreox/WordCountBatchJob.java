package com.creautreox;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

/**
 * @author CreatureOX
 * date: 2020/8/12
 * description:
 */
public class WordCountBatchJob {
    private static final String INPUT_PATH = "wordCountText.txt";
    private static final String OUTPUT_PATH = "wordCountStat.csv";

    public static void main(String[] args) {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSet<String> text = env.readTextFile(INPUT_PATH);
        DataSet<Tuple2<String, Integer>> counts = text.flatMap(new WordCountTokenizer())
                .groupBy(0)
                .sum(1);
        counts.writeAsCsv(OUTPUT_PATH,"\n", " ");
    }

    public static class WordCountTokenizer implements FlatMapFunction<String, Tuple2<String, Integer>> {

        @Override
        public void flatMap(String value, Collector<Tuple2<String, Integer>> collector) throws Exception {
            String[] tokens = value.toLowerCase().split("\\w+");
            for (String token: tokens){
                if (token.length() > 0){
                    collector.collect(new Tuple2<String, Integer>(token, 1));
                }
            }
        }
    }

}
