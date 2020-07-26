package com.gwf.scala.spark

import org.apache.spark.{SparkConf, SparkContext}

object intersection {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("intersection").setMaster("local")
    val sc = new SparkContext(conf)

    val rdd1 = sc.parallelize(List(1, 2, 3, 4))
    var rdd2 = sc.parallelize(List(3, 4, 5, 6))

    val rdd3 = rdd1 intersection rdd2
    println(rdd3.collect().toBuffer)

    val rdd4 = rdd1 union rdd2
    println(rdd4.collect.toBuffer)

    println(rdd4.distinct().collect.toBuffer)

    val rdd5 = sc.parallelize(List(("Gerald", 1), ("GuoWenfeng", 2), ("HuYue", 3)))
    val rdd6 = sc.parallelize(List(("GuoWenfeng", 22), ("HuYue", 21), ("Seligman", 21)))
    val rdd7 = rdd5 join rdd6
    println(rdd7.collect.toBuffer)

    val rdd8 = sc.parallelize(List(("Gerald", 1), ("GuoWenfeng", 2), ("HuYue", 3),("GuoWenfeng", 22), ("HuYue", 21), ("Seligman", 21)))
    val rdd9 = rdd8.groupBy(_._1)
    println(rdd9.collect().toBuffer )

    // 第一个小括号内的是默认值，是通过key计算完还有计算全局
    val rdd8_1 = rdd8.aggregateByKey(1)(_ + _, _ + _)
    println(rdd8_1.collect.toList)
  }
}
