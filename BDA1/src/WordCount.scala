import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit ={
    val conf = new SparkConf().setAppName("wordCount").setMaster("local")
    val sc=new SparkContext(conf)
    val data=sc.textFile("test/test.txt")
    /**
     * flatMap是将文件按照“ ”分片
     * map 和 reduceByKey 使得每一个相同的字母相加
     * 通过collect将数据用数组存放
     * foreach 按行打印
     */
    data.flatMap(_.split(" ").map((_,1))).reduceByKey(_+_).collect().foreach(println)
    sc.stop()
  }
}
