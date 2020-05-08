# Spark核心RDD

> RDD 全称为 Resilient Distributed Dataset 弹性分布式数据集

因为在刚接触了spark后，好像有很多这种 RDD 的类型，RDD 就是 spark 在计算过程中使用的数据集。

当 spark 从 HDFS 中读取了数据后，默认会依据 HDFS 的 block 数量去生成一个同等数量 RDD，RDD 里使用 partition 来相对应 HDFS 中的 block 。

## RDD五大特性

1. RDD是由一系列的 partition 组成。

   sprak 读取 HDFS 中数据的方法 textFile 底层是调用 MapReduce 读取 HDFS 文件的方法。

   首先会 split 对应一个 block，每个 split 对应生成 RDD 的每个 partition 。

2. 算子（函数或方法）作用在 RDD 的 partition 上。

   算子是单独作用在 partition 上的，有多少个 partition 就会并行执行多少次方法。

3. RDD 之间有依赖关系。

   就算中间的 RDD 丢失，也会通过依赖关系来生成新的 RDD。

4. 分区器是作用在 K，V 格式的 RDD 。

   K，V 格式的 RDD 就是 RDD 中的数据是一个个的 tuple2 数据

5. partition 提供数据计算的最佳位置，利于数据处理的本地化。



**从哪里体现了 RDD 的弹性（容错）**

1. RDD 之间有依赖关系。
2. RDD 的 partition 可多可少。