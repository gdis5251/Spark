package com.gwf.scala.spark

import org.apache.spark.{SparkConf, SparkContext}

object persist {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("Gerald")
    val sc = new SparkContext(conf)
    sc.setLogLevel("Error")

    val lines = sc.textFile("/usr/local/spark-2.4.5-bin-hadoop2.7/README.md")
    val sparkLine = lines.filter(line => {
      line.contains("Spark")
    })
    // 使用 persist 的默认存储等级可以把当前 RDD 存储到内存中
    // sparkLine.persist()
    // 如果是 persist 的默认存储等级，可以使用 cache 代替
    sparkLine.cache()

    // 以下两个都是 action 算子，会触发上面的 transformation 算子执行
    val res = sparkLine.first()
    println(res)

    val n = sparkLine.count()
    println(n)
  }
}
