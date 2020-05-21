package com.gwf.scala.spark

import org.apache.spark.{SparkConf, SparkContext}

object mapPartitions {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("intersection").setMaster("local")
    val sc = new SparkContext(conf)

    val rdd1 = sc.parallelize(List(1, 2, 3, 4, 5, 6), 3)
    val rdd2 = rdd1.mapPartitions(_.map(_ * 10))
    println(rdd2.collect.toList)

    val iter = (index: Int, iter: Iterator[(Int)]) => {
      iter.map(x => "[partId:" + index + ", value:" + x + "]")
    }

    val rdd3 = rdd1.mapPartitionsWithIndex(iter)
    println(rdd3.collect.toList)

  }
}
