package com.gwf.scala.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object spark_wordcount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setAppName("wordcount")
    conf.setMaster("local")

    val sc = new SparkContext(conf)
    val lines = sc.textFile("./data/words.txt")
    val words = lines.flatMap(line => {
      line.split(" ")
    })

    val pairWords: RDD[(String, Int)] = words.map(word => {
      new Tuple2(word, 1)
    })

    val result: RDD[(String, Int)] = pairWords.reduceByKey((v1: Int, v2: Int) => {
      v1 + v2
    })

    result.foreach(println)
  }
}
