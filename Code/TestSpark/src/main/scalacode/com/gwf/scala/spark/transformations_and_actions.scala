package com.gwf.scala.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object transformations_and_actions {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("practice transformations")

    val sc = new SparkContext(conf)
    sc.setLogLevel("Error")

    val lines = sc.textFile("./data/words.txt")

    // count
    val l = lines.count()
    println(l)

    // collect
    lines.collect().foreach(println)

    // first
    val str = lines.first()
    println(str)

    //take
    lines.take(3).foreach(println)

    // sample
    /**
     * 第一个参数 true 表示抽取出来的数据放回，false 表示不放回
     * 第二个参数时表示抽取数据的比例
     * 第三个参数是种子，如果不指定，那么每次运行的结果是不一样的，如果指定且数据一样，每次运行的结果是一样的
     */
    // lines.sample(true, 0.1).foreach(println)

    //    val words = lines.flatMap(one => {
    //      one.split(" ")
    //    })
//    val pairWords = words.map(one => {
//      (one, 1)
//    })
//
//
//
//    // word count
//    val wc = pairWords.reduceByKey((v1: Int, v2: Int) => {
//      v1 + v2
//    })
//
//    // sortByKey
//    val transformWc = wc.map(tp => {
//      tp.swap
//    })
//    val res = transformWc.sortByKey(false)
//    res.map(_.swap).foreach(println)

    // sortBy
//    wc.sortBy(tp=>{
//      tp._2
//    }, false).foreach(println)

    // filter
//    lines.flatMap(one=>{
//      one.split(" ")
//    }).filter(one=>{
//      "gerald".equals(one)
//    }).foreach(println)

    // map
//    lines.map(one=>{
//      one + "~"
//    }).foreach(println)

    // flatMap
//    lines.flatMap(one => {
//      one.split(" ")
//    }).foreach(println)

    sc.stop()


  }
}
