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
    private static final String SPLITTER = " ";

    public static void main(String[] args) throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSet<String> text = env.fromElements("I have a simple demo.This is a very simple word count demo to count word.");
        DataSet<Tuple2<String, Integer>> counts = text.flatMap(new WordCountTokenizer())
                .groupBy(0)
                .sum(1);
        counts.print();
    }

    public static class WordCountTokenizer implements FlatMapFunction<String, Tuple2<String, Integer>> {

        @Override
        public void flatMap(String value, Collector<Tuple2<String, Integer>> collector) {
            for (String token: value.split(SPLITTER)){
                collector.collect(new Tuple2<>(token, 1));
            }
        }
    }

}
