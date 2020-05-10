package com.gwf.scala.spark

import org.apache.spark.{SparkConf, SparkContext}

object cache_test {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setAppName("cache")
    conf.setMaster("local")

    val sc = new SparkContext(conf)
    sc.setLogLevel("Error")

    // 测试 cache 对读取时间的影响
    // cache 默认是把数据加载到内存中
    val rdd = sc.textFile("./data/persistData.txt") // 由于文件过大，上传github失败，所以在项目中删除了该文件
    rdd.cache()

    // 因为 cache 是transformation算子，是懒加载的，所以此时内存中还没有 cache
    val startWithoutCache = System.currentTimeMillis()
    val countWithoutCache = rdd.count()
    val endWithoutCache = System.currentTimeMillis()
    println(s"Time Without Cache: ${endWithoutCache - startWithoutCache}ms, count is: ${countWithoutCache}")

    // 因为上面的 count 算子触发的 cache，所以此时内存中是有 rdd 的
    val startWithCache = System.currentTimeMillis()
    val countWithCache = rdd.count()
    val endWithCache = System.currentTimeMillis()
    println(s"Time With Cache: ${endWithCache - startWithCache}ms, count is ${countWithCache}")

    sc.stop()
  }
}
