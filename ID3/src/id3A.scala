/**
 * Created by LY on 2015/4/17.
 */

import  scala.io.Source  //导入包
import  scala.collection.mutable.ArrayBuffer
import  scala.math._

object  id3A
{
  def main(args:Array[String])=
  {
    var info = ArrayBuffer[Double]() //定义信息熵缓冲数组
    var dataArray = ArrayBuffer[String]()   //定义原始数据存储缓冲数组
    var dataOutlook = new ArrayBuffer[String]
    var dataTemperature= new ArrayBuffer[String]
    var dataHumidity = new ArrayBuffer[String]
    var dataWind = new ArrayBuffer[String]
    var dataPlayTennis = new ArrayBuffer[String]

    val sourceData=Source.fromFile("data.txt","UTF-8")  //加载文件
    val lineIterator=sourceData.getLines() //读取文件的所有行，返回一个迭代器

    for(line <- lineIterator ) //遍历所有行
    {
      //println(line)   //打印所读到的行
      for(testData <- line.split("\\s+")) yield dataArray+=testData //分割所读到的行，将分割得到的数据加入缓冲数组
    }
    //dataArray.foreach(println)  //测试所读到的数据是否正确

    for(index <- 0.until(dataArray.length) if index > 6)
   {
      if(index%6==1)
        dataOutlook+=dataArray(index)
      if(index%6==2)
        dataTemperature+=dataArray(index)
      if(index%6==3)
        dataHumidity+=dataArray(index)
      if(index%6==4)
        dataWind+=dataArray(index)
      if(index%6==5)
        dataPlayTennis+=dataArray(index)
    }
    /*
    dataOutlook.foreach(println)
    dataTemperature.foreach(println)
    dataHumidity.foreach(println)
    dataWind.foreach(println)
    dataPlayTennis.foreach(println)
    */

    //计算总的信息熵
    var noSum:Int=0  //反例的个数
    val countSum=dataPlayTennis.length  //数据总数
    var yesSum:Int=0 //正例的个数
    for(data <- dataPlayTennis )
    {
      if(data == "no")
        noSum += 1
    }
    yesSum=countSum-noSum
    //println(countSum+" "+noSum+" "+yesSum)
    info+=(-(noSum.toDouble/countSum.toDouble)*log((noSum.toDouble/countSum.toDouble))-
                    (yesSum.toDouble/countSum.toDouble)*log((yesSum.toDouble/countSum.toDouble)))
    //println(info(0))

    //计算outlook的相关数据
    val mapData=dataOutlook.zip(dataPlayTennis)
    val overlookData=mapData.toMap.keySet//.filter(_.contains("Sunny"))
    val overlookCount=new Array[Int](overlookData.size)
    val sunnyNoAndYes = new Array[Int](2)
    val overCastNoAndYes = new Array[Int](2)
    val rainyNoAndYes = new Array[Int](2)
    for(data1 <- mapData)
    {
      if(data1._1 ==overlookData.head)
      {
         overlookCount(0) += 1
        if(data1._2 =="no")
          sunnyNoAndYes(0)+=1
      }
      if(data1._1 ==overlookData.tail.head) {
        overlookCount(1) += 1
        if(data1._2 =="no")
          overCastNoAndYes(0)+=1
      }
      if(data1._1 ==overlookData.tail.tail.head) {
        overlookCount(2) += 1
        if(data1._2 =="no")
          rainyNoAndYes(0)+=1
      }
    }

    sunnyNoAndYes(1)=overlookCount(0)-sunnyNoAndYes(0)
    overCastNoAndYes(1)=overlookCount(1)-overCastNoAndYes(0)
    rainyNoAndYes(1)=overlookCount(2)-rainyNoAndYes(0)

    /*
    println(mapData)
    println(overlookData)
    println(overlookCount(0))
    println(overlookCount(1))
    println(overlookCount(2))
    println(sunnyNoAndYes(0))
    println(sunnyNoAndYes(1))
    println(overCastNoAndYes(0))
    println(overCastNoAndYes(1))
    println(rainyNoAndYes(0))
    println(rainyNoAndYes(1))
    */
    //outlook信息熵计算（算法过于累赘，不具有普遍适用性，思考如何简化）
  }
}