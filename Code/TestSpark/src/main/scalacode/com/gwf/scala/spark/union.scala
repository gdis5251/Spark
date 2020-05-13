package com.gwf.scala.spark

import org.apache.spark.{SparkConf, SparkContext}

object union {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("guowenfeng")
    val sc = new SparkContext(conf)
    sc.setLogLevel("Error")

    val lines = sc.textFile("/usr/local/spark-2.4.5-bin-hadoop2.7/README.md")
    val scalaLine = lines.filter(line => {
      line.contains("Scala")
    })
    val sparkLine = lines.filter(line => {
      line.contains("Spark")
    })

    // union 是连接两个 RDD，生成一个新的 RDD
    val sumLines = scalaLine.union(sparkLine)
    println(sumLines.count())
    sumLines.take(10).foreach(println)
  }
}
