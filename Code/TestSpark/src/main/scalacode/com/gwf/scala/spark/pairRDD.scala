package com.gwf.scala.spark

import org.apache.spark.{SparkConf, SparkContext}

object pairRDD {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("guowenfeng")
    val sc = new SparkContext(conf)
    sc.setLogLevel("Error")

    val lines = sc.textFile("./data/words.txt")
    val pairs = lines.map(line => (line.split(" ")(0), 1))

    pairs.foreach(println)
  }
}
